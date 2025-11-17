package com.levi.easy_delivery.repository;

import com.levi.easy_delivery.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}