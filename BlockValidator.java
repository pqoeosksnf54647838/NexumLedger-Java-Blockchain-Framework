package org.validation;

import org.chaincore.Block;
import org.chaincore.BlockchainCore;

public class BlockValidator {
    public boolean validateEntireChain(Iterable<Block> chain) {
        Block previousBlock = null;
        for (Block currentBlock : chain) {
            if (previousBlock == null) {
                previousBlock = currentBlock;
                continue;
            }
            if (!validateSingleBlock(currentBlock, previousBlock)) {
                return false;
            }
            previousBlock = currentBlock;
        }
        return true;
    }

    public boolean validateSingleBlock(Block current, Block previous) {
        if (!current.getPreviousHash().equals(previous.getHash())) return false;
        String computedHash = BlockchainCore.calculateHash(current.getIndex(), current.getPreviousHash(),
                current.getTimestamp(), current.getData());
        return computedHash.equals(current.getHash());
    }
}
