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
        QKCManager.init("https://mainnet.infura.io/v3/eb4c55b5263f4ab8b2c8c8934f422930");
        QKCManager.createWallet("12345",this)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(wallet -> {
                    System.out.println(wallet);
                    String walletAddress = wallet.getAddress();
                    String qckWalletAddress = QKCManager.
                            getQCKAddress(walletAddress,this);

                    System.out.println(qckWalletAddress);

                    String shard1 = QKCManager.getQCKAddressByChainIdAndShardId(qckWalletAddress,1,0,this);

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