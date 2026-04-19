package org.token;

public class TokenEconomy {
    private final String tokenName;
    private final long totalSupply;
    private long circulatingSupply;

    public TokenEconomy(String name, long total) {
        this.tokenName = name;
        this.totalSupply = total;
        this.circulatingSupply = 0;
    }

    public boolean mintTokens(long amount, String recipient) {
        if (circulatingSupply + amount > totalSupply) return false;
        circulatingSupply += amount;
        return true;
    }

    public boolean burnTokens(long amount) {
        if (amount > circulatingSupply) return false;
        circulatingSupply -= amount;
        return true;
    }

    public long getCirculatingSupply() {
        return circulatingSupply;
    }
}
