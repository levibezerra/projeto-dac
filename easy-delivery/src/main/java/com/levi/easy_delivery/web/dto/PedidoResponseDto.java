package com.levi.easy_delivery.web.dto;

import com.levi.easy_delivery.enums.StatusPedido;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class PedidoResponseDto {

    private Long id;
    private BigDecimal valorTotal;
    private String enderecoEntrega;
    private StatusPedido statusPedido;
    private Long clienteId;
    private Long pagamentoId;
}