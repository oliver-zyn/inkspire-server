package br.com.ravenstore.server.dto;

import br.com.ravenstore.server.model.Theme;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ThemeDTO {
  private Long id;

  @NotNull
  private String name;

  public void toDto(Theme theme) {
    this.id = theme.getId();
    this.name = theme.getName();
  }

  public Theme fromDto() {
    Theme theme = new Theme();
    theme.setId(this.id);
    theme.setName(this.name);
    return theme;
  }
}
