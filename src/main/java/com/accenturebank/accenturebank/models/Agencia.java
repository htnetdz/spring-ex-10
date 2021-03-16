package com.accenturebank.accenturebank.models;

//falta o package
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
public class Agencia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")  
    private Long id;
    @Column(name="endereco")  
    private String endereco;
    @Column(name="telefone")  
    private String telefone;

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
     * @return o endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the name to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the phone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the phone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
