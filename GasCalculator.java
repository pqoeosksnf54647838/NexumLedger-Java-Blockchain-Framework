package org.gas;

public class GasCalculator {
    private final long baseFee;

    public GasCalculator(long base) {
        this.baseFee = base;
    }

    public long calculateTransactionGas(String data) {
        return baseFee + (data.length() * 2L);
    }

    public long calculateContractGas(String method) {
        return switch (method) {
            case "transfer" -> 21000;
            case "mint" -> 50000;
            default -> 30000;
        };
    }
}
