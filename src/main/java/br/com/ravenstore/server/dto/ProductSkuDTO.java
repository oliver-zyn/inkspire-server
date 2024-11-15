package br.com.ravenstore.server.dto;

import br.com.ravenstore.server.model.Product;
import br.com.ravenstore.server.model.ProductAttribute;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductSkuDTO {
  private Long id;

  @NotNull
  private String imageUrl;

  @NotNull
  private Double price;

  @NotNull
  private Integer quantity;

  @NotNull
  private Boolean isDefault;

  @NotNull
  private Product product;

  @NotNull
  private ProductAttribute sizeAttribute;

  @NotNull
  private ProductAttribute colorAttribute;
}
