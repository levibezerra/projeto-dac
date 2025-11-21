package com.levi.easy_delivery.web.dto;

import com.levi.easy_delivery.enums.TipoDePagamento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class PagamentoResponseDto {

    private Long id;
    private BigDecimal valor;
    private TipoDePagamento tipoDePagamento;
    private Long pedidoId;
}