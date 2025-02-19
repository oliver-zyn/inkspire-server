package br.com.ravenstore.server.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.ravenstore.server.model.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponseDTO {
	private Long id;
	private String paymentMethod;
	private String status;
	private Double total;
	private UserResponseDTO user;
	private AddressDTO shippingAddress;
	private List<OrderItemResponseDTO> items;
	private LocalDateTime created_at;

	public OrderResponseDTO(Order order) {
		this.id = order.getId();
		this.paymentMethod = order.getPaymentMethod();
		this.status = order.getStatus();
		this.total = order.getTotal();
		this.user = new UserResponseDTO(order.getUser());
		this.shippingAddress = new AddressDTO(order.getShippingAddress());
		this.created_at = order.getCreatedAt();
		this.items = (order.getOrderItems() != null)
				? order.getOrderItems().stream().map(OrderItemResponseDTO::new).collect(Collectors.toList())
				: new ArrayList<>();
	}
}
