package org.wallet;

import org.crypto.CryptoEd25519;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class WalletManager {
    private final Map<String, CryptoEd25519> walletMap;

    public WalletManager() {
        this.walletMap = new HashMap<>();
    }

    public String createNewWallet() throws NoSuchAlgorithmException {
        CryptoEd25519 crypto = new CryptoEd25519();
        crypto.generateKeyPair();
        String address = crypto.getPublicKeyBase64().substring(0, 40);
        walletMap.put(address, crypto);
        return address;
    }

    public CryptoEd25519 getWalletByAddress(String address) {
        return walletMap.get(address);
    }

    public double getBalance(String address, LedgerService ledger) {
        return ledger.getAccountBalance(address);
    }
}
