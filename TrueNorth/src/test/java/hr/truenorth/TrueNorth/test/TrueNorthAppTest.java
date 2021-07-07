package hr.truenorth.TrueNorth.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Timestamp;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import hr.truenorth.TrueNorth.Model.Rental;
import hr.truenorth.TrueNorth.Model.User;
import hr.truenorth.TrueNorth.Model.VHS;
import hr.truenorth.TrueNorth.Service.RentalService;
import hr.truenorth.TrueNorth.Service.UserService;
import hr.truenorth.TrueNorth.Service.VHSService;

@SpringBootTest
public class TrueNorthAppTest {

	@Autowired
	private UserService userService;
	
	@Autowired
	private VHSService vhsService;
	
	@Autowired
	private RentalService rentalService;
	
	@Test
	public void addingVHSTapeTest() {
		VHS vhs = new VHS();
		vhs.setTitle("Fight Club");
		vhsService.addVHS(vhs);
		
		List<VHS> vhsList = vhsService.getAllVHS();
		
		assertTrue(vhsList.contains(vhs));
	}
	
	@Test
	public void rentVHSTapeTest() {
		User user = userService.getUserByUsername("lebronjames");
		
		List<VHS> vhsList = vhsService.getVHSByTitle("Kill Bill vol. 2");
		
		Rental rental = new Rental();
		rental.setExpired(false);
		rental.setUser(user);
		rental.setVhsrented(vhsList.get(0));
		rental.setDateFrom(Timestamp.valueOf("2021-07-05 12:00:00"));
		rental.setDateUntil(Timestamp.valueOf("2021-07-10 12:00:00"));
		
		rentalService.addRental(rental);
		
		List<Rental> userRentals = rentalService.getRentalsByUserId(user.getId());
		
		assertTrue(userRentals.contains(rental));
		
		rentalService.deleteRental(rental);
	}
}
