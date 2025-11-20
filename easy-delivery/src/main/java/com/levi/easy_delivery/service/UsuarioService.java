package com.levi.easy_delivery.service;

import com.levi.easy_delivery.entity.Usuario;
import com.levi.easy_delivery.enums.Role;
import com.levi.easy_delivery.exception.EntityNotFoundException;
import com.levi.easy_delivery.exception.PasswordInvalidException;
import com.levi.easy_delivery.exception.UsernameUniqueViolationException;
import com.levi.easy_delivery.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Usuario salvar(Usuario usuario) {
        try {
            usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
            return usuarioRepository.save(usuario);
        } catch (DataIntegrityViolationException ex) {
            throw new UsernameUniqueViolationException(String.format("E-mail {%s} já cadastrado!", usuario.getEmail()));
        }
    }

    @Transactional(readOnly = true)
    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("Usuáro id=%s não encontrado!", id))
        );
    }

    @Transactional
    public Usuario editarSenha(Long id, String senhaAtual, String novaSenha, String confirmaSenha) {
        if (!novaSenha.equals(confirmaSenha)) {
            throw new PasswordInvalidException("Nova senha não confere com a confirmação de senha!");
        }
        Usuario user = buscarPorId(id);
        if (!passwordEncoder.matches(senhaAtual, user.getSenha())) {
            throw new PasswordInvalidException("Sua senha não confere!");
        }
        user.setSenha(passwordEncoder.encode(novaSenha));
        return user;
    }

    @Transactional(readOnly = true)
    public List<Usuario> buscarTodos() {
        return usuarioRepository.findAll();
    }

    public Usuario buscaPorUsername(String email) {
        return usuarioRepository.findByUsername(email).orElseThrow(
                () -> new EntityNotFoundException(String.format("Usuáro com '%s' não encontrado!", email))
        );
    }

    public Role buscarRolePorUsername(String email) {
        return usuarioRepository.findRoleByUsername(email);
    }
}