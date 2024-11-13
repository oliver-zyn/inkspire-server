package br.com.ravenstore.server.dto;

import br.com.ravenstore.server.model.Product;
import br.com.ravenstore.server.model.ProductAttribute;
import br.com.ravenstore.server.model.ProductSku;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductSkuDTO {
  private Long id;

  @NotNull
  private Product product;

  @NotNull
  private ProductAttribute sizeAttribute;

  @NotNull
  private ProductAttribute colorAttribute;

  @NotNull
  private String imageUrl;

  @NotNull
  private Double price;

  @NotNull
  private Integer quantity;

  @NotNull
  private Boolean isDefault;

  public void toDto(ProductSku sku) {
    this.id = sku.getId();
    this.product = sku.getProduct();
    this.sizeAttribute = sku.getSizeAttribute();
    this.colorAttribute = sku.getColorAttribute();
    this.imageUrl = sku.getImageUrl();
    this.price = sku.getPrice();
    this.quantity = sku.getQuantity();
    this.isDefault = sku.getIsDefault();
  }

  public ProductSku fromDto() {
    ProductSku sku = new ProductSku();
    sku.setId(this.id);
    sku.setProduct(this.product);
    sku.setSizeAttribute(this.sizeAttribute);
    sku.setColorAttribute(this.colorAttribute);
    sku.setImageUrl(this.imageUrl);
    sku.setPrice(this.price);
    sku.setQuantity(this.quantity);
    sku.setIsDefault(isDefault);
    return sku;
  }

  public ProductSkuDTO(ProductSku sku) {
    this.id = sku.getId();
    this.product = sku.getProduct();
    this.sizeAttribute = sku.getSizeAttribute();
    this.colorAttribute = sku.getColorAttribute();
    this.imageUrl = sku.getImageUrl();
    this.price = sku.getPrice();
    this.quantity = sku.getQuantity();
    this.isDefault = sku.getIsDefault();
  }
}
