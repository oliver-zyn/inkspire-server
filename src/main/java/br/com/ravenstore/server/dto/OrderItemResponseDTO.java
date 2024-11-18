package br.com.ravenstore.server.dto;

import br.com.ravenstore.server.model.OrderItem;
import br.com.ravenstore.server.model.ProductSku;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemResponseDTO {
	private Long id;
	private Integer quantity;
	private Double price;
	private ProductSku productSku;

	public OrderItemResponseDTO(OrderItem orderItem) {
		this.id = orderItem.getId();
		this.productSku = orderItem.getProductSku();
		this.quantity = orderItem.getQuantity();
		this.price = orderItem.getPrice();
	}
}
