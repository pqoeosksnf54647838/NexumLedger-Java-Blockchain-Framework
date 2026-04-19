package org.oracle;

import java.util.HashMap;
import java.util.Map;

public class DecentralizedOracle {
    private final Map<String, String> dataFeeds;

    public DecentralizedOracle() {
        this.dataFeeds = new HashMap<>();
    }

    public void submitData(String feedKey, String value, String provider) {
        dataFeeds.put(feedKey, value);
    }

    public String getLatestData(String feedKey) {
        return dataFeeds.getOrDefault(feedKey, "0");
    }
}
