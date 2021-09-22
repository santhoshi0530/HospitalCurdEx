package in.nit.hospital.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nit.hospital.Repository.SpecializationRepository;
import in.nit.hospital.entity.Specialization;
import in.nit.hospital.service.ISpecializationService;
import in.nit.hospital.util.MyCollectionUtil;

@Service
public class SpecializationServiceImpl implements ISpecializationService {

	@Autowired
	private SpecializationRepository repo;
	
	@Autowired
	private MyCollectionUtil util;

	public Integer saveData(Specialization specialization) {
		Specialization spec = repo.save(specialization);

		return spec.getId();
	}

	public List<Specialization> showAll() {
		List<Specialization> list = repo.findAll();
		return list;
	}

	public void delete(Integer id) {
		repo.deleteById(id);

	}

	public Specialization findById(Integer id) {
		Optional<Specialization> opt = repo.findById(id);
		Specialization spec = null;
		if (opt.isPresent())
			spec = opt.get();

		return spec;
	}

	public void updateData(Specialization spec) {
		spec = repo.save(spec);
	}

	public boolean isSepcCodeExist(String specCode) {

		return repo.getSpecCodeCount(specCode) > 0;
	}

	public boolean isSpecNameExist(String specName) {

		return repo.getSpecNameCount(specName) > 0;
	}

	@Override
	public Map<Long, String> getSpecIdAndName() {
		Map<Long,String> map = util.converToMap(repo.getSpecIdAndName());
		
		return map;
	}

}
