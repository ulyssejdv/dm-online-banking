package fr.jdv.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

/**
 * Created by ulysse on 05/11/2017.
 */
@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserResponse {

    private String id;

    private String lastName;

    private String firstName;

}
