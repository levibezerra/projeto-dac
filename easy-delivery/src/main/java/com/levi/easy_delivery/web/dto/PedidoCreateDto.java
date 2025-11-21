package com.levi.easy_delivery.web.dto;

import com.levi.easy_delivery.enums.StatusPedido;
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

public class PedidoCreateDto {

    @NotNull
    private BigDecimal valorTotal;
    @NotBlank
    private String enderecoEntrega;
    @NotNull
    private StatusPedido statusPedido;
    @NotNull
    private Long clienteId;
    @NotNull
    private Long pagamentoId;
}