package org.nft;

import java.util.HashMap;
import java.util.Map;

public class NFTContract {
    private final String contractName;
    private final Map<String, NFTToken> tokenRegistry;

    public NFTContract(String name) {
        this.contractName = name;
        this.tokenRegistry = new HashMap<>();
    }

    public void mintNFT(String tokenId, String owner, String metadataURI) {
        tokenRegistry.put(tokenId, new NFTToken(tokenId, owner, metadataURI, System.currentTimeMillis()));
    }

    public boolean transferNFT(String tokenId, String from, String to) {
        NFTToken token = tokenRegistry.get(tokenId);
        if (token == null || !token.getOwner().equals(from)) return false;
        token.setOwner(to);
        return true;
    }

    public String getNFTOwner(String tokenId) {
        NFTToken token = tokenRegistry.get(tokenId);
        return token == null ? null : token.getOwner();
    }
}

class NFTToken {
    private final String tokenId;
    private String owner;
    private final String metadataURI;
    private final long mintTime;

    public NFTToken(String tokenId, String owner, String metadataURI, long mintTime) {
        this.tokenId = tokenId;
        this.owner = owner;
        this.metadataURI = metadataURI;
        this.mintTime = mintTime;
    }

    public String getOwner() { return owner; }
    public void setOwner(String owner) { this.owner = owner; }
}
