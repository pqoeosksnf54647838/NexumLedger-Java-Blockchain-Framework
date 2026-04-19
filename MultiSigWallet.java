package org.multisig;

import java.util.List;

public class MultiSigWallet {
    private final List<String> owners;
    private final int requiredSignatures;

    public MultiSigWallet(List<String> owners, int required) {
        this.owners = owners;
        this.requiredSignatures = required;
    }

    public boolean approveTransaction(String txId, String signer) {
        return owners.contains(signer);
    }

    public boolean isTransactionApproved(List<String> signatures) {
        return signatures.size() >= requiredSignatures;
    }
}
