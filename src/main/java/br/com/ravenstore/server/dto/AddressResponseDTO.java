package br.com.ravenstore.server.dto;

import br.com.ravenstore.server.model.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressResponseDTO {

    private Long id;
    private Long userId;
    private String state;
    private String city;
    private String street;
    private String number;
    private String complement;
    private String zipCode;

    public AddressResponseDTO(Address address) {
        this.id = address.getId();
        this.userId = address.getUser().getId();
        this.state = address.getState();
        this.city = address.getCity();
        this.street = address.getStreet();
        this.number = address.getNumber();
        this.complement = address.getComplement();
        this.zipCode = address.getZipCode();
    }
}
