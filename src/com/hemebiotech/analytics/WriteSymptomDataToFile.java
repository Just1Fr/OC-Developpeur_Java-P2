package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {

    private final String FILE_PATH;

    /**
	 * @param filePath full or partial path to the output file
	 */
    public WriteSymptomDataToFile(String filePath) {
        this.FILE_PATH = filePath;
    }

    /**
     * Write symptoms and their count to a file.
     * @param symptomsCount map with symptoms as keys and their count as values
     */
    @Override
    public void writeSymptoms(Map<String, Integer> symptomsCount) {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            for (Map.Entry<String, Integer> entry : symptomsCount.entrySet()) {
                String line = entry.getKey() + " : " + entry.getValue() + "\n";
                writer.write(line);
            }
        } catch (IOException e) {
            System.out.println("Error while writing symptoms count file");
        }
    }
}