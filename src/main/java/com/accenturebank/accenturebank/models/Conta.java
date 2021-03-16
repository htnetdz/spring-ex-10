package com.accenturebank.accenturebank.models;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")    
    private Long id;
    @Column(name="saldo")
    private BigDecimal saldo;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the id
     */
    public BigDecimal getSaldo() {
        return saldo;
    }

    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(BigDecimal saldo) {
        // colocar saldo novo no banco
        this.saldo = saldo;
    }

    /**
     * @param valor o valor a receber
     */
    public void receber(BigDecimal valor) {
        BigDecimal saldo_atual = getSaldo();
        this.setSaldo(saldo_atual.add(saldo));
    }

    /**
     * @param valor o valor a retirar
     */
    public void transferir(BigDecimal valor) {
        BigDecimal saldo_atual = getSaldo();
        this.setSaldo(saldo_atual.subtract(saldo));
    }

}
