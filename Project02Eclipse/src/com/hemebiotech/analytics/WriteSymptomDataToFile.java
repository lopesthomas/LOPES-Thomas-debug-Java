package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Implementation of ISymptomWriter that writes symptom data to a specified file.
 */
public class WriteSymptomDataToFile implements ISymptomWriter {
    private String filePath;

    /**
     * Constructor for WriteSymptomDataToFile.
     *
     * @param filePath The path to the file where symptom data will be written.
     */
    public WriteSymptomDataToFile(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Writes symptom data to the specified file, with each symptom and its count
     * on a new line.
     *
     * @param symptomByCount a map containing symptoms as keys and their counts as values.
     */
    @Override
    public void writeSymptom(Map<String, Integer> symptomByCount) {
        if (filePath != null) {
            try {
                FileWriter writer = new FileWriter (filePath);
                for (String symptom : symptomByCount.keySet()){
                    int count = symptomByCount.get(symptom);
                    writer.write(symptom + " " + count + "\n");
                    
                }
                writer.close();
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
        
    }
}
