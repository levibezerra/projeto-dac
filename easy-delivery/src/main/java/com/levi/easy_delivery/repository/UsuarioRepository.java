package com.levi.easy_delivery.repository;

import com.levi.easy_delivery.entity.Usuario;
import com.levi.easy_delivery.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByUsername(String email);

    @Query("select u.role from Usuario u where u.email like :email")
    Role findRoleByUsername(String email);
}