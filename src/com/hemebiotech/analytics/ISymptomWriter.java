package com.hemebiotech.analytics;

import java.util.Map;

public interface ISymptomWriter {
    /**
     * Write symptoms and their count to a file.
     * @param symptomsCount map with symptoms as keys and their count as values
     */
    void writeSymptoms(Map<String, Integer> symptomsCount);
}