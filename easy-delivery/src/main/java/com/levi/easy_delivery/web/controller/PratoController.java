package com.levi.easy_delivery.web.controller;

import com.levi.easy_delivery.entity.Prato;
import com.levi.easy_delivery.service.PratoService;
import com.levi.easy_delivery.web.dto.PratoCreateDto;
import com.levi.easy_delivery.web.dto.PratoResponseDto;
import com.levi.easy_delivery.web.dto.mapper.PratoMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/pratos")
public class PratoController {

    private final PratoService pratoService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<PratoResponseDto> create(@RequestBody @Valid PratoCreateDto createDto) {
        PratoResponseDto responseDto = pratoService.salvar(createDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @GetMapping("/{id}/categorias")
    @PreAuthorize("hasRole('ADMIN') or hasRole('CLIENTE')")
    public ResponseEntity<List<PratoResponseDto>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(pratoService.buscarTodosPorCategoria(id));
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('CLIENTE')")
    public ResponseEntity<List<PratoResponseDto>> getAll() {
        List<Prato> pratos = pratoService.buscarTodos();
        return ResponseEntity.ok(PratoMapper.toListDto(pratos));
    }

    @PatchMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<PratoResponseDto> update(@PathVariable Long id, @RequestBody @Valid PratoCreateDto createDto) {
        return ResponseEntity.ok(pratoService.editarPrato(id, createDto));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        pratoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}