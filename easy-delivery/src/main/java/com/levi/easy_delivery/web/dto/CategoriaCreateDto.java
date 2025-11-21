package com.levi.easy_delivery.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CategoriaCreateDto {

    @NotNull
    @Size(min = 4, max = 100)
    private String nome;
    @NotNull
    @Size(max = 100)
    private String descricao;
}