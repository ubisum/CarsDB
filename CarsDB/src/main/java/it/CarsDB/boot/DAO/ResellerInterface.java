package it.CarsDB.boot.DAO;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.CarsDB.boot.model.Reseller;

public interface ResellerInterface extends CrudRepository<Reseller, String> {
	public List<Reseller> findBySsn(String ssn);
}
