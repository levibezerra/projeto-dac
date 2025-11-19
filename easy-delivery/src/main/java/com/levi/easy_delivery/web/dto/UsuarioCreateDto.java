package com.levi.easy_delivery.web.dto;

import lombok.*;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString

public class UsuarioCreateDto {

    private String email;
    private String senha;
}