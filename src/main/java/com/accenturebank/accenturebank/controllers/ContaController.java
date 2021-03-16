package com.accenturebank.accenturebank.controllers;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.accenturebank.accenturebank.models.Conta;
import com.accenturebank.accenturebank.models.Transferencia;

import com.accenturebank.accenturebank.repositories.ContaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import javax.validation.Valid;

@RestController
public class ContaController {

    @Autowired
    private ContaRepository _contaRepository;

    @RequestMapping(value = "/contas", method = RequestMethod.GET)
    public List<Conta> Get() {
        return _contaRepository.findAll();
    }

    @RequestMapping(value = "/conta/{id}", method = RequestMethod.GET)
    public ResponseEntity<Conta> GetById(@PathVariable(value = "id") long id) {
        Optional<Conta> conta = _contaRepository.findById(id);
        if (conta.isPresent())
            return new ResponseEntity<Conta>(conta.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/criarConta", method = RequestMethod.POST)
    public Conta Post(@Valid @RequestBody Conta conta) {
        return _contaRepository.save(conta);
    }

    @RequestMapping(value = "/conta/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Conta> Put(@PathVariable(value = "id") long id, @Valid @RequestBody Conta newConta) {
        Optional<Conta> oldConta = _contaRepository.findById(id);
        if (oldConta.isPresent()) {
            Conta conta = oldConta.get();
            conta.setSaldo(newConta.getSaldo());
            _contaRepository.save(conta);
            return new ResponseEntity<Conta>(conta, HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/conta/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id) {
        Optional<Conta> pessoa = _contaRepository.findById(id);
        if (pessoa.isPresent()) {
            _contaRepository.delete(pessoa.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/transferir", method = RequestMethod.POST)
    public void Post(@Valid @RequestBody Transferencia transferencia) {
        Optional<Conta> contaOrigem = _contaRepository.findById(transferencia.getIdOrigem());
        Optional<Conta> contaDestino = _contaRepository.findById(transferencia.getIdDestino());
        BigDecimal valor = transferencia.getValor();
        contaOrigem.get().transferir(valor);
        contaDestino.get().receber(valor);
        _contaRepository.save(contaOrigem.get());
        _contaRepository.save(contaDestino.get());
    }

    @RequestMapping(value = "/depositar", method = RequestMethod.POST)
    public void Deposito(@Valid @RequestBody Transferencia transferencia) {
 
        Optional<Conta> contaDestino = _contaRepository.findById(transferencia.getIdDestino());
        BigDecimal valor = transferencia.getValor();
        contaDestino.get().receber(valor);
        _contaRepository.save(contaDestino.get());
    }
 
    @RequestMapping(value = "/sacar", method = RequestMethod.POST)
    public void Saque(@Valid @RequestBody Transferencia transferencia) {
        Optional<Conta> contaOrigem = _contaRepository.findById(transferencia.getIdOrigem());
        BigDecimal valor = transferencia.getValor();
        contaOrigem.get().transferir(valor);
        _contaRepository.save(contaOrigem.get());
 
    }
}
