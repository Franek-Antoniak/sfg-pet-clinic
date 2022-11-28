package spring.learning.petclinic.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "owners")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Owner extends Person {
	@Column(name = "address")
	private String address;
	@Column(name = "city")
	private String city;
	@Column(name = "telephone")
	private String telephone;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
	@Builder.Default
	private Set<Pet> pets = new HashSet<>();

	public Pet getPet(String name, boolean ignoreNew) {
		name = name.toLowerCase();
		for (Pet pet : pets) {
			if (!ignoreNew || !pet.isNew()) {
				String compName = pet.getName();
				compName = compName.toLowerCase();
				if (compName.equals(name)) {
					return pet;
				}
			}
		}
		return null;
	}

}
