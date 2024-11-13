package br.com.ravenstore.server.dto;

import java.util.List;

import br.com.ravenstore.server.model.Product;
import br.com.ravenstore.server.model.ProductSku;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDTO {

  private Long id;
  private String name;
  private String description;
  private Long categoryId;
  private List<ProductSku> skus;

  public ProductResponseDTO(Product product) {
    this.id = product.getId();
    this.name = product.getName();
    this.description = product.getDescription();
    this.categoryId = product.getCategory().getId();
    this.skus = product.getSkus();
  }
}
