package spring.learning.petclinic.service.springdatajpa;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import spring.learning.petclinic.model.Owner;
import spring.learning.petclinic.repository.OwnerRepository;
import spring.learning.petclinic.service.OwnerService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Profile("springdatajpa")
@RequiredArgsConstructor
public class OwnerSDJpaService implements OwnerService {

	private final OwnerRepository ownerRepository;

	@Override
	public Owner findByLastName(String lastName) {
		return ownerRepository.findByLastName(lastName);
	}

	@Override
	public List<Owner> findAllByLastNameLike(String lastName) {
		return ownerRepository.findAllByLastNameLike(lastName);
	}

	@Override
	public Set<Owner> findAll() {
		Set<Owner> owners = new HashSet<>();
		ownerRepository.findAll()
		               .forEach(owners::add);
		return owners;
	}

	@Override
	public Owner findById(Long aLong) {
		return ownerRepository.findById(aLong)
		                      .orElse(null);
	}

	@Override
	public Owner save(Owner object) {
		return ownerRepository.save(object);
	}

	@Override
	public void delete(Owner object) {
		ownerRepository.delete(object);
	}

	@Override
	public void deleteById(Long aLong) {
		ownerRepository.deleteById(aLong);
	}
}
