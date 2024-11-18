package br.com.ravenstore.server.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.ravenstore.server.dto.AddressCepDTO;
import br.com.ravenstore.server.model.Address;
import br.com.ravenstore.server.repository.AddressRepository;

@Service
public class AddressService {
  private final AddressRepository addressRepository;
  private final RestTemplate restTemplate;

  public AddressService(AddressRepository addressRepository) {
    this.addressRepository = addressRepository;
    this.restTemplate = new RestTemplate();
  }

  public Address save(Address address) {
    return addressRepository.save(address);
  }

  public Address findOne(Long id) {
    return addressRepository.findById(id).orElse(null);
  }

  public List<Address> findByUserId(Long userId) {
    return addressRepository.findByUserId(userId);
  }

  public void delete(Long id) {
    addressRepository.deleteById(id);
  }

  public AddressCepDTO getCepData(String cep) {
    AddressCepDTO addressCepDTO = new AddressCepDTO();

    try {
      String apiUrl = "https://viacep.com.br/ws/" + cep + "/json/";
      addressCepDTO = restTemplate.getForObject(apiUrl, AddressCepDTO.class);
    } catch (Exception e) {
      throw new IllegalArgumentException("Formato de CEP inválido");
    }

    if (addressCepDTO == null || addressCepDTO.getCep() == null) {
      throw new IllegalArgumentException("CEP inválido");
    }

    return addressCepDTO;
  }

}
