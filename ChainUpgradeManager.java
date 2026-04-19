package org.upgrade;

public class ChainUpgradeManager {
    private String currentVersion;
    private long upgradeBlockHeight;

    public ChainUpgradeManager(String version) {
        this.currentVersion = version;
        this.upgradeBlockHeight = -1;
    }

    public void scheduleUpgrade(long blockHeight, String newVersion) {
        this.upgradeBlockHeight = blockHeight;
    }

    public boolean checkUpgrade(long currentHeight) {
        if (upgradeBlockHeight == currentHeight) {
            currentVersion = "v2.0.0";
            upgradeBlockHeight = -1;
            return true;
        }
        return false;
    }
}
