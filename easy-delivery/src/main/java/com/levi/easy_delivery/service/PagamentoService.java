package com.levi.easy_delivery.service;

import com.levi.easy_delivery.entity.Pagamento;
import com.levi.easy_delivery.entity.Pedido;
import com.levi.easy_delivery.enums.StatusPedido;
import com.levi.easy_delivery.exception.PaymentNotFoundException;
import com.levi.easy_delivery.exception.RequestNotFoundException;
import com.levi.easy_delivery.exception.InvalidPaymentValueException;
import com.levi.easy_delivery.repository.PagamentoRepository;
import com.levi.easy_delivery.repository.PedidoRepository;
import com.levi.easy_delivery.web.dto.PagamentoCreateDto;
import com.levi.easy_delivery.web.dto.PagamentoResponseDto;
import com.levi.easy_delivery.web.dto.mapper.PagamentoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PagamentoService {

    private final PagamentoRepository pagamentoRepository;
    private final PedidoRepository pedidoRepository;

    @Transactional
    public PagamentoResponseDto salvarPagamento(PagamentoCreateDto createDto) {
        Pedido pedido = pedidoRepository.findById(createDto.getPedidoId()).orElseThrow(
                () -> new RequestNotFoundException("Pedido não encontrado!"));

        if (pedido.getValorTotal().compareTo(createDto.getValor()) != 0) {
            throw new InvalidPaymentValueException("Valor do pagamento diferente do valor do pedido!");
        }
        Pagamento pagamento = PagamentoMapper.toPagamento(createDto);
        pagamento.setPedido(pedido);

        pagamentoRepository.save(pagamento);

        pedido.setStatus(StatusPedido.FINALIZADO);
        pedidoRepository.save(pedido);

        return PagamentoMapper.toDto(pagamento);
    }

    @Transactional(readOnly = true)
    public Pagamento buscarPagamentoPorId(Long id) {
        return pagamentoRepository.findById(id).orElseThrow(
                () -> new PaymentNotFoundException("Pagamento não encontrado!")
        );
    }
}