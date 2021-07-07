package hr.truenorth.TrueNorth.Service;

import java.util.List;

import hr.truenorth.TrueNorth.Model.Rental;

public interface RentalService {

	public List<Rental> getAllRentals();
	
	public Rental getRentalById(int id);
	
	public void addRental(Rental rental);
	
	public void deleteRental(Rental rental);
	
	public List<Rental> getRentalsByUserId(int id);
}
