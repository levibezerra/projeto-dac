package com.levi.easy_delivery.web.dto.mapper;

import com.levi.easy_delivery.entity.Categoria;
import com.levi.easy_delivery.web.dto.CategoriaCreateDto;
import com.levi.easy_delivery.web.dto.CategoriaResponseDto;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class CategoriaMapper {

    public static Categoria toCategoria(CategoriaCreateDto createDto) {
        return new ModelMapper().map(createDto, Categoria.class);
    }

    public static CategoriaResponseDto toDto(Categoria categoria) {
        return new ModelMapper().map(categoria, CategoriaResponseDto.class);
    }

    public static List<CategoriaResponseDto> toListDto(List<Categoria> categorias) {
        return categorias.stream().map(categoria -> toDto(categoria)).collect(Collectors.toList());
    }
}