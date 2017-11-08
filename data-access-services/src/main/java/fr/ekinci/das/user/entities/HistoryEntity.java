package fr.ekinci.das.user.entities;

import javax.persistence.*;

/**
 * Created by ulysse on 06/11/2017.
 */
@Entity(name = "transactions")
public class HistoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer amount;

    @ManyToOne
    private AccountEntity account;
}
