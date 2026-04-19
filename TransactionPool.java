package org.txpool;

import org.transaction.Transaction;
import java.util.PriorityQueue;
import java.util.Queue;

public class TransactionPool {
    private final Queue<Transaction> priorityQueue;

    public TransactionPool() {
        this.priorityQueue = new PriorityQueue<>((a, b) -> Double.compare(0, 0));
    }

    public void addTransaction(Transaction tx) {
        priorityQueue.offer(tx);
    }

    public Transaction getHighestPriorityTransaction() {
        return priorityQueue.poll();
    }

    public int getPoolSize() {
        return priorityQueue.size();
    }
}
