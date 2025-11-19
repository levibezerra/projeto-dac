package com.levi.easy_delivery.service;

import com.levi.easy_delivery.entity.Usuario;
import com.levi.easy_delivery.exception.EntityNotFoundException;
import com.levi.easy_delivery.exception.UserNameUniqueViolationException;
import com.levi.easy_delivery.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Transactional
    public Usuario salvar(Usuario usuario) {
        try {
            return usuarioRepository.save(usuario);
        } catch (DataIntegrityViolationException ex) {
            throw new UserNameUniqueViolationException(String.format("E-mail {%s} já cadastrado!", usuario.getEmail()));
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
            throw new RuntimeException("Nova senha não confere com a confirmação de senha!");
        }
        Usuario user = buscarPorId(id);
        if (!user.getSenha().equals(senhaAtual)) {
            throw new RuntimeException("Sua senha não confere!");
        }
        user.setSenha(novaSenha);
        return user;
    }

    @Transactional(readOnly = true)
    public List<Usuario> buscarTodos() {
        return usuarioRepository.findAll();
    }
}