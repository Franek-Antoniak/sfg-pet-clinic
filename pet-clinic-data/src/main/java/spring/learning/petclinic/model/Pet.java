package spring.learning.petclinic.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SuperBuilder
@Table(name = "pets")
public class Pet extends BaseEntity {

	@Column(name = "name")
	private String name;
	@ManyToOne
	@JoinColumn(name = "type_id")
	private PetType petType;
	@ManyToOne
	@JoinColumn(name = "owner_id")
	private Owner owner;
	@Column(name = "birth_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate birthDate;

	@Builder.Default
	@OneToMany(
			cascade = CascadeType.ALL,
			mappedBy = "pet"
	)
	private Set<Visit> visits = new HashSet<>();
}
