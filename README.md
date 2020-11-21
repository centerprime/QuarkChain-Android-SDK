# Quark-Chain-Client-SDK


## Table of Contents

- [Getting Started](#getting-started)
  - [Adding Quark-Chain Client SDK as a Maven Dependency](#adding-quark-chain-client-sdk-as-a-maven-dependency)
  - [Basic Usage](#basic-usage)
- [Features at a Glance](#features-at-a-glance)
  - [Create Wallet](#create-wallet)
  - [Import Wallet By Keystore](#import-wallet-by-keystore)
  - [Import Wallet By Private Key](#import-wallet-by-private-key)
  - [QKC Balance](#qkc-balance)
  - [Send QKC](#send-qkc)

## Getting Started

### Adding Quark-Chain Client SDK as a Maven Dependency

Maven:

```xml
<dependency>
	    <groupId>com.github.centerprime</groupId>
	    <artifactId>Quark-Chain-Client-SDK</artifactId>
	    <version>1.0.3</version>
</dependency>
```

Gradle:

```groovy
dependencies {
     implementation 'com.github.centerprime:Quark-Chain-Client-SDK:1.0.5'

}
```

### Basic Usage

Once you have the dependencies set up you can start using *CenterPrime* by creating a `Quark-Chain Wallet`:

```java

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        QKCManager qkcManager = QKCManager.getInstance();

        qkcManager.createWallet("12345", this)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(wallet -> {
                    String walletAddress = wallet.getAddress();
                    String keystore = wallet.getKeystore();
		    
		    String qckWalletAddress = QKCManager.
                            getQCKAddress(walletAddress,this);
		    int chainId = 1;
		    int shardId = 0;
 	 	    String chainId1 = QKCManager.getQCKAddressByChainIdAndShardId(qckWalletAddress, chainId , shardId, this);
		    
		    
                }, error -> {
                    System.out.println(error);
                });
    }
}
```

*Congratulations!* Now you are a *CenterPrime* user.

## Features at a Glance

### Create Wallet

> You can create Quark-Chain Wallet.
```java
QKCManager qkcManager = QKCManager.getInstance();

qkcManager.createWallet("12345", this)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(wallet -> {
                    String walletAddress = wallet.getAddress();
                    String keystore = wallet.getKeystore();
		   
		    String qckWalletAddress = QKCManager.
                            getQCKAddress(walletAddress,this);
		    int chainId = 1;
		    int shardId = 0;
 	 	    String chainId1 = QKCManager.getQCKAddressByChainIdAndShardId(qckWalletAddress, chainId , shardId, this);

		    
		    
                }, error -> {
                    System.out.println(error);
                });

```

### Import Wallet By Keystore

> Import Quark-Chain Wallet by Keystore.

```java
QKCManager qkcManager = QKCManager.getInstance();
String password = "xxxx12345";
String keystore = "JSON_FORMAT";
qkcManager.importFromKeystore(keystore, password, this)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(walletAddress -> {

                    Toast.makeText(this, "Wallet Address : " + walletAddress, Toast.LENGTH_SHORT).show();

                }, error -> {

                });
```
### Import Wallet By Private Key

> Import Wallet By Private Key.

```java
QKCManager qkcManager = QKCManager.getInstance();
String privateKey = "PRIVATE_KEY";
qkcManager.importFromPrivateKey(privateKey, this)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(walletAddress -> {

                    Toast.makeText(this, "Wallet Address : " + walletAddress, Toast.LENGTH_SHORT).show();

                }, error -> {

                });
```


### QKC Balance

> QKC Balance.

```java
QKCManager qkcManager = QKCManager.getInstance();
qkcManager.init("http://jrpc.mainnet.quarkchain.io:38391");
String walletAddress = "WALLET_ADDRESS";
qkcManager.getQKCBalance(walletAddress)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(balance -> {

                    Toast.makeText(this, "QKC Balance : " + balance, Toast.LENGTH_SHORT).show();

                }, error -> {

                });
```
### Send QKC

> Send QKC.

```java
QKCManager qkcManager = QKCManager.getInstance();
qkcManager.init("http://jrpc.mainnet.quarkchain.io:38391");
String walletAddress = "WALLET_ADDRESS";
String password = "WALLET_PASSWORD";
BigInteger gasPrice = new BigInteger("GAS_PRICE");
BigInteger gasLimit = new BigInteger("GAS_LIMIT");
BigDecimal qkcAmount = new BigDecimal("QKC_AMOUNT");
String fromAddress = "SENDER_WALLET_ADDRESS";
String receiverAddress = "RECEIVER_WALLET_ADDRESS";
qkcManager.sendQKCToken(walletAddress, password, fromAddress, receiverAddress,gasPrice, gasLimit, qkcAmount, this)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(tx -> {

                    Toast.makeText(this, "TX : " + tx, Toast.LENGTH_SHORT).show();

                }, error -> {

                });
```

