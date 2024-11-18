package br.com.ravenstore.server.model;

import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_address")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @Size(min = 2, max = 2, message = "O Estado deve possuir exatamente 2 caracteres")
  private String state;

  @NotNull
  @Size(min = 2, max = 50, message = "A cidade deve ter no mínimo 2 e no máximo 50 caracteres")
  private String city;
  
  @NotNull
  @Size(min = 5, max = 100, message = "A rua deve ter no mínimo 5 e no máximo 100 caracteres")
  private String street;
  
  @NotNull
  @Size(min = 1, max = 10, message = "A rua deve ter no mínimo 1 e no máximo 100 caracteres")
  private String number;
  
  private String complement;
  
  @NotNull
  @Pattern(regexp = "\\d{8}", message = "O CEP deve conter exatamente 8 números.")
  private String zipCode;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @CreationTimestamp
  private LocalDateTime createdAt;

  @UpdateTimestamp
  private LocalDateTime updatedAt;
}
