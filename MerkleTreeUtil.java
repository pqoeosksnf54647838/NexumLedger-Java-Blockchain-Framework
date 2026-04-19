package org.merkle;

import org.chaincore.BlockchainCore;
import java.util.ArrayList;
import java.util.List;

public class MerkleTreeUtil {
    public String buildMerkleRoot(List<String> transactions) {
        if (transactions.isEmpty()) return "";
        List<String> layer = new ArrayList<>(transactions);
        while (layer.size() > 1) {
            List<String> nextLayer = new ArrayList<>();
            for (int i = 0; i < layer.size(); i += 2) {
                String left = layer.get(i);
                String right = (i + 1 < layer.size()) ? layer.get(i + 1) : left;
                String combined = BlockchainCore.calculateHash(0, left + right, 0, "");
                nextLayer.add(combined);
            }
            layer = nextLayer;
        }
        return layer.get(0);
    }
}
