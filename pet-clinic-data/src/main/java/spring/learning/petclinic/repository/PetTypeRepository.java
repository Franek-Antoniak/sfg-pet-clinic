package spring.learning.petclinic.repository;

import org.springframework.data.repository.CrudRepository;
import spring.learning.petclinic.model.PetType;


public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
