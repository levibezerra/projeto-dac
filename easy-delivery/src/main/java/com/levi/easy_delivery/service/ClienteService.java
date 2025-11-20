package com.levi.easy_delivery.service;

import com.levi.easy_delivery.entity.Cliente;
import com.levi.easy_delivery.exception.CpfUniqueViolationException;
import com.levi.easy_delivery.exception.EntityNotFoundException;
import com.levi.easy_delivery.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Transactional
    public Cliente salvar(Cliente cliente) {
        try {
            return clienteRepository.save(cliente);
        } catch (DataIntegrityViolationException ex) {
            throw new CpfUniqueViolationException(String.format("CPF '%s' nãp pode ser cadastrado, já existe no sistema!", cliente.getCpf()));
        }
    }

    @Transactional(readOnly = true)
    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("Cliente id=%s não encontrado no sistema!", id))
        );
    }

    @Transactional(readOnly = true)
    public Page<Cliente> buscarTodos(Pageable pageable) {
        return clienteRepository.findAll(pageable);
    }
}