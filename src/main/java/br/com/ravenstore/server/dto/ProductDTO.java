package br.com.ravenstore.server.dto;

import br.com.ravenstore.server.model.Category;
import br.com.ravenstore.server.model.Product;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
  private Long id;

  @NotNull
  private String name;

  @NotNull
  private String description;

  @NotNull
  private Category category;

  public void toDto(Product product) {
    this.id = product.getId();
    this.name = product.getName();
    this.description = product.getDescription();
    this.category = product.getCategory();
  }

  public Product fromDto() {
    Product product = new Product();
    product.setId(this.id);
    product.setName(this.name);
    product.setDescription(this.description);
    product.setCategory(this.category);
    return product;
  }
}
