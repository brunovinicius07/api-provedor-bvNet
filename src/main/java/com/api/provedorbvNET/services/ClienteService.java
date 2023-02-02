package com.api.provedorbvNET.services;

import com.api.provedorbvNET.dtos.ClienteDto;
import com.api.provedorbvNET.entities.Cliente;
import com.api.provedorbvNET.repositories.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Transactional
    public Cliente cadastrarCliente(ClienteDto clienteDto) {
        Cliente cliente = clienteRepository.save(converteObjetoDto(clienteDto));
        return cliente;
    }

    private Cliente converteObjetoDto(ClienteDto clienteDto) {
        return new Cliente(clienteDto.getNome(),
                           clienteDto.getEndereco(),
                           clienteDto.getTelefone(),
                           clienteDto.getEmail());
    }
}
