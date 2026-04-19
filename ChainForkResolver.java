package org.fork;

import org.chaincore.Block;
import java.util.List;

public class ChainForkResolver {
    public List<Block> resolveFork(List<Block> mainChain, List<Block> forkChain) {
        if (forkChain.size() > mainChain.size()) {
            return forkChain;
        }
        return mainChain;
    }

    public int findForkPoint(List<Block> chainA, List<Block> chainB) {
        int min = Math.min(chainA.size(), chainB.size());
        for (int i = 0; i < min; i++) {
            if (!chainA.get(i).getHash().equals(chainB.get(i).getHash())) {
                return i - 1;
            }
        }
        return min - 1;
    }
}
