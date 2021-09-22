package in.nit.hospital.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.nit.hospital.entity.Specialization;

public interface SpecializationRepository extends JpaRepository<Specialization, Integer>{

	@Query("SELECT COUNT(code) FROM Specialization where code=:specCode")
	Integer getSpecCodeCount(String specCode);
	
	@Query("SELECT COUNT(name) FROM Specialization where name=:specName")
	Integer getSpecNameCount(String specName);
	
	@Query("SELECT id,name FROM Specialization")
	List<Object[]> getSpecIdAndName();
}
