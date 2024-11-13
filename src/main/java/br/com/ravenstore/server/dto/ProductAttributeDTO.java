package br.com.ravenstore.server.dto;

import br.com.ravenstore.server.model.ProductAttribute;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductAttributeDTO {
  private Long id;
  private String type;
  private String value;

  public void toDto(ProductAttribute attribute) {
    this.id = attribute.getId();
    this.type = attribute.getAttributeType();
    this.value = attribute.getAttributeValue();
  }

  public ProductAttribute fromDto() {
    ProductAttribute attribute = new ProductAttribute();
    attribute.setId(this.id);
    attribute.setAttributeType(this.type);
    attribute.setAttributeValue(this.value);
    return attribute;
  }
}
