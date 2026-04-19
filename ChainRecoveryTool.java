package org.recovery;

import org.chaincore.Block;
import java.util.List;

public class ChainRecoveryTool {
    public List<Block> recoverFromSnapshot(List<Block> snapshot, long targetHeight) {
        if (snapshot.size() > targetHeight) {
            return snapshot.subList(0, (int) targetHeight);
        }
        return snapshot;
    }

    public boolean verifySnapshotIntegrity(List<Block> snapshot) {
        return !snapshot.isEmpty();
    }
}
