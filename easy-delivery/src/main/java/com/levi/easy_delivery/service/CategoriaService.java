package com.levi.easy_delivery.service;

import com.levi.easy_delivery.entity.Categoria;
import com.levi.easy_delivery.exception.CategoryNotFoundException;
import com.levi.easy_delivery.repository.CategoriaRepository;
import com.levi.easy_delivery.repository.PratoRepository;
import com.levi.easy_delivery.web.dto.CategoriaCreateDto;
import com.levi.easy_delivery.web.dto.CategoriaResponseDto;
import com.levi.easy_delivery.web.dto.mapper.CategoriaMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;
    private final PratoRepository pratoRepository;

    @Transactional
    public Categoria salvar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Transactional(readOnly = true)
    public Categoria buscarPorId(Long id) {
        return categoriaRepository.findById(id).orElseThrow(
                () -> new CategoryNotFoundException("Categoria não encontrada!")
        );
    }

    @Transactional(readOnly = true)
    public Categoria buscarCategoriaPorId(Long id) {
        return categoriaRepository.findById(id).orElseThrow(
                () -> new CategoryNotFoundException("Categoria não encontrada!"));
    }

    @Transactional(readOnly = true)
    public List<Categoria> buscarTodasCategorias() {
        return categoriaRepository.findAll();
    }

    @Transactional
    public CategoriaResponseDto editarCategoria(Long id, @Valid CategoriaCreateDto createDto) {
        Categoria categoria = categoriaRepository.findById(id).orElseThrow(
                () -> new CategoryNotFoundException("Categoria informada não encontrada para edição!"));
        categoria.setNome(createDto.getNome());
        categoria.setDescricao(createDto.getDescricao());

        categoriaRepository.save(categoria);
        return CategoriaMapper.toDto(categoria);
    }

    @Transactional
    public void deletarCategoria(Long id) {
        Categoria categoria = categoriaRepository.findById(id).orElseThrow(
                () -> new CategoryNotFoundException("Categoria informada não encontrada para deleção!"));

        pratoRepository.deleteByCategoriaId(id);
        categoriaRepository.delete(categoria);
    }
}