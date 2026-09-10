package com.hemebiotech.analytics;

import java.util.Map;

public interface ISymptomWriter {
    /**
     * Write symptoms and their count to a file.
     * @param symptomCounts map with symptoms as keys and their counts as values
     */
    void writeSymptoms(Map<String, Integer> symptomCounts);
}