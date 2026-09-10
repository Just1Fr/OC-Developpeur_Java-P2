package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;

public class WriteSymptomDataToFile implements ISymptomWriter {

    private String filePath;

    /**
	 * @param filePath : full or partial path to the output file
	 */
    public WriteSymptomDataToFile(String filePath) {
        this.filePath = Objects.requireNonNull(filePath, "filePath must not be null");
    }

    @Override
    public void writeSymptoms(Map<String, Integer> symptomsCounts) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (Map.Entry<String, Integer> entry : symptomsCounts.entrySet()) {
                String line = entry.getKey() + " : " + entry.getValue() + "\n";
                writer.write(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}