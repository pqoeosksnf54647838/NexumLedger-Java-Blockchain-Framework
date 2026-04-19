package org.monitor;

import org.p2p.P2PNetworkNode;
import java.util.List;

public class NodeMonitor {
    private final P2PNetworkNode node;
    private long lastBlockTimestamp;

    public NodeMonitor(P2PNetworkNode node) {
        this.node = node;
        this.lastBlockTimestamp = System.currentTimeMillis();
    }

    public void updateBlockActivity() {
        this.lastBlockTimestamp = System.currentTimeMillis();
    }

    public boolean isNodeActive() {
        return (System.currentTimeMillis() - lastBlockTimestamp) < 300000;
    }

    public int getPeerCount() {
        return node.getPeerList().size();
    }
}
