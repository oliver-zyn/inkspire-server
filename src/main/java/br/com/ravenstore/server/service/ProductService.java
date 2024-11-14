package br.com.ravenstore.server.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.ravenstore.server.model.Product;
import br.com.ravenstore.server.repository.ProductRepository;

@Service
public class ProductService {
  private final ProductRepository productRepository;

  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public Product findOne(Long id) {
    return productRepository.findById(id).orElse(null);
  }

  public List<Product> findAll() {
    return productRepository.findAll();
  }

  public Page<Product> findAll(Pageable pageable) {
    return productRepository.findAll(pageable);
  };

  public List<Product> findAll(Sort sort) {
    return productRepository.findAll(sort);
  }

  public Page<Product> filterProductsPaginated(List<Long> categoryIds, List<Long> themeIds, String color, String size, Double minPrice, Double maxPrice, Pageable pageable) {
    return productRepository.findFilteredProductsPaginated(categoryIds, themeIds, color, size, minPrice, maxPrice, pageable);
  }

}
