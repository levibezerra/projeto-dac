package com.levi.easy_delivery.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString

public class UsuarioCreateDto {

    @NotBlank
    @Email(message = "formato de e-mail invalido!", regexp = "^[a-z0-9.+-]+@[a-z0-9.-]+\\.[a-z]{2,}$")
    private String email;
    @NotBlank
    @Size(min = 6, max = 6)
    private String senha;
}