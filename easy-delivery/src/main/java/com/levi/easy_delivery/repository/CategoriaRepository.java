package com.levi.easy_delivery.repository;

import com.levi.easy_delivery.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}