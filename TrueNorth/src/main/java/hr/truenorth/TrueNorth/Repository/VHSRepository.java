package hr.truenorth.TrueNorth.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import hr.truenorth.TrueNorth.Model.VHS;

public interface VHSRepository extends JpaRepository<VHS, Long> {

	@Query(value="SELECT * FROM vhs", nativeQuery=true)
	public List<VHS> getAllVHS();
	
	@Query(value="SELECT * FROM vhs WHERE vhs_id = :id", nativeQuery=true)
	public VHS getVHSById(@Param("id") int id);
}
