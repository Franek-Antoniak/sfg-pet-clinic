package spring.learning.petclinic.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;


@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "vets")
@SuperBuilder
public class Vet extends Person {
	@Builder.Default
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "vet_specialties",
			joinColumns = @JoinColumn(name = "vet_id"),
			inverseJoinColumns = @JoinColumn(name = "speciality_id")
	)
	private Set<Speciality> specialities = new HashSet<>();
}
