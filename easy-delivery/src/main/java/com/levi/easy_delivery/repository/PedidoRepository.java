package com.levi.easy_delivery.repository;

import com.levi.easy_delivery.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}