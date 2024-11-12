package br.com.ravenstore.server.controller;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.ravenstore.server.dto.AddressDTO;
import br.com.ravenstore.server.dto.AddressResponseDTO;
import br.com.ravenstore.server.model.Address;
import br.com.ravenstore.server.service.AddressService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/address")
public class AddressController {

  private final AddressService addressService;
  private final ModelMapper modelMapper;

  public AddressController(AddressService addressService, ModelMapper modelMapper) {
    this.addressService = addressService;
    this.modelMapper = modelMapper;
  }

  private AddressResponseDTO convertToResponseDto(Address address) {
    return new AddressResponseDTO(address);
  }

  @GetMapping("/user/{userId}")
  public ResponseEntity<List<AddressResponseDTO>> findAllByUserId(@PathVariable Long userId) {
    List<AddressResponseDTO> addresses = addressService.findByUserId(userId).stream()
        .map(this::convertToResponseDto)
        .collect(Collectors.toList());
    return ResponseEntity.ok(addresses);
  }

  @GetMapping("/{id}")
  public ResponseEntity<AddressResponseDTO> findOne(@PathVariable Long id) {
    Address address = addressService.findOne(id);
    if (address != null) {
      return ResponseEntity.ok(convertToResponseDto(address));
    }
    return ResponseEntity.noContent().build();
  }

  @PostMapping
  public ResponseEntity<AddressResponseDTO> create(@RequestBody @Valid AddressDTO addressDTO) {
    Address savedAddress = addressService.save(convertToEntity(addressDTO));
    return ResponseEntity.status(HttpStatus.CREATED).body(convertToResponseDto(savedAddress));
  }

  @PutMapping("/{id}")
  public ResponseEntity<AddressResponseDTO> update(@PathVariable Long id, @RequestBody @Valid AddressDTO addressDTO) {
    Address existingAddress = addressService.findOne(id);
    if (existingAddress == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    addressDTO.setId(id);
    modelMapper.map(addressDTO, existingAddress);
    Address updatedAddress = addressService.save(existingAddress);
    return ResponseEntity.ok(convertToResponseDto(updatedAddress));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    addressService.delete(id);
    return ResponseEntity.noContent().build();
  }

  private Address convertToEntity(AddressDTO addressDTO) {
    return modelMapper.map(addressDTO, Address.class);
  }
}

