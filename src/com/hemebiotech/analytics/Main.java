package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        final String SYMPTOMS_FILE_PATH = "data/symptoms.txt";
		final String RESULT_FILE_PATH = "data/result.out";

		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile(SYMPTOMS_FILE_PATH);
		WriteSymptomDataToFile writer = new WriteSymptomDataToFile(RESULT_FILE_PATH);
		AnalyticsCounter analytics = new AnalyticsCounter(reader, writer);

		List<String> symptomsList = analytics.getSymptoms();
		if (symptomsList.isEmpty()) {
			System.out.println("No symptoms found in the file.");
		} else {
			Map<String, Integer> symptomsCount = analytics.sortSymptoms(analytics.countSymptoms(symptomsList));
			analytics.writeSymptoms(symptomsCount);
		}
    }
}
