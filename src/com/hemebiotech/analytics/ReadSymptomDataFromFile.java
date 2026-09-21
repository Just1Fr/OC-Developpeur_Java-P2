package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadSymptomDataFromFile implements ISymptomReader {

	private final String FILE_PATH;
	
	/**
	 * @param filePath full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile(String filePath) {
		this.FILE_PATH = filePath;
	}
	
	/**
	 * If no data is available, return an empty List.
	 * @return raw listing of all symptoms obtained from a data source, duplicates are possible/probable
	 */
	@Override
	public List<String> getSymptoms() {
		ArrayList<String> result = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
			String line = reader.readLine();

			while (line != null) {
				result.add(line);
				line = reader.readLine();
			}
		} catch (IOException e) {
			System.out.println("Error while reading symptoms file");
		}

		return result;
	}

}
