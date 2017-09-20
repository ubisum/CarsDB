package it.CarsDB.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.CarsDB.boot.DAO.ResellerInterface;
import it.CarsDB.boot.model.Reseller;
import it.CarsDB.boot.utilities.CSVReader;

@RestController
@CrossOrigin
@RequestMapping("/Reseller")
public class ResellerController {
	@Autowired
	private ResellerInterface repository;
	private boolean dbPopulated = false;
	
	private void insertResellers(String csv_path)
	{
		// read files
		List<List<String>> resellersData = CSVReader.readFile(csv_path);
		
		// insert resellers
		for(int index = 1; index<resellersData.size(); index++)
		{
			// data of a single reseller
			List<String> resellerStrings = resellersData.get(index);
			
			// populate bean
			Reseller reseller = new Reseller();
			reseller.setName(resellerStrings.get(0));
			reseller.setSurname(resellerStrings.get(1));
			reseller.setEmail(resellerStrings.get(2));
			reseller.setSsn(resellerStrings.get(3));
			
			// insert reseller
			repository.save(reseller);
		}
		
	}
	
	@RequestMapping(value = "/getModel", method = RequestMethod.GET)
	public Reseller getModel() {
		return new Reseller();
	}
	
	@RequestMapping(value = "/insertReseller", method = RequestMethod.POST)
	public ResponseEntity<Reseller> saveReseller(@RequestBody Reseller reseller)
	{
		try {
			repository.save(reseller);
			return new ResponseEntity<>(reseller, HttpStatus.CREATED);
		}

		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	
	@RequestMapping(value = "/findReseller{ssn}", method = RequestMethod.GET)
	public /*ResponseEntity<Reseller>*/ Reseller findResellerBySsn(@PathVariable("ssn") String ssn)
	{
		try
		{
			if(!dbPopulated)
			{
				insertResellers("src/main/resources/datasets/people_data.csv");
				System.out.println("DB populated");
				dbPopulated = true;
			}
			
			Reseller reseller = repository.findBySsn(ssn).get(0);
			if(reseller != null)
				//return new ResponseEntity<>(reseller, HttpStatus.FOUND);
				return reseller;
			
			else
				//return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				return null;
			
		}
		
		catch(Exception e)
		{
			//return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			return null;
		}
	}
	


}
