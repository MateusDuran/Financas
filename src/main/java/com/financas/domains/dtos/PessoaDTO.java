package com.financas.domains.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.financas.domains.Pessoa;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class PessoaDTO {

    private int idPessoa;

    @NotBlank(message = "O campo nome não pode ser nulo")
    @NotNull(message = "O campo nome não pode estar vazio")
    private String nome;
    private String email;
    private String senha;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate criadoEm;


    public PessoaDTO() {
    }

    public PessoaDTO(Pessoa pessoa) {
        this.idPessoa = pessoa.getIdPessoa();
        this.nome = pessoa.getNome();
        this.email = pessoa.getEmail();
        this.senha = pessoa.getSenha();
        this.criadoEm = pessoa.getCriadoEm();
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
