package com.api.provedorbvNET.controllers;

import com.api.provedorbvNET.dtos.ClienteDto;
import com.api.provedorbvNET.entities.Cliente;
import com.api.provedorbvNET.services.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping(value = "/cadastrarCliente")
    public ResponseEntity<Cliente>cadastrarCliente(@RequestBody @Valid ClienteDto clienteDto) {
        return new ResponseEntity<Cliente>(clienteService.cadastrarCliente(clienteDto), HttpStatus.CREATED);
    }

    @PutMapping(value = "/editarCliente/{id}")
    public ResponseEntity<Cliente>editarCliente(@PathVariable(value = "id") Long id, @RequestBody @Valid ClienteDto clienteDto) {
        return new ResponseEntity<Cliente>(clienteService.editarCliente(clienteDto, id), HttpStatus.OK);
    }

    @GetMapping(value = "/buscarCliente/{id}")
    public ResponseEntity<Cliente>buscarClientePorId(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<Cliente>(clienteService.buscarClientePorId(id),HttpStatus.OK);
    }

    @GetMapping(value = "/listarClientes")
    public ResponseEntity<List<Cliente>> listarClientes() {
        return new ResponseEntity<List<Cliente>>(clienteService.listarClientes(),HttpStatus.OK);
    }


}
