package com.levi.easy_delivery.service;

import com.levi.easy_delivery.entity.ItemPedido;
import com.levi.easy_delivery.entity.Pedido;
import com.levi.easy_delivery.entity.Prato;
import com.levi.easy_delivery.exception.DishNotFoundException;
import com.levi.easy_delivery.exception.RequestNotFoundException;
import com.levi.easy_delivery.repository.ItemPedidoRepository;
import com.levi.easy_delivery.repository.PedidoRepository;
import com.levi.easy_delivery.repository.PratoRepository;
import com.levi.easy_delivery.web.dto.ItemPedidoCreateDto;
import com.levi.easy_delivery.web.dto.ItemPedidoResponseDto;
import com.levi.easy_delivery.web.dto.mapper.ItemPedidoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Service
public class ItemPedidoService {

    private final ItemPedidoRepository itemPedidoRepository;
    private final PedidoRepository pedidoRepository;
    private final PratoRepository pratoRepository;

    @Transactional
    public ItemPedidoResponseDto salvarItemPedido(ItemPedidoCreateDto createDto) {

        Pedido pedido = pedidoRepository.findById(createDto.getPedidoId()).orElseThrow(
                () -> new RequestNotFoundException("Pedido não encontrado!"));
        Prato prato = pratoRepository.findById(createDto.getPratoId()).orElseThrow(
                () -> new DishNotFoundException("Prato não encontrado!"));

        BigDecimal subTotal = prato.getPreco().multiply(BigDecimal.valueOf(createDto.getQuantidade()));

        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setQuantidade(createDto.getQuantidade());
        itemPedido.setPrecoUnitario(prato.getPreco());
        itemPedido.setSubTotal(subTotal);
        itemPedido.setPedido(pedido);
        itemPedido.setPrato(prato);

        itemPedidoRepository.save(itemPedido);

        pedido.setValorTotal(pedido.getValorTotal().add(subTotal));
        pedidoRepository.save(pedido);

        return ItemPedidoMapper.toDto(itemPedido);
    }

    @Transactional
    public ItemPedidoResponseDto editarItemPedido(Long id, ItemPedidoCreateDto createDto) {
        ItemPedido itemPedido = itemPedidoRepository.findById(id).orElseThrow(
                () -> new RequestNotFoundException("Item dos pedidos não encotrado!"));

        itemPedido.setQuantidade(createDto.getQuantidade());
        itemPedidoRepository.save(itemPedido);
        return ItemPedidoMapper.toDto(itemPedido);
    }
}