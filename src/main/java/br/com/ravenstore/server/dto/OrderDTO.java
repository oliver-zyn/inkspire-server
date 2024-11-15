package br.com.ravenstore.server.dto;

import java.util.List;

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
  private String paymentMethod;

  @NotNull
  private String status;

  @NotNull
	private Long userId;

  @NotNull
  private Long shippingAddressId;

  private List<OrderItemDTO> orderItems;
}
