package org.identity;

import java.util.HashMap;
import java.util.Map;

public class ChainIdentityManager {
    private final Map<String, DigitalIdentity> identityMap;

    public ChainIdentityManager() {
        this.identityMap = new HashMap<>();
    }

    public void registerIdentity(String did, String publicKey, String metadata) {
        identityMap.put(did, new DigitalIdentity(did, publicKey, metadata));
    }

    public DigitalIdentity getIdentity(String did) {
        return identityMap.get(did);
    }
}

class DigitalIdentity {
    private final String did;
    private final String publicKey;
    private final String metadata;

    public DigitalIdentity(String did, String publicKey, String metadata) {
        this.did = did;
        this.publicKey = publicKey;
        this.metadata = metadata;
    }
}
