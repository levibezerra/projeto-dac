package com.levi.easy_delivery.web.dto;

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

public class ItemPedidoCreateDto {

    @NotNull
    private int quantidade;
    @NotNull
    private BigDecimal precoUnitario;
    @NotNull
    private BigDecimal subTotal;
    @NotNull
    private Long pratoId;
    @NotNull
    private Long pedidoId;
}