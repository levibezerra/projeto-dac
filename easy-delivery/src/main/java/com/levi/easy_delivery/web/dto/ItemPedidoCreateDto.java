package com.levi.easy_delivery.web.dto;

import jakarta.validation.constraints.NotBlank;
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

    @NotBlank
    private int quantidade;
    @NotBlank
    private BigDecimal precoUnitario;
    @NotBlank
    private BigDecimal subTotal;
    @NotBlank
    private Long pratoId;
    @NotBlank
    private Long pedidoId;
}