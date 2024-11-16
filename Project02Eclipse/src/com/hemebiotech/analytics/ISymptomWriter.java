package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Provides a mechanism to write symptom data and their respective counts
 * to an output destination such as a file .out
 */
public interface ISymptomWriter {
    /**
     * Writes a map of symptoms and their counts to an output source.
     *
     * @param symptomByCount a map where the key is a symptom (String)
     * and the value is the count of occurrences (Integer)
     */
    void writeSymptom(Map<String, Integer> symptomByCount);
}
