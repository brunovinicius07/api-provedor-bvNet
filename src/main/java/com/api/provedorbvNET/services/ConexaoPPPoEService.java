package com.api.provedorbvNET.services;

import com.api.provedorbvNET.dtos.ConexaoPPPoEDto;
import com.api.provedorbvNET.entities.Cliente;
import com.api.provedorbvNET.entities.ConexaoPPPoE;
import com.api.provedorbvNET.repositories.ClienteRepository;
import com.api.provedorbvNET.repositories.ConexaoPPPoERepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ConexaoPPPoEService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ConexaoPPPoERepository conexaoPPPoERepository;

    @Transactional
    public ConexaoPPPoE cadastrarPPPoE(ConexaoPPPoEDto conexaoPPPoEDto) {
        ConexaoPPPoE conexaoPPPoE = conexaoPPPoERepository.save(converteObjetoDto(conexaoPPPoEDto, clienteRepository));
        return conexaoPPPoE;
    }

    public ConexaoPPPoE converteObjetoDto(ConexaoPPPoEDto conexaoPPPoEDto, ClienteRepository clienteRepository) {
        Optional<Cliente> cliente = clienteRepository.findById(conexaoPPPoEDto.getClienteId());
        return new ConexaoPPPoE(conexaoPPPoEDto.getLogin(),
                                conexaoPPPoEDto.getSenha(),
                                conexaoPPPoEDto.getIp(),
                                cliente.get());
    }

    public ConexaoPPPoE buscarPPPoEPorId(Long id) {
        ConexaoPPPoE conexaoPPPoE = conexaoPPPoERepository.findById(id).orElse(null);
        if(conexaoPPPoE == null){
            throw new RuntimeException("PPPoE não encontrado");
        }
        return conexaoPPPoE;
    }
}
