package org.sync;

import org.chaincore.Block;
import java.util.List;

public class ChainSyncService {
    public List<Block> syncLongestChain(List<Block> localChain, List<Block> remoteChain) {
        if (remoteChain.size() > localChain.size()) {
            return remoteChain;
        }
        return localChain;
    }

    public boolean isChainCompatible(List<Block> chainA, List<Block> chainB) {
        int minSize = Math.min(chainA.size(), chainB.size());
        for (int i = 0; i < minSize; i++) {
            if (!chainA.get(i).getHash().equals(chainB.get(i).getHash())) {
                return false;
            }
        }
        return true;
    }
}
