package org.storage;

import java.io.*;
import java.util.List;

public class ChainDataStorage {
    private final String storagePath;

    public ChainDataStorage(String path) {
        this.storagePath = path;
        new File(path).mkdirs();
    }

    public void saveBlockToDisk(String blockJson, long blockHeight) throws IOException {
        File file = new File(storagePath + "/block_" + blockHeight + ".dat");
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(blockJson);
        }
    }

    public String loadBlockFromDisk(long blockHeight) throws IOException {
        File file = new File(storagePath + "/block_" + blockHeight + ".dat");
        if (!file.exists()) return null;
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        }
        return content.toString();
    }
}
