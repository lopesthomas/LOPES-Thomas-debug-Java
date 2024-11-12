package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
	private ISymptomReader reader;
    private ISymptomWriter writer;

	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer){
		this.reader = reader;
		this.writer = writer;
	}

	public List<String> getSymptoms(){
		return reader.GetSymptoms();
	}

	public Map<String, Integer> countSymptoms(List<String> symptomsList) {
        Map<String, Integer> symptomCounts = new HashMap<String, Integer>();
        for (String symptom : symptomsList) {
            symptomCounts.put(symptom, symptomCounts.getOrDefault(symptom, 0) + 1);
        }
        return symptomCounts;
    }

	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptomsCount) {
		return new TreeMap<>(symptomsCount);
	}

	public void writeSymptoms(Map<String, Integer> symptomsSorted) { 
		writer.writeSymptom(symptomsSorted);
	}
}
