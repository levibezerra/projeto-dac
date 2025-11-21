package com.levi.easy_delivery.web.dto;

import com.levi.easy_delivery.enums.StatusPedido;
import jakarta.validation.constraints.NotBlank;
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

    @NotBlank
    private BigDecimal valorTotal;
    @NotBlank
    private String enderecoEntrega;
    @NotBlank
    private StatusPedido statusPedido;
    @NotBlank
    private Long clienteId;
    @NotBlank
    private Long pagamentoId;
}