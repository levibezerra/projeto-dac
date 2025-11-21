package com.levi.easy_delivery.web.controller;

import com.levi.easy_delivery.entity.Pagamento;
import com.levi.easy_delivery.service.PagamentoService;
import com.levi.easy_delivery.web.dto.PagamentoCreateDto;
import com.levi.easy_delivery.web.dto.PagamentoResponseDto;
import com.levi.easy_delivery.web.dto.mapper.PagamentoMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/pagamentos")
public class PagamentoController {

    private final PagamentoService pagamentoService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('CLIENTE')")
    public ResponseEntity<PagamentoResponseDto> create(@RequestBody @Valid PagamentoCreateDto createDto) {
        PagamentoResponseDto responseDto = pagamentoService.salvarPagamento(createDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('CLIENTE')")
    public ResponseEntity<PagamentoResponseDto> getById(@PathVariable Long id) {
        Pagamento pagamento = pagamentoService.buscarPagamentoPorId(id);
        return ResponseEntity.ok(PagamentoMapper.toDto(pagamento));
    }
}