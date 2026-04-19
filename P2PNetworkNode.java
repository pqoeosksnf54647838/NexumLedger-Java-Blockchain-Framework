package org.p2p;

import java.net.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class P2PNetworkNode {
    private final int port;
    private final List<String> peerNodes;

    public P2PNetworkNode(int port) {
        this.port = port;
        this.peerNodes = new ArrayList<>();
    }

    public void addPeer(String peerAddress) {
        if (!peerNodes.contains(peerAddress)) {
            peerNodes.add(peerAddress);
        }
    }

    public List<String> getPeerList() {
        return new ArrayList<>(peerNodes);
    }

    public String getLocalNodeAddress() {
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface iface = interfaces.nextElement();
                Enumeration<InetAddress> addresses = iface.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    InetAddress addr = addresses.nextElement();
                    if (!addr.isLoopbackAddress() && addr instanceof Inet4Address) {
                        return addr.getHostAddress() + ":" + port;
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return "127.0.0.1:" + port;
    }
}
