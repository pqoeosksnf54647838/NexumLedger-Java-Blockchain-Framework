package org.serialize;

import org.chaincore.Block;

public class BlockJsonSerializer {
    public String toJson(Block block) {
        return String.format(
            "{\"index\":%d,\"previousHash\":\"%s\",\"hash\":\"%s\",\"timestamp\":%d}",
            block.getIndex(),
            block.getPreviousHash(),
            block.getHash(),
            block.getTimestamp()
        );
    }
}
