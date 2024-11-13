package br.com.ravenstore.server.dto;

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
public class ProductListResponseDTO {
  private Long id;
  private String name;
  private String description;
  private String imageUrl;
  private Long categoryId;
  private ProductSku defaultSku;

  public ProductListResponseDTO(Product product) {
    this.id = product.getId();
    this.name = product.getName();
    this.description = product.getDescription();
    this.imageUrl = product.getSkus().getFirst().getImageUrl();
    this.categoryId = product.getCategory().getId();
    this.defaultSku = product.getSkus().stream().filter(ProductSku::getIsDefault).findFirst().orElse(null);
  }
}
