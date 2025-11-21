package com.levi.easy_delivery.web.dto;

import com.levi.easy_delivery.enums.StatusPedido;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class PedidoCreateDto {

    @NotNull
    private String enderecoEntrega;
    @NotNull
    private Long clienteId;
}