package spring.learning.petclinic.repository;

import org.springframework.data.repository.CrudRepository;
import spring.learning.petclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
