package fr.ekinci.das.user.entities;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by ulysse on 02/11/2017.
 */
@Data
@Entity(name = "phones")
public class PhoneEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "label")
    private String label;

    @Column(name = "number")
    private String number;

    @ManyToOne
    private UserEntity user;
}
