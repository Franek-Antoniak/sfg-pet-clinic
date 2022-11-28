package spring.learning.petclinic.service.map;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import spring.learning.petclinic.model.Owner;
import spring.learning.petclinic.model.Pet;
import spring.learning.petclinic.service.OwnerService;
import spring.learning.petclinic.service.PetService;
import spring.learning.petclinic.service.PetTypeService;

import java.util.List;
import java.util.Set;

@Service
@Profile({"default", "map"})
@RequiredArgsConstructor
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

	private final PetTypeService petTypeService;
	private final PetService petService;

	@Override
	public Owner findByLastName(String lastName) {
		return this.findAll()
		           .stream()
		           .filter(owner -> owner.getLastName()
		                                 .equalsIgnoreCase(lastName))
		           .findFirst()
		           .orElse(null);
	}

	@Override
	public Set<Owner> findAll() {
		return super.findAll();
	}

	@Override
	public Owner findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Owner save(Owner object) {

		if (object != null) {
			if (object.getPets() != null) {
				object.getPets()
				      .forEach(pet -> {
					      if (pet.getPetType() != null) {
						      if (pet.getPetType()
						             .getId() == null) {
							      pet.setPetType(petTypeService.save(pet.getPetType()));
						      }
					      } else {
						      throw new RuntimeException("Pet Type is required");
					      }

					      if (pet.getId() == null) {
						      Pet savedPet = petService.save(pet);
						      pet.setId(savedPet.getId());
					      }
				      });
			}

			return super.save(object);

		} else {
			return null;
		}
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public void delete(Owner object) {
		super.delete(object);
	}

	@Override
	public List<Owner> findAllByLastNameLike(String lastNameRegex) {
		return this.findAll()
		           .stream()
		           .filter(owner -> owner.getLastName()
		                                 .matches(lastNameRegex))
		           .toList();
	}
}
