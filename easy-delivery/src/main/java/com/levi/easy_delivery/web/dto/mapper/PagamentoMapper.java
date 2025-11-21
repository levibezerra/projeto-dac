package com.levi.easy_delivery.web.dto.mapper;

import com.levi.easy_delivery.entity.Pagamento;
import com.levi.easy_delivery.web.dto.PagamentoCreateDto;
import com.levi.easy_delivery.web.dto.PagamentoResponseDto;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class PagamentoMapper {

    public static Pagamento toPagamento(PagamentoCreateDto createDto) {
        return new ModelMapper().map(createDto, Pagamento.class);
    }

    public static PagamentoResponseDto toDto(Pagamento pagamento) {
        PagamentoResponseDto responseDto = new ModelMapper().map(pagamento, PagamentoResponseDto.class);
        responseDto.setPedidoId(pagamento.getPedido().getId());
        return responseDto;
    }

    public static List<PagamentoResponseDto> toListDto(List<Pagamento> pagamentos) {
        return pagamentos.stream().map(pagamento -> toDto(pagamento)).collect(Collectors.toList());
    }
}