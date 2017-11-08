package fr.ekinci.clientmodels;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * Created by ulysse on 06/11/2017.
 */
@Data
@Builder
@ToString
public class HistoryDto {
    private Long amount;
    private AccountDto account;
}
