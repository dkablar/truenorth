package hr.truenorth.TrueNorth.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import hr.truenorth.TrueNorth.Model.Rental;
import hr.truenorth.TrueNorth.Repository.RentalRepository;

@Service
public class RentalServiceImpl implements RentalService {

	private final RentalRepository iRentalRepository;
	
	public RentalServiceImpl(RentalRepository rentalRepository) {
		this.iRentalRepository = rentalRepository;
	}
	
	@Override
	public List<Rental> getAllRentals() {
		return iRentalRepository.getRentals();
	}
	
	@Override
	public Rental getRentalById(int id) {
		return iRentalRepository.getRentalById(id);
	}

	@Override
	public void addRental(Rental rental) {
		iRentalRepository.save(rental);
	}

	@Override
	public void deleteRental(Rental rental) {
		iRentalRepository.delete(rental);
	}

	@Override
	public List<Rental> getRentalsByUserId(int id) {
		return iRentalRepository.getRentalsByUserId(id);
	}
}
