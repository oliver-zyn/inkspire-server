package br.com.ravenstore.server.dto;

import br.com.ravenstore.server.model.Category;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {
  private Long id;

  @NotNull
  private String name;

  @NotNull
  private String imageUrl;

  public CategoryDTO(Category category) {
    this.id = category.getId();
    this.name = category.getName();
    this.imageUrl = category.getImageUrl();
  }
}
