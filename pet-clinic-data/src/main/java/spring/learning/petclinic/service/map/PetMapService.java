package spring.learning.petclinic.service.map;


import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import spring.learning.petclinic.model.Pet;
import spring.learning.petclinic.service.PetService;

import java.util.Set;

@Service
@Profile(
		{
				"default",
				"map"
		}
)
public class PetMapService extends AbstractMapService<Pet, Long> implements PetService {
	@Override
	public Set<Pet> findAll() {
		return super.findAll();
	}

	@Override
	public Pet findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Pet save(Pet object) {
		return super.save(object);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public void delete(Pet object) {
		super.delete(object);
	}
}
