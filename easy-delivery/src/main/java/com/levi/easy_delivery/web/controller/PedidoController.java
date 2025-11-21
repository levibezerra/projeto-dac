package com.levi.easy_delivery.web.controller;

import com.levi.easy_delivery.entity.Pedido;
import com.levi.easy_delivery.service.PedidoService;
import com.levi.easy_delivery.web.dto.PedidoCreateDto;
import com.levi.easy_delivery.web.dto.PedidoResponseDto;
import com.levi.easy_delivery.web.dto.mapper.PedidoMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('CLIENTE')")
    public ResponseEntity<PedidoResponseDto> create(@RequestBody @Valid PedidoCreateDto createDto) {
        PedidoResponseDto responseDto = pedidoService.salvarPedido(createDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PedidoResponseDto> update(@PathVariable Long id, @RequestBody @Valid PedidoCreateDto createDto) {
        return ResponseEntity.ok(pedidoService.editarPedido(id, createDto));
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('CLIENTE')")
    public ResponseEntity<List<PedidoResponseDto>> getAll() {
        List<Pedido> pedidos = pedidoService.buscarTodos();
        return ResponseEntity.ok(PedidoMapper.toListDto(pedidos));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('CLIENTE')")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        pedidoService.deletarPedido(id);
        return ResponseEntity.noContent().build();
    }
}