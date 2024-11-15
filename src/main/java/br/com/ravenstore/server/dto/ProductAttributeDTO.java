package br.com.ravenstore.server.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductAttributeDTO {
  private Long id;

  @NotNull
  private String type;

  @NotNull
  private String value;
}
