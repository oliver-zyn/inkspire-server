package br.com.ravenstore.server.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.ravenstore.server.model.Product;
import br.com.ravenstore.server.model.ProductSku;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductListResponseDTO {
  private Long id;
  private String name;
  private String description;
  private CategoryDTO category;
  private ProductSku defaultSku;
  private List<ThemeDTO> themes;

  public ProductListResponseDTO(Product product) {
    this.id = product.getId();
    this.name = product.getName();
    this.description = product.getDescription();
    this.category = new CategoryDTO(product.getCategory());
    this.defaultSku = product.getSkus().stream().filter(ProductSku::getIsDefault).findFirst().orElse(null);
    this.themes = product.getThemes().stream().map(theme -> new ThemeDTO(theme.getId(), theme.getName()))
        .collect(Collectors.toList());
  }
}
