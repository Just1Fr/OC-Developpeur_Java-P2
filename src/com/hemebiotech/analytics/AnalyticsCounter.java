package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
	private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int pupilCount = 0;

	private ISymptomReader reader;
    private ISymptomWriter writer;

	/**
	 * @param reader ISymptomReader object
	 * @param writer ISymptomWriter object
	 */
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

	/**
	 * If no data is available, return an empty List.
	 * @return raw listing of all symptoms obtained from a data source, duplicates are possible/probable
	 */
	public List<String> getSymptoms() {
		return reader.getSymptoms();
	}

	/**
	 * Counts the occurrences of each symptom in a list of symptoms.
	 * @param symptoms list of symptoms to count
	 * @return map with symptoms as keys and their counts as values
	 */
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

	/**
	 * Sorts a symptoms map alphabetically.
	 * @param symptomCounts map with symptoms as keys and their counts as values
	 * @return sorted symptoms map
	 */
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptomCounts) {
		TreeMap<String, Integer> sorted = new TreeMap<>();
		sorted.putAll(symptomCounts);
		return sorted;
	}

	public void writeSymptoms(Map<String, Integer> symptoms) {
		writer.writeSymptoms(symptoms);
	}
}
