package in.nit.hospital.service;

import java.util.List;

import in.nit.hospital.entity.Patient;

public interface IPatientService {

	public Long saveData(Patient patient);
	
	public Patient findById(Long id);
	
	public List<Patient> showAll();
	
	public void deleteById(Long id);
	
	public void updatePatient(Patient patient);
}
