package com.centerprime.quarkchainsdk.quarck;

import android.content.Context;
import android.os.Build;

import org.conscrypt.OpenSSLProvider;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.Security;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;

public class HttpUtils {
    // 证书数据
    private static List<byte[]> CERTIFICATES_DATA = new ArrayList<>();

    /**
     * 添加https证书
     */
    private synchronized static void addCertificate(InputStream inputStream) {
        if (inputStream != null) {
            try {
                int ava = 0;// 数据当次可读长度
                int len = 0;// 数据总长度
                ArrayList<byte[]> data = new ArrayList<>();
                while ((ava = inputStream.available()) > 0) {
                    byte[] buffer = new byte[ava];
                    inputStream.read(buffer);
                    data.add(buffer);
                    len += ava;
                }

                byte[] buff = new byte[len];
                int dstPos = 0;
                for (byte[] bytes : data) {
                    int length = bytes.length;
                    System.arraycopy(bytes, 0, buff, dstPos, length);
                    dstPos += length;
                }

                CERTIFICATES_DATA.add(buff);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    // 添加https证书
    private static void initSSL(Context context) {
        try {
            String[] certFiles = context.getAssets().list("certs");
            if (certFiles != null) {
                for (String cert : certFiles) {
                    InputStream is = context.getAssets().open("certs/" + cert);
                    addCertificate(is); // 这里将证书读取出来，，放在配置中byte[]里
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();

        }
    }

    /**
     * https证书
     */
    public static List<byte[]> getCertificatesData() {
        return CERTIFICATES_DATA;
    }

    private static SSLSocketFactory getSocketFactory(List<InputStream> certificates) {
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null);
            try {
                for (int i = 0, size = certificates.size(); i < size; ) {
                    InputStream certificate = certificates.get(i);
                    String certificateAlias = Integer.toString(i++);
                    keyStore.setCertificateEntry(certificateAlias, certificateFactory.generateCertificate(certificate));
                    if (certificate != null)
                        certificate.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            SSLContext sslContext = SSLContext.getInstance("TLS");
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(keyStore);
            sslContext.init(null,
                    trustManagerFactory.getTrustManagers(),
                    new SecureRandom()
            );
            return sslContext.getSocketFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static OkHttpClient getSSLOkHttp(Context context) {
        if (CERTIFICATES_DATA.isEmpty()) {
            initSSL(context);
        }

        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        // 添加证书
        List<InputStream> certificates = new ArrayList<>();
        List<byte[]> certs_data = getCertificatesData();
        // 将字节数组转为数组输入流
        if (certs_data != null && !certs_data.isEmpty()) {
            for (byte[] bytes : certs_data) {
                certificates.add(new ByteArrayInputStream(bytes));
            }
        }

        SSLSocketFactory sslSocketFactory = getSocketFactory(certificates);
        if (sslSocketFactory != null) {
            builder.sslSocketFactory(sslSocketFactory);
        }

//        builder.proxy(Proxy.NO_PROXY);
        return builder.build();
    }


    public static OkHttpClient getOkHttp() {
        //修复android5.0以下访问网络失败
        if (Build.VERSION.SDK_INT < 21 && Security.getProvider("Okhttp") == null) {
            Security.insertProviderAt(new OpenSSLProvider("Okhttp"), 1);
        }
        //OKHttp信任所有证书，修复部分证书校验严格网址访问崩溃
        try {
            // Create a trust manager that does not validate certificate chains
            X509TrustManager manager = new X509TrustManager() {
                @Override
                public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) {
                }

                @Override
                public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) {
                }

                @Override
                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return new java.security.cert.X509Certificate[]{};
                }
            };

            // Install the all-trusting trust manager
            final SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, new TrustManager[]{
                    manager
            }, new SecureRandom());
            // Create an ssl socket factory with our all-trusting manager
            final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.sslSocketFactory(sslSocketFactory, manager);
            builder.hostnameVerifier((String hostname, SSLSession session) -> true);
            return builder.build();
        } catch (Exception e) {
            e.printStackTrace();
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.hostnameVerifier((String hostname, SSLSession session) -> true);
            return builder.build();
        }
    }
}
