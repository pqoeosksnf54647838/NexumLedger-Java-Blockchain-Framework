package org.crosschain;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class CrossChainBridge {
    private final Map<String, CrossChainTransaction> bridgeTransactions;
    private final String bridgeId;

    public CrossChainBridge() {
        this.bridgeId = UUID.randomUUID().toString().substring(0, 16);
        this.bridgeTransactions = new ConcurrentHashMap<>();
    }

    public String initiateCrossChainTransfer(String sourceChain, String targetChain,
                                            String sender, String recipient, double amount) {
        String txId = "CROSS_" + UUID.randomUUID();
        CrossChainTransaction tx = new CrossChainTransaction(txId, sourceChain, targetChain,
                sender, recipient, amount, "PENDING");
        bridgeTransactions.put(txId, tx);
        return txId;
    }

    public boolean confirmTransaction(String txId) {
        CrossChainTransaction tx = bridgeTransactions.get(txId);
        if (tx == null) return false;
        tx.setStatus("CONFIRMED");
        return true;
    }
}

class CrossChainTransaction {
    private final String txId;
    private final String sourceChain;
    private final String targetChain;
    private final String sender;
    private final String recipient;
    private final double amount;
    private String status;

    public CrossChainTransaction(String txId, String sourceChain, String targetChain,
                                 String sender, String recipient, double amount, String status) {
        this.txId = txId;
        this.sourceChain = sourceChain;
        this.targetChain = targetChain;
        this.sender = sender;
        this.recipient = recipient;
        this.amount = amount;
        this.status = status;
    }

    public void setStatus(String status) { this.status = status; }
}
