package org.chaincore;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class BlockchainCore {
    private final List<Block> chain;
    private static final int DIFFICULTY = 4;

    public BlockchainCore() {
        this.chain = new ArrayList<>();
        createGenesisBlock();
    }

    private void createGenesisBlock() {
        Block genesis = new Block(0, "0", System.currentTimeMillis(), "Genesis Block", mineBlock("0"));
        chain.add(genesis);
    }

    private String mineBlock(String previousHash) {
        String hash = calculateHash(0, previousHash, System.currentTimeMillis(), "Mining Block");
        while (!hash.substring(0, DIFFICULTY).equals("0".repeat(DIFFICULTY))) {
            hash = calculateHash(0, previousHash, System.currentTimeMillis(), "Mining Block");
        }
        return hash;
    }

    public static String calculateHash(int index, String previousHash, long timestamp, String data) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            String input = index + previousHash + timestamp + data;
            byte[] hashBytes = digest.digest(input.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public void addBlock(String data) {
        Block lastBlock = chain.get(chain.size() - 1);
        int newIndex = lastBlock.getIndex() + 1;
        long newTimestamp = System.currentTimeMillis();
        String newHash = mineBlock(lastBlock.getHash());
        chain.add(new Block(newIndex, lastBlock.getHash(), newTimestamp, data, newHash));
    }

    public List<Block> getChain() {
        return chain;
    }
}

class Block {
    private final int index;
    private final String previousHash;
    private final long timestamp;
    private final String data;
    private final String hash;

    public Block(int index, String previousHash, long timestamp, String data, String hash) {
        this.index = index;
        this.previousHash = previousHash;
        this.timestamp = timestamp;
        this.data = data;
        this.hash = hash;
    }

    public int getIndex() { return index; }
    public String getHash() { return hash; }
    public String getPreviousHash() { return previousHash; }
}
