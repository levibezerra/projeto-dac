package com.levi.easy_delivery.web.dto;

import com.levi.easy_delivery.enums.StatusDoPrato;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class PratoResponseDto {

    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private String imagemUrl;
    private StatusDoPrato statusDoPrato;
    private Long categoriaId;
}