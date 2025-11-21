package com.levi.easy_delivery.web.controller;

import com.levi.easy_delivery.service.PratoService;
import com.levi.easy_delivery.web.dto.PratoCreateDto;
import com.levi.easy_delivery.web.dto.PratoResponseDto;
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
@RequestMapping("api/v1/pratos")
public class PratoController {

    private final PratoService pratoService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<PratoResponseDto> create(@RequestBody @Valid PratoCreateDto createDto) {
        PratoResponseDto responseDto = pratoService.salvar(createDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }
}