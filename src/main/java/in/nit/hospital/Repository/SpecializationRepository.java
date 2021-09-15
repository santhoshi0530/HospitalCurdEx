package in.nit.hospital.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.nit.hospital.entity.Specialization;

public interface SpecializationRepository extends JpaRepository<Specialization, Integer>{

}
