package br.com.ravenstore.server.dto;

import br.com.ravenstore.server.model.Category;
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
}
