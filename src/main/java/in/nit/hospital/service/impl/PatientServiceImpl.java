package in.nit.hospital.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nit.hospital.Exception.PatientNotFoundException;
import in.nit.hospital.Repository.PatientRepository;
import in.nit.hospital.entity.Patient;
import in.nit.hospital.service.IPatientService;

@Service
public class PatientServiceImpl implements IPatientService {

	@Autowired
	private PatientRepository repo;

	@Override
	public Long saveData(Patient patient) {
		return repo.save(patient).getId();
	}

	@Override
	public Patient findById(Long id) {
		return repo.findById(id).orElseThrow(() -> new PatientNotFoundException("Patient does not exist"));
	}

	@Override
	public List<Patient> showAll() {
		return repo.findAll();
	}

	@Override
	public void deleteById(Long id) {
		if(repo.existsById(id))
		repo.deleteById(id);
		else throw new PatientNotFoundException(id+" patient does not exist");
	}

	@Override
	public void updatePatient(Patient patient) {
		if (repo.existsById(patient.getId())) {
			repo.save(patient);
		} else
			throw new PatientNotFoundException(patient.getId()+" does not exist");
	}

}
