package com.levi.easy_delivery.web.dto;

import com.levi.easy_delivery.enums.TipoDePagamento;
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

public class PagamentoCreateDto {

    @NotBlank
    private BigDecimal valor;
    @NotBlank
    private TipoDePagamento tipoDePagamento;
    @NotBlank
    private Long pedidoId;
}