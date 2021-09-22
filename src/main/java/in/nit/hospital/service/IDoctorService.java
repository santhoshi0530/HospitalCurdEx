package in.nit.hospital.service;

import java.util.List;

import in.nit.hospital.entity.Doctor;

public interface IDoctorService {
 
	public Long saveDoctor(Doctor doc);
	
	public List<Doctor> getAllDoctor();
	
	public void removeDoctor(Long id);
	
	public Doctor getOneDoctor(Long id);
	
	public void updateDoctor(Doctor doc);
	
}
