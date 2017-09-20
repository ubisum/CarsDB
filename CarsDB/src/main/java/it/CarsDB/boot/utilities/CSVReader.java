package it.CarsDB.boot.utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

	public static List<List<String>> readFile(String path)
	{
		List<List<String>> listOfArrays = new ArrayList<List<String>>();
		
		try
		{
			BufferedReader bf = new BufferedReader(new FileReader(path));
			String line = null;
			
			while((line = bf.readLine()) != null)
			{
				String columns[] = line.split(";");
				List<String> listOfStrings = new ArrayList<String>();
				
				for(int index = 0; index<columns.length; index++)
					listOfStrings.add(columns[index]);
				
				listOfArrays.add(listOfStrings);
			}
			
			bf.close();
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return listOfArrays;
	}
	
}
