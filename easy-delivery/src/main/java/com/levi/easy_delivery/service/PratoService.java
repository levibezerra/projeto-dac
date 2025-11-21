package com.levi.easy_delivery.service;

import com.levi.easy_delivery.entity.Categoria;
import com.levi.easy_delivery.entity.Prato;
import com.levi.easy_delivery.exception.CategoryNotFoundException;
import com.levi.easy_delivery.repository.CategoriaRepository;
import com.levi.easy_delivery.repository.PratoRepository;
import com.levi.easy_delivery.web.dto.PratoCreateDto;
import com.levi.easy_delivery.web.dto.PratoResponseDto;
import com.levi.easy_delivery.web.dto.mapper.PratoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PratoService {

    private final PratoRepository pratoRepository;
    private final CategoriaRepository categoriaRepository;

    public PratoResponseDto salvar(PratoCreateDto createDto) {
        Categoria categoria = categoriaRepository.findById(createDto.getCategoriaId()).orElseThrow(
                () -> new CategoryNotFoundException("Categoria não encontrada!"));

        Prato prato = PratoMapper.toPrato(createDto, categoria);
        pratoRepository.save(prato);
        return PratoMapper.toDto(prato);
    }
}