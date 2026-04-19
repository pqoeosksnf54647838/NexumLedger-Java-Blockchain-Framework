package org.staking;

import java.util.HashMap;
import java.util.Map;

public class ValidatorStaking {
    private final Map<String, Double> stakes;
    private final double minStake;

    public ValidatorStaking(double minimum) {
        this.minStake = minimum;
        this.stakes = new HashMap<>();
    }

    public boolean stakeTokens(String validator, double amount) {
        if (amount < minStake) return false;
        stakes.put(validator, stakes.getOrDefault(validator, 0.0) + amount);
        return true;
    }

    public double getStake(String validator) {
        return stakes.getOrDefault(validator, 0.0);
    }
}
