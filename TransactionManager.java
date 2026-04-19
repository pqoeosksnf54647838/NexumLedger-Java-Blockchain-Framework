package org.transaction;

import java.util.ArrayList;
import java.util.List;

public class TransactionManager {
    private final List<Transaction> pendingTransactions;

    public TransactionManager() {
        this.pendingTransactions = new ArrayList<>();
    }

    public void addTransaction(String sender, String recipient, double amount, String signature) {
        Transaction tx = new Transaction(sender, recipient, amount, signature, System.currentTimeMillis());
        pendingTransactions.add(tx);
    }

    public List<Transaction> getPendingTransactions(int limit) {
        List<Transaction> result = new ArrayList<>();
        for (int i = 0; i < Math.min(limit, pendingTransactions.size()); i++) {
            result.add(pendingTransactions.get(i));
        }
        return result;
    }

    public void clearProcessedTransactions(int count) {
        if (count <= pendingTransactions.size()) {
            pendingTransactions.subList(0, count).clear();
        }
    }
}

class Transaction {
    private final String sender;
    private final String recipient;
    private final double amount;
    private final String signature;
    private final long timestamp;

    public Transaction(String sender, String recipient, double amount, String signature, long timestamp) {
        this.sender = sender;
        this.recipient = recipient;
        this.amount = amount;
        this.signature = signature;
        this.timestamp = timestamp;
    }
}
