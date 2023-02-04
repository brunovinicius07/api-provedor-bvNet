package com.api.provedorbvNET.services;

import com.api.provedorbvNET.dtos.ClienteDto;
import com.api.provedorbvNET.entities.Cliente;
import com.api.provedorbvNET.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;


    @Transactional
    public Cliente cadastrarCliente(ClienteDto clienteDto) {
        Cliente cliente = clienteRepository.save(converteObjetoDto(clienteDto));
        return cliente;
    }

    @Transactional
    public Cliente editarCliente(ClienteDto clienteDto, Long id) {
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        if(cliente == null) {
            throw new RuntimeException("Cliente não encontrado");
        }
        cliente.setNome(clienteDto.getNome());
        cliente.setEndereco(clienteDto.getEndereco());
        cliente.setTelefone(clienteDto.getTelefone());
        cliente.setEmail(clienteDto.getEmail());
        clienteRepository.save(cliente);
        return cliente;
    }

    public Cliente buscarClientePorId(Long clienteId) {
        Cliente cliente = clienteRepository.findById(clienteId).orElse(null);
        if(cliente == null){
            throw new RuntimeException("Cliente não encontrada");
        }
        return cliente;
    }

    public Cliente converteObjetoDto(ClienteDto clienteDto) {
        return new Cliente(clienteDto.getNome(),
                clienteDto.getEndereco(),
                clienteDto.getTelefone(),
                clienteDto.getEmail());
    }
}
