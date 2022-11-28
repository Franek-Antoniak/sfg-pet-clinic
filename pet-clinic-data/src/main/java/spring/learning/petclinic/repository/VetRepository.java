package spring.learning.petclinic.repository;

import org.springframework.data.repository.CrudRepository;
import spring.learning.petclinic.model.Vet;


public interface VetRepository extends CrudRepository<Vet, Long> {
}
