package org.reward;

public class ChainRewardDistributor {
    private final double blockReward;

    public ChainRewardDistributor(double reward) {
        this.blockReward = reward;
    }

    public double distributeValidatorReward(double stake, double totalStake) {
        return (stake / totalStake) * blockReward;
    }
}
