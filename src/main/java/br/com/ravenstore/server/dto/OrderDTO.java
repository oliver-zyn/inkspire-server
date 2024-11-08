package br.com.ravenstore.server.dto;

import br.com.ravenstore.server.model.Address;
import br.com.ravenstore.server.model.Order;
import br.com.ravenstore.server.model.User;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
  private Long id;

  @NotNull
  private User user;

  @NotNull
  private Address shippingAddress;

  @NotNull
  private String paymentMethod;

  @NotNull
  private String status;

  @NotNull
  private Double total;

  public void toDto(Order order) {
    this.id = order.getId();
    this.user = order.getUser();
    this.shippingAddress = order.getShippingAddress();
    this.paymentMethod = order.getPaymentMethod();
    this.status = order.getStatus();
    this.total = order.getTotal();
  }

  public Order fromDto() {
    Order order = new Order();
    order.setId(this.id);
    order.setUser(this.user);
    order.setShippingAddress(this.shippingAddress);
    order.setPaymentMethod(this.paymentMethod);
    order.setStatus(this.status);
    order.setTotal(this.total);
    return order;
  }
}
