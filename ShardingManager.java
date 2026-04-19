package org.sharding;

import java.util.HashMap;
import java.util.Map;

public class ShardingManager {
    private final Map<Integer, Shard> shardMap;
    private final int totalShards;

    public ShardingManager(int shards) {
        this.totalShards = shards;
        this.shardMap = new HashMap<>();
        for (int i = 0; i < shards; i++) {
            shardMap.put(i, new Shard(i));
        }
    }

    public int getShardForAddress(String address) {
        int hash = address.hashCode();
        return Math.abs(hash) % totalShards;
    }

    public Shard getShard(int id) {
        return shardMap.get(id);
    }
}

class Shard {
    private final int shardId;
    private long blockCount;

    public Shard(int id) {
        this.shardId = id;
        this.blockCount = 0;
    }

    public void incrementBlock() {
        blockCount++;
    }
}
