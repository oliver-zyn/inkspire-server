package br.com.ravenstore.server.dto;

import java.time.LocalDate;

import br.com.ravenstore.server.model.User;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
  private Long id;

  @NotNull
  private String name;

  @NotNull
  private String email;

  @NotNull
  private String cpf;

  @NotNull
  private LocalDate birthOfDate;

  @NotNull
  private String phoneNumber;

  public void toDto(User user) {
    this.id = user.getId();
    this.name = user.getName();
    this.email = user.getEmail();
    this.cpf = user.getCpf();
    this.birthOfDate = user.getBirthOfDate();
    this.phoneNumber = user.getPhoneNumber();
  }

  public User fromDto() {
    User user = new User();
    user.setId(this.id);
    user.setName(this.name);
    user.setEmail(this.email);
    user.setCpf(this.cpf);
    user.setBirthOfDate(this.birthOfDate);
    user.setPhoneNumber(this.phoneNumber);
    return user;
  }
}
