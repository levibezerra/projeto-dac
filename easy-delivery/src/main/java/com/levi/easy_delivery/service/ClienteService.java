package com.levi.easy_delivery.service;

import com.levi.easy_delivery.entity.Cliente;
import com.levi.easy_delivery.exception.CpfUniqueViolationException;
import com.levi.easy_delivery.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}