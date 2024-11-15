package br.com.ravenstore.server.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.ravenstore.server.model.Order;
import br.com.ravenstore.server.model.ProductSku;
import br.com.ravenstore.server.repository.OrderRepository;
import br.com.ravenstore.server.repository.ProductSkuRepository;

@Service
public class OrderService {
  private final OrderRepository orderRepository;
  private final ProductSkuRepository productSkuRepository;

  public OrderService(OrderRepository orderRepository, ProductSkuRepository productSkuRepository) {
    this.orderRepository = orderRepository;
    this.productSkuRepository = productSkuRepository;
  }

  public Order save(Order order) {
    order.getOrderItems().forEach(item -> {
      item.setOrder(order);
      ProductSku productSku = productSkuRepository.findById(item.getProductSku().getId()).orElse(null);
      item.setPrice(productSku.getPrice());
    });

    order.setTotal(order.getOrderItems().stream()
        .mapToDouble(item -> item.getPrice() * item.getQuantity())
        .sum());

    return orderRepository.save(order);
  }

  public List<Order> findByUserId(Long userId) {
    return orderRepository.findByUserId(userId);
  }

  public Order findOne(Long id) {
    return orderRepository.findById(id).orElse(null);
  }
}
