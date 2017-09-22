package it.CarsDB.test;

import java.util.List;

import it.CarsDB.boot.exceptions.CarsException;
import it.CarsDB.boot.utilities.CSVReader;

public class TestReader {

	public static void main(String[] args) throws CarsException {
		String filePath = "src/main/resources/datasets/people_data.csv";
		
		List<List<String>> readStrings = CSVReader.readFile(filePath);
		System.out.println("Size: " + readStrings.size());
		List<String> firstRow = readStrings.get(1);
		
		for(int index = 0; index<firstRow.size(); index++)
			System.out.println(firstRow.get(index));
	}

}
