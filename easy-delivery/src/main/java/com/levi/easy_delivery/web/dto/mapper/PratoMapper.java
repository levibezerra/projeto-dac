package com.levi.easy_delivery.web.dto.mapper;

import com.levi.easy_delivery.entity.Categoria;
import com.levi.easy_delivery.entity.Prato;
import com.levi.easy_delivery.web.dto.PratoCreateDto;
import com.levi.easy_delivery.web.dto.PratoResponseDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import java.util.List;
import java.util.stream.Collectors;

public class PratoMapper {

    public static Prato toPrato(PratoCreateDto createDto, Categoria categoria) {
        Prato prato = new Prato();
        prato.setNome(createDto.getNome());
        prato.setDescricao(createDto.getDescricao());
        prato.setPreco(createDto.getPreco());
        prato.setImagemUrl(createDto.getImagemUrl());
        prato.setStatus(createDto.getStatusDoPrato());
        prato.setCategoria(categoria);
        return prato;
    }

    public static PratoResponseDto toDto(Prato prato) {
        ModelMapper mapper = new ModelMapper();
        PropertyMap<Prato, PratoResponseDto> props = new PropertyMap<Prato, PratoResponseDto>() {
            @Override
            protected void configure() {
                map().setCategoriaId(source.getCategoria().getId());
            }
        };
        mapper.addMappings(props);
        return mapper.map(prato, PratoResponseDto.class);
    }

    public static List<PratoResponseDto> toListDto(List<Prato> pratos) {
        return pratos.stream().map(prato -> toDto(prato)).collect(Collectors.toList());
    }
}