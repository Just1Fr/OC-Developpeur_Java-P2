package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
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
	 * @param symptomsList list of symptoms to count
	 * @return map with symptoms as keys and their count as values
	 */
	public Map<String, Integer> countSymptoms(List<String> symptomsList) {
		HashMap<String, Integer> symptomsCount = new HashMap<String,Integer>();
		System.out.println("- Symptoms from file:");
		for (String symptom : symptomsList) {
			System.out.println(symptom);
			if (symptomsCount.containsKey(symptom)) {
				symptomsCount.put(symptom, symptomsCount.get(symptom) + 1);
			} else {
				symptomsCount.put(symptom, 1);
			}
		}

		System.out.println("- Result: " + symptomsCount);

		return symptomsCount;
	}

	/**
	 * Sorts a symptoms map alphabetically.
	 * @param symptomsCount map with symptoms as keys and their count as values
	 * @return sorted symptoms map
	 */
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptomsCount) {
		TreeMap<String, Integer> sorted = new TreeMap<>();
		sorted.putAll(symptomsCount);
		return sorted;
	}

	/**
     * Write symptoms and their count to a file.
     * @param symptomsCount map with symptoms as keys and their count as values
     */
	public void writeSymptoms(Map<String, Integer> symptomsCount) {
		writer.writeSymptoms(symptomsCount);
	}
}
