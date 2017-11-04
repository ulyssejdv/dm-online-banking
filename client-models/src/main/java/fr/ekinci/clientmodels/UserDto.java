package fr.ekinci.clientmodels;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Pattern;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * @author Gokan EKINCI
 */
@Data
@Builder
@ToString
public class UserDto {
	@Pattern(regexp = "[0-9]{1,}")
	private String id;
	private String lastName;
	private String firstName;
	private AddressDto address;
	private Collection<PhoneDto> phones;
	private Collection<AccountDto> accounts;
}
