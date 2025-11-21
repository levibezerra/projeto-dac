package com.levi.easy_delivery.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ItemPedidoResponseDto {

    private Long id;
    private int quantidade;
    private BigDecimal precoUnitario;
    private BigDecimal subTotal;
    private Long pratoId;
    private Long pedidoId;
}