package br.com.ravenstore.server.dto;

import java.util.List;
import java.util.stream.Collectors;

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
  private CategoryDTO category;
  private List<ProductSku> skus;
  private List<ThemeDTO> themes;

  public ProductResponseDTO(Product product) {
    this.id = product.getId();
    this.name = product.getName();
    this.description = product.getDescription();
    this.category = new CategoryDTO(product.getCategory());
    this.skus = product.getSkus();
    this.themes = product.getThemes().stream().map(theme -> new ThemeDTO(theme.getId(), theme.getName())).collect(Collectors.toList());
  }
}
