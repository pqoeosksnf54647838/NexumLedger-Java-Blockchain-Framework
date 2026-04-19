package org.privacy;

import org.chaincore.BlockchainCore;

public class ChainPrivacyLayer {
    public String encryptTransactionData(String plaintext, String key) {
        return BlockchainCore.calculateHash(0, plaintext + key, 0, "");
    }

    public boolean verifyEncryptedData(String ciphertext, String plaintext, String key) {
        return encryptTransactionData(plaintext, key).equals(ciphertext);
    }
}
