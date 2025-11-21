package com.levi.easy_delivery.web.dto.mapper;

import com.levi.easy_delivery.entity.ItemPedido;
import com.levi.easy_delivery.web.dto.ItemPedidoCreateDto;
import com.levi.easy_delivery.web.dto.ItemPedidoResponseDto;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class ItemPedidoMapper {

    public static ItemPedido toItemPedido(ItemPedidoCreateDto createDto) {
        return new ModelMapper().map(createDto, ItemPedido.class);
    }

    public static ItemPedidoResponseDto toDto(ItemPedido itemPedido) {
        ItemPedidoResponseDto responseDto = new ModelMapper().map(itemPedido,
                ItemPedidoResponseDto.class);
        responseDto.setPratoId(itemPedido.getPrato().getId());
        responseDto.setPedidoId(itemPedido.getPedido().getId());
        return responseDto;
    }

    public static List<ItemPedidoResponseDto> toListDto(List<ItemPedido> itemPedidos) {
        return itemPedidos.stream().map(itemPedido -> toDto(itemPedido)).collect(Collectors.toList());
    }
}