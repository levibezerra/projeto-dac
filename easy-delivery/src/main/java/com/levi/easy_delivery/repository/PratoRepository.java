package com.levi.easy_delivery.repository;

import com.levi.easy_delivery.entity.Prato;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PratoRepository extends JpaRepository<Prato, Long> {

    List<Prato> findByCategoriaId(Long id);

    void deleteByCategoriaId(Long id);
}