package br.com.ravenstore.server.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ravenstore.server.dto.ProductAttributeDTO;
import br.com.ravenstore.server.model.ProductAttribute;
import br.com.ravenstore.server.service.ProductAttributeService;

@RestController
@RequestMapping("api/attributes")
public class ProductAttributeController {
  private final ProductAttributeService productAttributeService;
  private final ModelMapper modelMapper;

  public ProductAttributeController(ProductAttributeService productAttributeService, ModelMapper modelMapper) {
    this.productAttributeService = productAttributeService;
    this.modelMapper = modelMapper;
  }

  private ProductAttributeDTO convertToResponseDto(ProductAttribute productAttribute) {
    return modelMapper.map(productAttribute, ProductAttributeDTO.class);
  }

  @GetMapping
  public ResponseEntity<List<ProductAttributeDTO>> findAll() {
    List<ProductAttributeDTO> productAttributes = productAttributeService.findAll().stream()
        .map(this::convertToResponseDto)
        .collect(Collectors.toList());
    return ResponseEntity.ok(productAttributes);
  }
}
