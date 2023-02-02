package com.api.provedorbvNET.controllers;

import com.api.provedorbvNET.dtos.ClienteDto;
import com.api.provedorbvNET.entities.Cliente;
import com.api.provedorbvNET.services.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping(value = "/cadastrarCliente")
    public ResponseEntity<Cliente> cadastrarCliente(@RequestBody @Valid ClienteDto clienteDto) {
        return new ResponseEntity<Cliente>(clienteService.cadastrarCliente(clienteDto), HttpStatus.CREATED);
    }
}
