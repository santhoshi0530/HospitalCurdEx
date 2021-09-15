package in.nit.hospital.service;

import java.util.List;

import in.nit.hospital.entity.Specialization;

public interface ISpecializationService {

	public Integer saveData(Specialization specialization);
	
	public List<Specialization> showAll();
	
	void delete(Integer id);
	
	public Specialization findById(Integer id);
	
	public void updateData(Specialization spec);
	
}
