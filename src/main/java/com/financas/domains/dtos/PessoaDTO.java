package com.financas.domains.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.financas.domains.Pessoa;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.util.Objects;

public class PessoaDTO {

    private int idPessoa;

    @NotBlank(message = "O campo nome não pode estar vazio")
    private String nome;

    @Email(message = "E-mail inválido")
    private String email;

    @NotBlank(message = "O campo senha não pode estar vazio")
    private String senha;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate criadoEm;

    public PessoaDTO() {
    }

    public PessoaDTO(Pessoa p) {
        this.idPessoa = p.getIdPessoa();
        this.nome = p.getNome();
        this.email = p.getEmail();
        this.senha = p.getSenha();
        this.criadoEm = p.getCriadoEm();
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

    public void setNome(@NotBlank(message = "O campo nome não pode estar vazio") String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(@Email(message = "E-mail inválido") String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(@NotBlank(message = "O campo senha não pode estar vazio") String senha) {
        this.senha = senha;
    }

    public LocalDate getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(LocalDate criadoEm) {
        this.criadoEm = criadoEm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PessoaDTO that)) return false;
        return idPessoa == that.idPessoa &&
                Objects.equals(nome, that.nome) &&
                Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPessoa, nome, email);
    }
}
