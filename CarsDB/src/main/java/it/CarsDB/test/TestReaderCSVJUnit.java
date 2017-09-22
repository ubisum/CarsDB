package it.CarsDB.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import it.CarsDB.boot.exceptions.CarsException;
import it.CarsDB.boot.utilities.CSVReader;

public class TestReaderCSVJUnit {
	static final String people = "src/main/resources/datasets/people_data.csv";
	static final String cars = "src/main/resources/datasets/cars.csv";
	
	@Test
	public void testReading() throws CarsException
	{
		List<List<String>> peopleList = null;
		peopleList = CSVReader.readFile(people);
		
		List<List<String>> carsList = null;
		carsList = CSVReader.readFile(cars);
		
		assertNotNull(peopleList);
		assertNotNull(carsList);
		
		assertTrue(peopleList.size() > 0);
		assertTrue(carsList.size() > 0);
		
		
	}
	

}
