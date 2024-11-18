package br.com.ravenstore.server.controller;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.ravenstore.server.dto.AddressCepDTO;
import br.com.ravenstore.server.dto.AddressDTO;
import br.com.ravenstore.server.model.Address;
import br.com.ravenstore.server.service.AddressService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/address")
public class AddressController {

  private final AddressService addressService;
  private final ModelMapper modelMapper;

  public AddressController(AddressService addressService, ModelMapper modelMapper) {
    this.addressService = addressService;
    this.modelMapper = modelMapper;
  }

  private AddressDTO convertToResponseDto(Address address) {
    return modelMapper.map(address, AddressDTO.class);
  }

  private Address convertToEntity(AddressDTO addressDTO) {
    return modelMapper.map(addressDTO, Address.class);
  }

  private AddressDTO convertToResponseCepDto(AddressCepDTO addressCepDTO) {
    modelMapper.typeMap(AddressCepDTO.class, AddressDTO.class)
        .addMappings(mapper -> {
          mapper.map(AddressCepDTO::getLocalidade, AddressDTO::setCity);
          mapper.map(AddressCepDTO::getLogradouro, AddressDTO::setStreet);
          mapper.map(AddressCepDTO::getUf, AddressDTO::setState);
          mapper.map(AddressCepDTO::getCep, AddressDTO::setZipCode);
          mapper.map(AddressCepDTO::getComplemento, AddressDTO::setComplement);
        });

    return modelMapper.map(addressCepDTO, AddressDTO.class);
  }

  @GetMapping("user/{userId}")
  public ResponseEntity<List<AddressDTO>> findAllByUserId(@PathVariable Long userId) {
    List<AddressDTO> addresses = addressService.findByUserId(userId).stream()
        .map(this::convertToResponseDto)
        .collect(Collectors.toList());
    return ResponseEntity.ok(addresses);
  }

  @GetMapping("{id}")
  public ResponseEntity<AddressDTO> findOne(@PathVariable Long id) {
    Address address = addressService.findOne(id);
    if (address == null) {
      throw new EntityNotFoundException("Endereço não encontrado com id: " + id);
    }
    return ResponseEntity.ok(convertToResponseDto(address));
  }

  @PostMapping
  public ResponseEntity<AddressDTO> create(@RequestBody @Valid AddressDTO addressDTO) {
    Address savedAddress = addressService.save(convertToEntity(addressDTO));
    return ResponseEntity.status(HttpStatus.CREATED).body(convertToResponseDto(savedAddress));
  }

  @PutMapping("{id}")
  public ResponseEntity<AddressDTO> update(@PathVariable Long id, @RequestBody @Valid AddressDTO addressDTO) {
    Address address = addressService.findOne(id);
    if (address == null) {
      throw new EntityNotFoundException("Endereço não encontrado com id: " + id);
    }
    addressDTO.setId(id);
    Address updatedAddress = addressService.save(convertToEntity(addressDTO));
    return ResponseEntity.ok(convertToResponseDto(updatedAddress));
  }

  @DeleteMapping("{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    Address address = addressService.findOne(id);
    if (address == null) {
      throw new EntityNotFoundException("Endereço não encontrado com id: " + id);
    }
    addressService.delete(id);
    return ResponseEntity.noContent().build();
  }

  @GetMapping("validate/{cep}")
  public ResponseEntity<AddressDTO> validateAndFetchCep(@PathVariable String cep) {
    AddressCepDTO addressCepDTO = addressService.getCepData(cep);

    return ResponseEntity.ok(convertToResponseCepDto(addressCepDTO));
  }
}
