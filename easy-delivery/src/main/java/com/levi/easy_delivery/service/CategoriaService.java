package com.levi.easy_delivery.service;

import com.levi.easy_delivery.entity.Categoria;
import com.levi.easy_delivery.exception.CategoryNotFoundException;
import com.levi.easy_delivery.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

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
}