package in.nit.hospital.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.nit.hospital.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

}
