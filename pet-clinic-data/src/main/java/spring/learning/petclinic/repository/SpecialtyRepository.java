package spring.learning.petclinic.repository;


import org.springframework.data.repository.CrudRepository;
import spring.learning.petclinic.model.Speciality;

public interface SpecialtyRepository extends CrudRepository<Speciality, Long> {
}
