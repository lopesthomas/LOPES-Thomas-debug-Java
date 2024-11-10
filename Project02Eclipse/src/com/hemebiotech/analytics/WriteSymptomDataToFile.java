package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {
    private String filePath;

    public WriteSymptomDataToFile(String filePath) {
        this.filePath = filePath;
    }

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
