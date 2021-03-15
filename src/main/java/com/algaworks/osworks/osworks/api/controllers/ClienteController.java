package com.algaworks.osworks.osworks.api.controllers;

import java.util.Arrays;
import java.util.List;

import com.algaworks.osworks.osworks.domain.model.Cliente;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {
    
    @GetMapping("/clientes")
    public List<Cliente> listar(){
        var cliente1 = new Cliente();
        cliente1.setId(1L);
        cliente1.setNome("joão");
        cliente1.setTelefone("81 9999-2918");
        cliente1.setEmail("joao@joao.com");

        var cliente2 = new Cliente();
        cliente2.setId(2L);
        cliente2.setNome("maria");
        cliente2.setTelefone("81 9799-2918");
        cliente2.setEmail("maria@maria.com");

        return Arrays.asList(cliente1, cliente2);
    }
}
