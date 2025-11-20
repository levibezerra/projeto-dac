package com.levi.easy_delivery.web.dto;

import com.levi.easy_delivery.enums.StatusDoPrato;
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

public class PratoCreateDto {

    @NotBlank
    private String nome;
    @NotBlank
    private String descricao;
    @NotNull
    private BigDecimal preco;
    private String imagemUrl;
    @NotNull
    private StatusDoPrato statusDoPrato;
    @NotNull
    private Long categoriaId;
}