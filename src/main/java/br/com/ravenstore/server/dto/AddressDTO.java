package br.com.ravenstore.server.dto;

import br.com.ravenstore.server.model.Address;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {
	private Long id;

	@NotNull
	private String state;

	@NotNull
	private String city;

	@NotNull
	private String street;

	@NotNull
	private String number;

	private String complement;

	@NotNull
	private String zipCode;

	@NotNull
	private Long userId;

	public AddressDTO(Address address) {
		this.id = address.getId();
		this.state = address.getState();
		this.city = address.getCity();
		this.street = address.getStreet();
		this.number = address.getNumber();
		this.complement = address.getComplement();
		this.zipCode = address.getZipCode();
		this.userId = address.getUser().getId();
	}
}
