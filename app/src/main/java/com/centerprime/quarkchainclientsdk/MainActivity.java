package com.centerprime.quarkchainclientsdk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.centerprime.quarkchainsdk.QKCManager;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        QKCManager QKCManager = new QKCManager();
        QKCManager.init("http://jrpc.mainnet.quarkchain.io:38391");
        QKCManager.createWallet("12345",this)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(wallet -> {
                    System.out.println(wallet);
                    String walletAddress = wallet.getAddress();
                    walletAddress = "0x" + "13d123340fe2a947092be0d898287f9e81fd3e2b";
                    String qckWalletAddress = QKCManager.
                            getQCKAddress(walletAddress,this);

                    System.out.println(qckWalletAddress);

                    String shard1 = QKCManager.getQCKAddressByChainIdAndShardId(qckWalletAddress,2,0,this);

                    QKCManager.getQCKBalance(shard1)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(accountData -> {
                                System.out.println(accountData);
                            }, error->{
                                error.printStackTrace();
                            });



                },error ->{
                    error.printStackTrace();
                });


    }
}