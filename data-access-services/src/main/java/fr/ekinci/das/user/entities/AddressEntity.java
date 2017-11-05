package fr.ekinci.das.user.entities;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by ulysse on 02/11/2017.
 */
@Data
@Entity(name = "addresses")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "country")
    private String country;

    @Column(name = "street")
    private String street;

    @Column(name = "code")
    private String code;

    @OneToOne(cascade = {CascadeType.REMOVE})
    private UserEntity user;
}
