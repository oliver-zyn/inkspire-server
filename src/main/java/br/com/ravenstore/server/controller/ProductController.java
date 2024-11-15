package br.com.ravenstore.server.controller;

import br.com.ravenstore.server.dto.ProductListResponseDTO;
import br.com.ravenstore.server.dto.ProductResponseDTO;
import br.com.ravenstore.server.model.Product;
import br.com.ravenstore.server.model.ProductSku;
import br.com.ravenstore.server.service.ProductService;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/products")
public class ProductController {
  private final ProductService productService;
  private final ModelMapper modelMapper;

  public ProductController(ProductService productService, ModelMapper modelMapper) {
    this.productService = productService;
    this.modelMapper = modelMapper;
  }

  private ProductResponseDTO convertToResponseDto(Product product) {
    return new ProductResponseDTO(product);
  }

  private ProductListResponseDTO convertToListResponseDto(Product product) {
    return new ProductListResponseDTO(product);
  }

  @GetMapping
  public ResponseEntity<List<ProductListResponseDTO>> findAll() {
    List<ProductListResponseDTO> products = productService.findAll().stream()
        .map(this::convertToListResponseDto)
        .collect(Collectors.toList());
    return ResponseEntity.ok(products);
  }

  @GetMapping("search")
  public ResponseEntity<Page<ProductListResponseDTO>> searchProducts(
      @RequestParam int page,
      @RequestParam int size,
      @RequestParam(required = false) String order,
      @RequestParam(required = false) Boolean asc,
      @RequestParam(required = false) List<Long> categoryIds,
      @RequestParam(required = false) List<Long> themeIds,
      @RequestParam(required = false) String color,
      @RequestParam(required = false) String sizeAttr,
      @RequestParam(required = false) Double minPrice,
      @RequestParam(required = false) Double maxPrice) {

    PageRequest pageRequest = PageRequest.of(page, size);
    if (order != null && asc != null) {
      pageRequest = PageRequest.of(page, size,
          asc ? Sort.Direction.ASC : Sort.Direction.DESC, order);
    }

    return ResponseEntity.ok(productService.filterProductsPaginated(
      categoryIds, themeIds, color, sizeAttr, minPrice, maxPrice, pageRequest).map(this::convertToListResponseDto));
  }

  @GetMapping("{id}")
  public ResponseEntity<ProductResponseDTO> findOne(@PathVariable Long id) {
    Product product = productService.findOne(id);
    if (product == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    ProductResponseDTO productResponse = convertToResponseDto(product);
    productResponse.setSkus(product.getSkus().stream()
        .map(sku -> modelMapper.map(sku, ProductSku.class))
        .collect(Collectors.toList()));
    return ResponseEntity.ok(productResponse);
  }
}
