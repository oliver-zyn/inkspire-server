package br.com.ravenstore.server.model;

import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_product_sku")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductSku {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  private String imageUrl;

  @NotNull
  private Double price;

  @NotNull
  private Integer quantity;

  @NotNull
  private Boolean isDefault;

  @ManyToOne
  @JoinColumn(name = "product_id", nullable = false)
  @JsonIgnore
  private Product product;

  @ManyToOne
  @JoinColumn(name = "size_attribute_id")
  private ProductAttribute sizeAttribute;

  @ManyToOne
  @JoinColumn(name = "color_attribute_id")
  private ProductAttribute colorAttribute;

  @CreationTimestamp
  private LocalDateTime createdAt;

  @UpdateTimestamp
  private LocalDateTime updatedAt;
}
