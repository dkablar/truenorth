package hr.truenorth.TrueNorth.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import hr.truenorth.TrueNorth.Model.Rental;

public interface RentalRepository extends JpaRepository<Rental, Long> {

	@Query(value="SELECT * FROM rental", nativeQuery=true)
	public List<Rental> getRentals();
	
	@Query(value="SELECT * FROM rental WHERE rental_id = :id", nativeQuery=true)
	public Rental getRentalById(@Param("id") int id);
	
	@Query(value="SELECT * FROM rental WHERE user_id = :id", nativeQuery=true)
	public List<Rental> getRentalsByUserId(@Param("id") int id);
}
