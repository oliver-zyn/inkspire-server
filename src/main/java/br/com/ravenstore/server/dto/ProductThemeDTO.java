package br.com.ravenstore.server.dto;

import br.com.ravenstore.server.model.Product;
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
}
