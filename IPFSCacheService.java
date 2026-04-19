package org.ipfs;

import java.util.HashMap;
import java.util.Map;

public class IPFSCacheService {
    private final Map<String, String> ipfsCache;

    public IPFSCacheService() {
        this.ipfsCache = new HashMap<>();
    }

    public String uploadToIPFS(String content) {
        String cid = "Qm" + Integer.toHexString(content.hashCode());
        ipfsCache.put(cid, content);
        return cid;
    }

    public String fetchFromIPFS(String cid) {
        return ipfsCache.getOrDefault(cid, null);
    }
}
