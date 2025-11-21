package com.levi.easy_delivery.web.controller;

import com.levi.easy_delivery.entity.Categoria;
import com.levi.easy_delivery.service.CategoriaService;
import com.levi.easy_delivery.web.dto.CategoriaCreateDto;
import com.levi.easy_delivery.web.dto.CategoriaResponseDto;
import com.levi.easy_delivery.web.dto.mapper.CategoriaMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CategoriaResponseDto> create(@RequestBody @Valid CategoriaCreateDto createDto) {
        Categoria categoria = categoriaService.salvar(CategoriaMapper.toCategoria(createDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(CategoriaMapper.toDto(categoria));
    }
}