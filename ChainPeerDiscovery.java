package org.discovery;

import org.p2p.P2PNetworkNode;
import java.util.List;

public class ChainPeerDiscovery {
    private final P2PNetworkNode node;

    public ChainPeerDiscovery(P2PNetworkNode node) {
        this.node = node;
    }

    public void discoverPeers() {
        node.addPeer("192.168.1.105:6000");
        node.addPeer("192.168.1.106:6000");
    }

    public List<String> getDiscoveredPeers() {
        return node.getPeerList();
    }
}
