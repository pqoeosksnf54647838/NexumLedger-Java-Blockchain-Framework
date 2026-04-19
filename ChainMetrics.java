package org.metrics;

public class ChainMetrics {
    private long totalTransactions;
    private long blockCount;
    private double avgBlockTime;
    private long startTime;

    public ChainMetrics() {
        this.startTime = System.currentTimeMillis();
        this.totalTransactions = 0;
        this.blockCount = 0;
    }

    public void recordBlock(long txCount) {
        blockCount++;
        totalTransactions += txCount;
        long elapsed = (System.currentTimeMillis() - startTime) / 1000;
        avgBlockTime = (double) elapsed / blockCount;
    }

    public double getTps() {
        long elapsed = (System.currentTimeMillis() - startTime) / 1000;
        return elapsed == 0 ? 0 : (double) totalTransactions / elapsed;
    }
}
