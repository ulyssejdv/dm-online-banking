package fr.ekinci.das.user.entities;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

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

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy = "account")
    private Set<HistoryEntity> transactions;
}
