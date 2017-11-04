package fr.ekinci.clientmodels;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * Created by ulysse on 02/11/2017.
 */
@Data
@Builder
@ToString
public class AddressDto {

    private String id;

    private String country;

    private String street;

    private String code;

    private UserDto user;
}
