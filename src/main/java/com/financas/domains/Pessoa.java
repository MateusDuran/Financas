package com.financas.domains;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pessoa")
    private int idPessoa;

    private String nome;
    private String email;
    private String senha;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate criadoEm;


    public Pessoa() {
    }

    public Pessoa(int idPessoa, String nome, String email, String senha, LocalDate criadoEm) {
        this.idPessoa = idPessoa();
        this.nome = nome();
        this.email = email();
        this.senha = senha();
        this.criadoEm = criadoEm();
    }


    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDate getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(LocalDate criadoEm) {
        this.criadoEm = criadoEm;
    }
}
