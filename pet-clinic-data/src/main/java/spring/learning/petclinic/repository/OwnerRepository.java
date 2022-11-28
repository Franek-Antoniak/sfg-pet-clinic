package spring.learning.petclinic.repository;

import org.springframework.data.repository.CrudRepository;
import spring.learning.petclinic.model.Owner;

import java.util.List;


public interface OwnerRepository extends CrudRepository<Owner, Long> {

	Owner findByLastName(String lastName);

	List<Owner> findAllByLastNameLike(String lastName);
}
