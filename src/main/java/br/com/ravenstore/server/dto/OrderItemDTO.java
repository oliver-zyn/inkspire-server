package br.com.ravenstore.server.dto;

import br.com.ravenstore.server.model.Order;
import br.com.ravenstore.server.model.OrderItem;
import br.com.ravenstore.server.model.ProductSku;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemDTO {
  private Long id;

  @NotNull
  private Order order;

  @NotNull
  private ProductSku productSku;

  @NotNull
  private Integer quantity;

  @NotNull
  private Double price;

  public void toDto(OrderItem orderItem) {
    this.id = orderItem.getId();
    this.order = orderItem.getOrder();
    this.productSku = orderItem.getProductSku();
    this.quantity = orderItem.getQuantity();
    this.price = orderItem.getPrice();
  }

  public OrderItem fromDto() {
    OrderItem orderItem = new OrderItem();
    orderItem.setId(this.id);
    orderItem.setOrder(this.order);
    orderItem.setProductSku(this.productSku);
    orderItem.setQuantity(this.quantity);
    orderItem.setPrice(this.price);
    return orderItem;
  }
}
