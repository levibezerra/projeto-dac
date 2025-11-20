package com.levi.easy_delivery.repository;

import com.levi.easy_delivery.entity.Prato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PratoRepository extends JpaRepository<Prato, Long> {
}