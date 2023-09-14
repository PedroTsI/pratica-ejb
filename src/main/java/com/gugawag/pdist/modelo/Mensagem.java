package com.gugawag.pdist.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity(name = "tb_mensagem_pdist")
public class Mensagem implements Serializable {

    @Id
    private long id;
    private String texto;

    public Mensagem(){

    }

    public Mensagem(long id, String texto){
        this.id = id;
        this.texto = texto;
    }

    public long getId() {
        return id;
    }

    public String getTexto() {
        return texto;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}

