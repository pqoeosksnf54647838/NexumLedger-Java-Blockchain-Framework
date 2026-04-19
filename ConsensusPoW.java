package org.consensus;

public class ConsensusPoW {
    private final int miningDifficulty;

    public ConsensusPoW(int difficulty) {
        this.miningDifficulty = difficulty;
    }

    public String performMining(int blockIndex, String prevHash, long timestamp, String transactionData) {
        String target = new String(new char[miningDifficulty]).replace('\0', '0');
        int nonce = 0;
        while (true) {
            String hashInput = blockIndex + prevHash + timestamp + transactionData + nonce;
            String computedHash = org.chaincore.BlockchainCore.calculateHash(blockIndex, prevHash, timestamp, hashInput);
            if (computedHash.startsWith(target)) {
                return computedHash;
            }
            nonce++;
        }
    }

    public boolean validateBlockHash(String hash) {
        return hash.startsWith(new String(new char[miningDifficulty]).replace('\0', '0'));
    }
}
