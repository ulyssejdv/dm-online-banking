package fr.ekinci.clientmodels;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * Created by ulysse on 03/11/2017.
 */
@Data
@Builder
@ToString
public class AccountDto {

    private String id;

    private Integer solde;

    private String typeAccount;

    private UserDto user;
}
