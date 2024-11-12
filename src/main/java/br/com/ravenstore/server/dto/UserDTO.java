package br.com.ravenstore.server.dto;

import java.time.LocalDate;

import br.com.ravenstore.server.model.User;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
  @Email
  @Column(unique = true)
  private String email;

  @NotNull
  @Size(min = 8)
  @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$")
  private String password;

  @NotNull
  @Column(unique = true)
  private String cpf;

  @NotNull
  private LocalDate birthOfDate;

  @NotNull
  private String phoneNumber;

  public void toDto(User user) {
    this.id = user.getId();
    this.name = user.getName();
    this.email = user.getEmail();
    this.password = user.getPassword();
    this.cpf = user.getCpf();
    this.birthOfDate = user.getBirthOfDate();
    this.phoneNumber = user.getPhoneNumber();
  }

  public User fromDto() {
    User user = new User();
    user.setId(id);
    user.setName(this.name);
    user.setEmail(this.email);
    user.setPassword(this.password);
    user.setCpf(this.cpf);
    user.setBirthOfDate(this.birthOfDate);
    user.setPhoneNumber(this.phoneNumber);
    return user;
  }
}
