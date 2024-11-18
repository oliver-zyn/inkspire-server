package br.com.ravenstore.server.dto;

import br.com.ravenstore.server.model.Address;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {
	private Long id;

	@NotNull
	@Size(min = 2, max = 2, message = "O Estado deve possuir exatamente 2 caracteres")
	private String state;

	@NotNull
	@Size(min = 2, max = 50, message = "A cidade deve ter no mínimo 2 e no máximo 50 caracteres")
	private String city;

	@NotNull
	@Size(min = 5, max = 100, message = "A rua deve ter no mínimo 5 e no máximo 100 caracteres")
	private String street;

	@NotNull
	@Size(min = 1, max = 10, message = "A rua deve ter no mínimo 1 e no máximo 100 caracteres")
	private String number;

	private String complement;

	@NotNull
	@Pattern(regexp = "\\d{8}", message = "O CEP deve conter exatamente 8 números.")
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
