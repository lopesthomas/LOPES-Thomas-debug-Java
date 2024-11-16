package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * The AnalyticsCounter class performs operations for reading, 
 * counting, sorting, and writing symptom data.
 */
public class AnalyticsCounter {
	private ISymptomReader reader;
    private ISymptomWriter writer;

	/**
     * Constructor for AnalyticsCounter.
     *
     * @param symptomReader An implementation of ISymptomReader to read symptom data
     * @param symptomWriter An implementation of ISymptomWriter to write symptom data
     */
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer){
		this.reader = reader;
		this.writer = writer;
	}

	/**
     * Retrieves a list of symptoms from the data source.
     *
     * @return A list of strings, where each string is a symptom
     */
	public List<String> getSymptoms(){
		return reader.getSymptoms();
	}

	/**
     * Counts the occurrences of each symptom in the list.
     *
     * @param symptomsList A list of symptoms to be counted
     * @return A map with symptoms as keys and their counts as values
     */
	public Map<String, Integer> countSymptoms(List<String> symptomsList) {
        Map<String, Integer> symptomCounts = new HashMap<String, Integer>();
        for (String symptom : symptomsList) {
            symptomCounts.put(symptom, symptomCounts.getOrDefault(symptom, 0) + 1);
        }
        return symptomCounts;
    }

	/**
     * Sorts the symptoms alphabetically.
     *
     * @param symptomsCount A map containing symptoms and their counts
     * @return A map with symptoms sorted alphabetically
     */
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptomsCount) {
		return new TreeMap<>(symptomsCount);
	}

	/**
     * Writes the sorted symptom data to the output destination.
     *
     * @param symptomsSorted A map with symptoms and their counts to be written
     */
	public void writeSymptoms(Map<String, Integer> symptomsSorted) { 
		writer.writeSymptom(symptomsSorted);
	}
}
