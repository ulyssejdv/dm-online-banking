package fr.ekinci.clientmanagement.user.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
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

	@OneToOne
	private AddressEntity address;

	@OneToMany(cascade = {CascadeType.PERSIST})
	private Set<PhoneEntity> phones;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }

    public Collection<PhoneEntity> getPhones() {
        return phones;
    }

    public void setPhones(Set<PhoneEntity> phones) {
        this.phones = phones;
    }
}