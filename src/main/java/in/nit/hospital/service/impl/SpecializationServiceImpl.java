package in.nit.hospital.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nit.hospital.Repository.SpecializationRepository;
import in.nit.hospital.entity.Specialization;
import in.nit.hospital.service.ISpecializationService;

@Service
public class SpecializationServiceImpl implements ISpecializationService {

	@Autowired
	private SpecializationRepository repo;

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

	@Override
	public void updateData(Specialization spec) {
		spec = repo.save(spec);
	}
}
