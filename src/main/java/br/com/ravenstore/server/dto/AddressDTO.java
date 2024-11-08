package br.com.ravenstore.server.dto;

import br.com.ravenstore.server.model.Address;
import br.com.ravenstore.server.model.User;
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
	private User user;

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

	public void toDto(Address address) {
		this.id = address.getId();
		this.user = address.getUser();
		this.state = address.getState();
		this.city = address.getCity();
		this.street = address.getStreet();
		this.number = address.getNumber();
		this.complement = address.getComplement();
		this.zipCode = address.getZipCode();
	}

	public Address fromDto() {
		Address address = new Address();
		address.setId(this.id);
		address.setState(this.state);
		address.setCity(this.city);
		address.setStreet(this.street);
		address.setNumber(this.number);
		address.setComplement(this.complement);
		address.setZipCode(this.zipCode);
		return address;
	}
}
