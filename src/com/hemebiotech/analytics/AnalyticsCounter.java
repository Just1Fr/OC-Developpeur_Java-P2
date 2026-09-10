package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class AnalyticsCounter {
	private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int pupilCount = 0;

	private ISymptomReader reader;
    private ISymptomWriter writer;

	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		System.out.println("- Symptoms from file:");
		for (String symptom : symptoms) {
			System.out.println(symptom);
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

		System.out.println("- Result: " + result);

		return result;
	}

	public static void main(String args[]) throws Exception {
		String symptomsFilePath = "data/symptoms.txt";
		String resultFilePath = "data/result.out";

		AnalyticsCounter analytics = new AnalyticsCounter(
			new ReadSymptomDataFromFile(symptomsFilePath),
			new WriteSymptomDataToFile(resultFilePath)
		);

		List<String> symptoms = analytics.reader.getSymptoms();
		Map<String, Integer> symptomCounts = analytics.countSymptoms(symptoms);
		analytics.writer.writeSymptoms(symptomCounts);
	}
}
