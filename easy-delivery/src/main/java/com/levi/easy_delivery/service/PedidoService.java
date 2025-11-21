package com.levi.easy_delivery.service;

import com.levi.easy_delivery.entity.Cliente;
import com.levi.easy_delivery.entity.Pagamento;
import com.levi.easy_delivery.entity.Pedido;
import com.levi.easy_delivery.enums.StatusPedido;
import com.levi.easy_delivery.exception.CustomerNotFoundException;
import com.levi.easy_delivery.repository.ClienteRepository;
import com.levi.easy_delivery.repository.PedidoRepository;
import com.levi.easy_delivery.web.dto.PedidoCreateDto;
import com.levi.easy_delivery.web.dto.PedidoResponseDto;
import com.levi.easy_delivery.web.dto.mapper.PedidoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ClienteService clienteService;
    private final ClienteRepository clienteRepository;
    private final PagamentoService pagamentoService;

    @Transactional
    public PedidoResponseDto salvarPedido(PedidoCreateDto createDto) {
        Cliente cliente = clienteRepository.findById(createDto.getClienteId()).orElseThrow(
                () -> new CustomerNotFoundException("Cliente não encontrado!"));
        Pedido pedido = new Pedido();

        pedido.setEnderecoEntrega(createDto.getEnderecoEntrega());
        pedido.setCliente(cliente);
        pedido.setStatus(StatusPedido.PENDENTE);
        pedido.setValorTotal(BigDecimal.ZERO);

        pedidoRepository.save(pedido);
        return PedidoMapper.toDto(pedido);
    }
}