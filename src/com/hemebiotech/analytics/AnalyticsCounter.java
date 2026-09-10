package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class AnalyticsCounter {
	private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int pupilCount = 0;

	public static void main(String args[]) throws Exception {
		String symptomsFilePath = "data/symptoms.txt";
		String resultFilePath = "data/result.out";

		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile(symptomsFilePath);

		List<String> symptoms = reader.getSymptoms();

		for (String symptom : symptoms) {
			System.out.println("symptom from file: " + symptom);
			if (symptom.equals("headache")) {
				headacheCount++;
			}
			else if (symptom.equals("rash")) {
				rashCount++;
			}
			else if (symptom.contains("dilated pupils")) {
				pupilCount++;
			}
		}

		Map<String, Integer> result = Map.of(
			"dilated pupils", pupilCount,
			"headache", headacheCount,
			"rash", rashCount
		);

		WriteSymptomDataToFile writer = new WriteSymptomDataToFile(resultFilePath);
		writer.writeSymptoms(result);
	}
}
