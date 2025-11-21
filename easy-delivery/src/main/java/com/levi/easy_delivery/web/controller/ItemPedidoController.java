package com.levi.easy_delivery.web.controller;

import com.levi.easy_delivery.service.ItemPedidoService;
import com.levi.easy_delivery.web.dto.ItemPedidoCreateDto;
import com.levi.easy_delivery.web.dto.ItemPedidoResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/itemPedidos")
public class ItemPedidoController {

    private final ItemPedidoService itemPedidoService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('CLIENTE')")
    public ResponseEntity<ItemPedidoResponseDto> create(@RequestBody @Valid ItemPedidoCreateDto createDto) {
        ItemPedidoResponseDto responseDto = itemPedidoService.salvarItemPedido(createDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ItemPedidoResponseDto> update(@PathVariable Long id, @RequestBody @Valid ItemPedidoCreateDto createDto) {
        return ResponseEntity.ok(itemPedidoService.editarItemPedido(id, createDto));
    }
}