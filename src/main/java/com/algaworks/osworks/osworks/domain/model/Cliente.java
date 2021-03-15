package com.algaworks.osworks.osworks.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String email;
    private String telefone;

    /**
     * @return the id
     */
    public Long getId(){
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id){
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getNome(){
        return nome;
    }

    /**
     * @param nome the name to set
     */
    public void setNome(String nome){
        this.nome = nome;
    }

    /**
     * @return the email
     */
    public String getEmail(){
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email){
        this.email = email;
    }

    /**
     * @return the phone
     */
    public String getTelefone(){
        return telefone;
    }

    /**
     * @param telefone the phone to set
     */
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
}
