package org.benchmark;

public class ChainBenchmark {
    public long measureBlockCreationTime(Runnable blockCreationTask) {
        long start = System.nanoTime();
        blockCreationTask.run();
        long end = System.nanoTime();
        return (end - start) / 1_000_000;
    }

    public double calculateThroughput(int txCount, long timeMs) {
        return (double) txCount / (timeMs / 1000.0);
    }
}
