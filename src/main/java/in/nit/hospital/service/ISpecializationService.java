package in.nit.hospital.service;

import java.util.List;
import java.util.Map;

import in.nit.hospital.entity.Specialization;

public interface ISpecializationService {

	public Integer saveData(Specialization specialization);
	
	public List<Specialization> showAll();
	
	void delete(Integer id);
	
	public Specialization findById(Integer id);
	
	public void updateData(Specialization spec);
	
	public boolean isSepcCodeExist(String specCode);
	
	public boolean isSpecNameExist(String specName);
	
	public Map<Long,String> getSpecIdAndName();
	
}
