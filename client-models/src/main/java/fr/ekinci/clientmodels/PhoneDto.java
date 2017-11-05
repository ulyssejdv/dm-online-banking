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
public class PhoneDto {

    private String id;

    private String label;

    private String number;
}
