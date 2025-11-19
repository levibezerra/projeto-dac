package com.levi.easy_delivery.web.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class UsuarioResponseDto {

    private Long id;
    private String email;
    private String role;
}