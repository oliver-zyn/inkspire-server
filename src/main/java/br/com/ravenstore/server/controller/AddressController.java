package br.com.ravenstore.server.controller;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ravenstore.server.dto.AddressDTO;
import br.com.ravenstore.server.model.Address;
import br.com.ravenstore.server.service.AddressService;
import br.com.ravenstore.server.shared.GenericResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/address")
public class AddressController {
  private final AddressService addressService;
  private final ModelMapper modelMapper;

  public AddressController(AddressService addressService, ModelMapper modelMapper) {
    this.addressService = addressService;
    this.modelMapper = modelMapper;
  }

  @PostMapping("create")
  public ResponseEntity<GenericResponse> createAddress(@RequestBody @Valid AddressDTO addressDTO) {
    addressService.save(modelMapper.map(addressDTO, Address.class));

    return ResponseEntity.ok(new GenericResponse("Endereço salvo com sucesso!"));
  }
}
