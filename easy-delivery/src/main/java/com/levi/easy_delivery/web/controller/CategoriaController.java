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
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CategoriaResponseDto> getById(@PathVariable Long id) {
        Categoria categoria = categoriaService.buscarCategoriaPorId(id);
        return ResponseEntity.ok(CategoriaMapper.toDto(categoria));
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('CLIENTE')")
    public ResponseEntity<List<CategoriaResponseDto>> getAll() {
        List<Categoria> categorias = categoriaService.buscarTodasCategorias();
        return ResponseEntity.ok(CategoriaMapper.toListDto(categorias));
    }

    @PatchMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CategoriaResponseDto> updateCategory(@PathVariable Long id, @RequestBody @Valid CategoriaCreateDto createDto) {
        return ResponseEntity.ok(categoriaService.editarCategoria(id, createDto));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        categoriaService.deletarCategoria(id);
        return ResponseEntity.noContent().build();
    }
}