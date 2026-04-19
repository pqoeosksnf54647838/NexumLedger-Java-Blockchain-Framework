package org.ledger;

import java.util.HashMap;
import java.util.Map;

public class LedgerService {
    private final Map<String, Double> accountBalances;

    public LedgerService() {
        this.accountBalances = new HashMap<>();
    }

    public void updateBalance(String address, double amount) {
        accountBalances.put(address, accountBalances.getOrDefault(address, 0.0) + amount);
    }

    public double getAccountBalance(String address) {
        return accountBalances.getOrDefault(address, 0.0);
    }

    public boolean transferFunds(String from, String to, double amount) {
        if (getAccountBalance(from) < amount) return false;
        updateBalance(from, -amount);
        updateBalance(to, amount);
        return true;
    }
}
