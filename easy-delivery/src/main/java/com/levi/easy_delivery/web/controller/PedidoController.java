package com.levi.easy_delivery.web.controller;

import com.levi.easy_delivery.service.PedidoService;
import com.levi.easy_delivery.web.dto.PedidoCreateDto;
import com.levi.easy_delivery.web.dto.PedidoResponseDto;
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
@RequestMapping("api/v1/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('CLIENTE')")
    public ResponseEntity<PedidoResponseDto> create(@RequestBody @Valid PedidoCreateDto createDto) {
        PedidoResponseDto responseDto = pedidoService.salvarPedido(createDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }
}