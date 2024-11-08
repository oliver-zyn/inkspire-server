package br.com.ravenstore.server.dto;

import br.com.ravenstore.server.model.Product;
import br.com.ravenstore.server.model.ProductTheme;
import br.com.ravenstore.server.model.Theme;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductThemeDTO {
  private Long id;

  @NotNull
  private Product product;

  @NotNull
  private Theme theme;

  public void toDto(ProductTheme productTheme) {
    this.id = productTheme.getId();
    this.product = productTheme.getProduct();
    this.theme = productTheme.getTheme();
  }

  public ProductTheme fromDto() {
    ProductTheme productTheme = new ProductTheme();
    productTheme.setId(this.id);
    productTheme.setProduct(this.product);
    productTheme.setTheme(this.theme);
    return productTheme;
  }
}
