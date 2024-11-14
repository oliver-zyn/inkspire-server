package br.com.ravenstore.server.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.ravenstore.server.model.ProductAttribute;
import br.com.ravenstore.server.repository.ProductAttributeRepository;

@Service
public class ProductAttributeService {
    private final ProductAttributeRepository productAttributeRepository;

    public ProductAttributeService(ProductAttributeRepository productAttributeRepository) {
        this.productAttributeRepository = productAttributeRepository;
    }

    public List<ProductAttribute> findAll() {
      return productAttributeRepository.findAll();
    }
}
