# Quark-Chain-Client-SDK


## Table of Contents

- [Getting Started](#getting-started)
  - [Adding Quark-Chain SDK as a Maven Dependency](#adding-ethereum-sdk-as-a-maven-dependency)
  - [Basic Usage](#basic-usage)
- [Features at a Glance](#features-at-a-glance)
  - [Create Wallet](#create-wallet)
  - [Import Wallet By Keystore](#import-wallet-by-keystore)
  - [Import Wallet By Private Key](#import-wallet-by-private-key)
  - [QCK Balance](#ethereum-balance)
  - [Send QCK Token](#send-erc20-token)

## Getting Started

### Adding Quark-Chain Client SDK as a Maven Dependency

Maven:

```xml
<dependency>
	    <groupId>com.github.centerprime</groupId>
	    <artifactId>Binance-Chain-Client-SDK</artifactId>
	    <version>1.0.1</version>
</dependency>
```

Gradle:

```groovy
dependencies {
    implementation 'com.github.centerprime:Binance-Chain-Client-SDK:1.0.1'
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

        QCKManager QKCManager = QCKManager.getInstance();

        QKCManager.createWallet("12345", this)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(wallet -> {
                    String walletAddress = wallet.getAddress();
                    String keystore = wallet.getKeystore();
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
QCKManager QKCManager = QCKManager.getInstance();

QKCManager.createWallet("12345", this)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(wallet -> {
                    String walletAddress = wallet.getAddress();
                    String keystore = wallet.getKeystore();
                }, error -> {
                    System.out.println(error);
                });

```

### Import Wallet By Keystore

> Import Quark-Chain Wallet by Keystore.

```java
QCKManager QKCManager = QCKManager.getInstance();
String password = "xxxx12345";
String keystore = "JSON_FORMAT";
QKCManager.importFromKeystore(keystore, password, this)
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
QCKManager QKCManager = QCKManager.getInstance();
String privateKey = "PRIVATE_KEY";
QKCManager.importFromPrivateKey(privateKey, this)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(walletAddress -> {

                    Toast.makeText(this, "Wallet Address : " + walletAddress, Toast.LENGTH_SHORT).show();

                }, error -> {

                });
```


### QCK Balance

> QCK Balance.

```java
QCKManager QKCManager = QCKManager.getInstance();
QKCManager.init("http://jrpc.mainnet.quarkchain.io:38391");
String walletAddress = "WALLET_ADDRESS";
QKCManager.getQCKBalance(walletAddress)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(balance -> {

                    Toast.makeText(this, "QCK Balance : " + balance, Toast.LENGTH_SHORT).show();

                }, error -> {

                });
```
### Send QCK

> Send QCK.

```java
QCKManager QKCManager = QCKManager.getInstance();
QKCManager.init("http://jrpc.mainnet.quarkchain.io:38391");
String walletAddress = "WALLET_ADDRESS";
String password = "WALLET_PASSWORD";
BigInteger gasPrice = new BigInteger("GAS_PRICE");
BigInteger gasLimit = new BigInteger("GAS_LIMIT");
BigDecimal qckAmount = new BigDecimal("QCK_AMOUNT");
String fromAddress = "SENDER_WALLET_ADDRESS";
String receiverAddress = "RECEIVER_WALLET_ADDRESS";
QKCManager.sendQCKToken(walletAddress, password, fromAddress, receiverAddress,gasPrice, gasLimit, qckAmount, this)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(tx -> {

                    Toast.makeText(this, "TX : " + tx, Toast.LENGTH_SHORT).show();

                }, error -> {

                });
```

