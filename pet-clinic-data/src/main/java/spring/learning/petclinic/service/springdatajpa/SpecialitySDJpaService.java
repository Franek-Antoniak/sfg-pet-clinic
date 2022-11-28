package spring.learning.petclinic.service.springdatajpa;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import spring.learning.petclinic.model.Speciality;
import spring.learning.petclinic.repository.SpecialtyRepository;
import spring.learning.petclinic.service.SpecialtyService;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
@RequiredArgsConstructor
public class SpecialitySDJpaService implements SpecialtyService {

	private final SpecialtyRepository specialtyRepository;

	@Override
	public Set<Speciality> findAll() {
		Set<Speciality> specialities = new HashSet<>();
		specialtyRepository.findAll()
		                   .forEach(specialities::add);
		return specialities;
	}

	@Override
	public Speciality findById(Long aLong) {
		return specialtyRepository.findById(aLong)
		                          .orElse(null);
	}

	@Override
	public Speciality save(Speciality object) {
		return specialtyRepository.save(object);
	}

	@Override
	public void delete(Speciality object) {
		specialtyRepository.delete(object);
	}

	@Override
	public void deleteById(Long aLong) {
		specialtyRepository.deleteById(aLong);
	}
}
