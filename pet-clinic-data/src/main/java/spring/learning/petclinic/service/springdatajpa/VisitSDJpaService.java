package spring.learning.petclinic.service.springdatajpa;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import spring.learning.petclinic.model.Visit;
import spring.learning.petclinic.repository.VisitRepository;
import spring.learning.petclinic.service.VisitService;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
@RequiredArgsConstructor
public class VisitSDJpaService implements VisitService {

	private final VisitRepository visitRepository;

	@Override
	public Set<Visit> findAll() {
		Set<Visit> visits = new HashSet<>();
		visitRepository.findAll()
				.forEach(visits::add);
		return visits;
	}

	@Override
	public Visit findById(Long aLong) {
		return visitRepository.findById(aLong)
				.orElse(null);
	}

	@Override
	public Visit save(Visit object) {
		return visitRepository.save(object);
	}

	@Override
	public void delete(Visit object) {
		visitRepository.delete(object);
	}

	@Override
	public void deleteById(Long aLong) {
		visitRepository.deleteById(aLong);
	}
}
