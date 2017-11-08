package fr.ekinci.das.user.entities;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;


@Data
@Entity(name = "users")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "first_name")
	private String firstName;

	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	private AddressEntity address;

	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	private Set<PhoneEntity> phones;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy = "user")
    private Set<AccountEntity> accounts;
}