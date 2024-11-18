package br.com.ravenstore.server.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ravenstore.server.dto.OrderDTO;
import br.com.ravenstore.server.dto.OrderResponseDTO;
import br.com.ravenstore.server.model.Order;
import br.com.ravenstore.server.service.OrderService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

  private final OrderService orderService;
  private final ModelMapper modelMapper;

  public OrderController(OrderService orderService, ModelMapper modelMapper) {
    this.orderService = orderService;
    this.modelMapper = modelMapper;
  }

  private OrderResponseDTO convertToResponseDto(Order order) {
    return modelMapper.map(order, OrderResponseDTO.class);
  }

  private Order convertToEntity(OrderDTO orderDTO) {
    return modelMapper.map(orderDTO, Order.class);
  }

  @PostMapping("checkout")
  public ResponseEntity<OrderResponseDTO> create(@RequestBody @Valid OrderDTO orderDTO) {
    Order order = orderService.save(convertToEntity(orderDTO));
    return ResponseEntity.status(HttpStatus.CREATED).body(convertToResponseDto(order));
  }

  @GetMapping("user/{id}")
  public ResponseEntity<List<OrderResponseDTO>> findAllByUserId(@PathVariable Long id) {
    List<OrderResponseDTO> orders = orderService.findByUserId(id).stream()
        .map(OrderResponseDTO::new)
        .collect(Collectors.toList());
    return ResponseEntity.ok(orders);
  }

  @GetMapping("{id}")
  public ResponseEntity<OrderResponseDTO> findOne(@PathVariable Long id) {
    Order order = orderService.findOne(id);
    if (order == null) {
      throw new EntityNotFoundException("Pedido não encontrado com id: " + id);
    }
    return ResponseEntity.ok(convertToResponseDto(order));
  }
}
