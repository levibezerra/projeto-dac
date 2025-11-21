package com.levi.easy_delivery.web.dto;

import com.levi.easy_delivery.enums.TipoDePagamento;
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

public class PagamentoCreateDto {

    @NotNull
    private BigDecimal valor;
    @NotNull
    private TipoDePagamento tipoDePagamento;
    @NotNull
    private Long pedidoId;
}