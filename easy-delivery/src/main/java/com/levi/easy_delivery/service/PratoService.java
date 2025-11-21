package com.levi.easy_delivery.service;

import com.levi.easy_delivery.entity.Categoria;
import com.levi.easy_delivery.entity.Prato;
import com.levi.easy_delivery.exception.CategoryNotFoundException;
import com.levi.easy_delivery.exception.DishNotFoundException;
import com.levi.easy_delivery.repository.CategoriaRepository;
import com.levi.easy_delivery.repository.PratoRepository;
import com.levi.easy_delivery.web.dto.PratoCreateDto;
import com.levi.easy_delivery.web.dto.PratoResponseDto;
import com.levi.easy_delivery.web.dto.mapper.PratoMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PratoService {

    private final PratoRepository pratoRepository;
    private final CategoriaRepository categoriaRepository;
    private final CategoriaService categoriaService;

    @Transactional
    public PratoResponseDto salvar(PratoCreateDto createDto) {
        Categoria categoria = categoriaRepository.findById(createDto.getCategoriaId()).orElseThrow(
                () -> new CategoryNotFoundException("Categoria não encontrada!"));

        Prato prato = PratoMapper.toPrato(createDto, categoria);
        pratoRepository.save(prato);
        return PratoMapper.toDto(prato);
    }

    @Transactional(readOnly = true)
    public List<PratoResponseDto> buscarTodosPorCategoria(Long id) {
        categoriaService.buscarPorId(id);
        List<Prato> pratos = pratoRepository.findByCategoriaId(id);
        return PratoMapper.toListDto(pratos);
    }

    @Transactional(readOnly = true)
    public List<Prato> buscarTodos() {
        return pratoRepository.findAll();
    }

    @Transactional
    public PratoResponseDto editarPrato(Long id, PratoCreateDto createDto) {
        Prato prato = pratoRepository.findById(id).orElseThrow(
                () -> new DishNotFoundException("Prato não encontrado!"));
        Categoria categoria = categoriaRepository.findById(createDto.getCategoriaId()).orElseThrow(
                () -> new CategoryNotFoundException("Categoria não encontrada!"));

        prato.setNome(createDto.getNome());
        prato.setDescricao(createDto.getDescricao());
        prato.setPreco(createDto.getPreco());
        prato.setImagemUrl(createDto.getImagemUrl());
        prato.setStatus(createDto.getStatusDoPrato());
        prato.setCategoria(categoria);

        pratoRepository.save(prato);
        return PratoMapper.toDto(prato);
    }

    @Transactional
    public void deletar(Long id) {
        Prato prato = pratoRepository.findById(id).orElseThrow(
                () -> new DishNotFoundException("Prato não encontrado!"));
        pratoRepository.delete(prato);
    }
}