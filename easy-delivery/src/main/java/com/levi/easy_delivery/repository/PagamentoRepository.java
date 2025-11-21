package com.levi.easy_delivery.repository;

import com.levi.easy_delivery.entity.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
}