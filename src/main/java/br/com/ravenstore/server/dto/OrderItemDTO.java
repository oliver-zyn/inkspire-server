package br.com.ravenstore.server.dto;

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
    private Integer quantity;

    @NotNull
    private Long productSkuId;
}
