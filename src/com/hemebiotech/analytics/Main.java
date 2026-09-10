package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        final String SYMPTOMS_FILE_PATH = "data/symptoms.txt";
		final String RESULT_FILE_PATH = "data/result.out";

		AnalyticsCounter analytics = new AnalyticsCounter(
			new ReadSymptomDataFromFile(SYMPTOMS_FILE_PATH),
			new WriteSymptomDataToFile(RESULT_FILE_PATH)
		);

		List<String> symptoms = analytics.getSymptoms();
		Map<String, Integer> symptomCounts = analytics.sortSymptoms(analytics.countSymptoms(symptoms));
		analytics.writeSymptoms(symptomCounts);
    }
}
