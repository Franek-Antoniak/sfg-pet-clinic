package spring.learning.petclinic.repository;

import org.springframework.data.repository.CrudRepository;
import spring.learning.petclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
