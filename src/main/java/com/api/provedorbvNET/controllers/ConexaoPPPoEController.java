package com.api.provedorbvNET.controllers;

import com.api.provedorbvNET.dtos.ConexaoPPPoEDto;
import com.api.provedorbvNET.entities.ConexaoPPPoE;
import com.api.provedorbvNET.repositories.ClienteRepository;
import com.api.provedorbvNET.repositories.ConexaoPPPoERepository;
import com.api.provedorbvNET.services.ConexaoPPPoEService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/PPPoE")
public class ConexaoPPPoEController {

    @Autowired
    private ConexaoPPPoERepository conexaoPPPoERepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ConexaoPPPoEService conexaoPPPoEService;

    @PostMapping(value = ("/cadastrarPPPoE"))
    public ResponseEntity<ConexaoPPPoE> cadastrarPPPoE(@RequestBody @Valid ConexaoPPPoEDto conexaoPPPoEDto){
        return new ResponseEntity<ConexaoPPPoE>(conexaoPPPoEService.cadastrarPPPoE(conexaoPPPoEDto), HttpStatus.CREATED);
    }
}
