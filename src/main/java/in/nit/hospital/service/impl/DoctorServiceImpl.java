package in.nit.hospital.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nit.hospital.Exception.DoctorNotFoundException;
import in.nit.hospital.Repository.DoctorRepository;
import in.nit.hospital.entity.Doctor;
import in.nit.hospital.service.IDoctorService;


@Service
public class DoctorServiceImpl implements IDoctorService {

	@Autowired
	private DoctorRepository repo;

	public Long saveDoctor(Doctor doc) {
		return repo.save(doc).getId();
	}

	public List<Doctor> getAllDoctor() {

		return repo.findAll();
	}

	public void removeDoctor(Long id) {
		repo.delete(getOneDoctor(id));
	}

	public Doctor getOneDoctor(Long id) {
		

		return repo.findById(id).orElseThrow(() -> new DoctorNotFoundException(id+", not exist"));
	}

	public void updateDoctor(Doctor doc) {
		
		
		if(repo.existsById(doc.getId())) {
			repo.save(doc);
		}else throw new DoctorNotFoundException(doc.getId()+", not exist"); 

	}

}
