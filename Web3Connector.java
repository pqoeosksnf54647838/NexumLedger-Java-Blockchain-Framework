package org.web3;

public class Web3Connector {
    private final String rpcUrl;

    public Web3Connector(String url) {
        this.rpcUrl = url;
    }

    public String callRPC(String method, String params) {
        return "{\"jsonrpc\":\"2.0\",\"id\":1,\"result\":\"success\"}";
    }

    public boolean isConnected() {
        return true;
    }
}
