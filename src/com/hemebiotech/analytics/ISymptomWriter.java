package com.hemebiotech.analytics;

import java.util.Map;

public interface ISymptomWriter {
    /**
     * Write symptoms and their count to a file
     * @param symptomsCounts : Map of symptom strings and their counts
     */
    void writeSymptoms(Map<String, Integer> symptomsCounts);
}
