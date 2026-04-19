package org.whitelist;

import java.util.HashSet;
import java.util.Set;

public class ChainWhiteList {
    private final Set<String> allowedAddresses;

    public ChainWhiteList() {
        this.allowedAddresses = new HashSet<>();
    }

    public void addAddress(String address) {
        allowedAddresses.add(address);
    }

    public boolean isAddressAllowed(String address) {
        return allowedAddresses.contains(address);
    }
}
