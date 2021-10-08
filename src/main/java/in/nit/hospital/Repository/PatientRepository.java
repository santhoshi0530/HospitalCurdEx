package in.nit.hospital.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.nit.hospital.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}
