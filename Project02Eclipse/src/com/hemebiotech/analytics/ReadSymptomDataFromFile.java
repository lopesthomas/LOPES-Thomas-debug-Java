package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of ISymptomReader that reads symptom data from a file.
 * Each line in the file is expected to represent a single symptom.
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filePath;
	
	/**
     * Constructor for ReadSymptomDataFromFile.
     *
     * @param filePath The path to the file containing symptom data, one symptom per line.
     */
	public ReadSymptomDataFromFile (String filePath) {
		this.filePath = filePath;
	}
	
	/**
     * Reads symptoms from the specified file.
     * Each symptom is read line by line and added to a list.
     *
     * @return A list of symptoms read from the file. If the file cannot be read, an empty list is returned.
     */
	@Override
	public List<String> getSymptoms() {
		ArrayList<String> result = new ArrayList<String>();
		
		if (filePath != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(filePath));
				String line = reader.readLine();
				
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

}
