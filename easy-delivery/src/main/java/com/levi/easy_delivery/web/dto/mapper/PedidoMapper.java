package com.levi.easy_delivery.web.dto.mapper;

import com.levi.easy_delivery.entity.Pedido;
import com.levi.easy_delivery.web.dto.PedidoCreateDto;
import com.levi.easy_delivery.web.dto.PedidoResponseDto;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class PedidoMapper {

    public static Pedido toPedido(PedidoCreateDto createDto) {
        return new ModelMapper().map(createDto, Pedido.class);
    }

    public static PedidoResponseDto toDto(Pedido pedido) {
        PedidoResponseDto responseDto = new ModelMapper().map(pedido, PedidoResponseDto.class);
        responseDto.setClienteId(pedido.getCliente().getId());
        return responseDto;
    }

    public static List<PedidoResponseDto> toListDto(List<Pedido> pedidos) {
        return pedidos.stream().map(pedido -> toDto(pedido)).collect(Collectors.toList());
    }
}