package spring.learning.petclinic.service.springdatajpa;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import spring.learning.petclinic.model.PetType;
import spring.learning.petclinic.repository.PetTypeRepository;
import spring.learning.petclinic.service.PetTypeService;

import java.util.HashSet;
import java.util.Set;


@Service
@Profile("springdatajpa")
@RequiredArgsConstructor
public class PetTypeSDJpaService implements PetTypeService {

	private final PetTypeRepository petTypeRepository;


	@Override
	public Set<PetType> findAll() {
		Set<PetType> petTypes = new HashSet<>();
		petTypeRepository.findAll()
				.forEach(petTypes::add);
		return petTypes;
	}

	@Override
	public PetType findById(Long aLong) {
		return petTypeRepository.findById(aLong)
				.orElse(null);
	}

	@Override
	public PetType save(PetType object) {
		return petTypeRepository.save(object);
	}

	@Override
	public void delete(PetType object) {
		petTypeRepository.delete(object);
	}

	@Override
	public void deleteById(Long aLong) {
		petTypeRepository.deleteById(aLong);
	}
}
