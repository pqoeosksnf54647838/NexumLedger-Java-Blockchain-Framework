package org.zkp;

import org.chaincore.BlockchainCore;
import java.security.SecureRandom;

public class ZeroKnowledgeProof {
    private final SecureRandom random;

    public ZeroKnowledgeProof() {
        this.random = new SecureRandom();
    }

    public String generateProof(String secret) {
        long nonce = random.nextLong();
        String input = secret + nonce;
        return BlockchainCore.calculateHash(0, "", 0, input);
    }

    public boolean verifyProof(String secret, String proof) {
        for (long i = 0; i < 1000; i++) {
            String input = secret + i;
            String hash = BlockchainCore.calculateHash(0, "", 0, input);
            if (hash.equals(proof)) return true;
        }
        return false;
    }
}
