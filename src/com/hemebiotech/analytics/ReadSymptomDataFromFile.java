package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filePath;
	
	/**
	 * @param filePath full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile(String filePath) {
		this.filePath = filePath;
	}
	
	/**
	 * If no data is available, return an empty List.
	 * @return raw listing of all symptoms obtained from a data source, duplicates are possible/probable
	 */
	@Override
	public List<String> getSymptoms() {
		ArrayList<String> result = new ArrayList<String>();
		
		if (filePath != null) {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(filePath));
				String line = reader.readLine();
				
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

}
