package com.accenturebank.accenturebank.models;

import java.math.BigDecimal;

public class Transferencia {

    private Long idRemetente;
    private Long idDestinatario;
    private BigDecimal valor;

    public Transferencia(Long idRemetente, Long idDestinatario, BigDecimal valor) {
        this.idRemetente = idRemetente;
        this.idDestinatario = idDestinatario;
        this.valor = valor;
    }

    public Long getIdOrigem() {
        return idRemetente;
    }

    public Long getIdDestino() {
        return idDestinatario;
    }

    public BigDecimal getValor() {
        return valor;
    }

}
