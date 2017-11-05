package fr.ekinci.das.user.entities;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by ulysse on 03/11/2017.
 */
@Data
@Entity(name = "accounts")
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private Integer solde;

    private String typeAccount;

    @ManyToOne
    private UserEntity user;
}
