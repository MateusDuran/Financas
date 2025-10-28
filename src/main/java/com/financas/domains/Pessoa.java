package com.financas.domains;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "pessoa")
@Inheritance(strategy = InheritanceType.JOINED) // permite herdar a PK em Usuario
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pessoa")
    @SequenceGenerator(name = "seq_pessoa", sequenceName = "seq_pessoa", allocationSize = 1)
    private int idPessoa;

    @NotBlank(message = "O campo nome não pode estar vazio")
    private String nome;

    @Email(message = "E-mail inválido")
    private String email;

    @NotBlank(message = "O campo senha não pode estar vazio")
    private String senha;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate criadoEm;

    public Pessoa() {
    }

    public Pessoa(int idPessoa, String nome, String email, String senha, LocalDate criadoEm) {
        this.idPessoa = idPessoa;   // <-- corrigido
        this.nome = nome;           // <-- corrigido
        this.email = email;         // <-- corrigido
        this.senha = senha;         // <-- corrigido
        this.criadoEm = criadoEm;   // <-- corrigido
    }

    public int getIdPessoa() { return idPessoa; }
    public void setIdPessoa(int idPessoa) { this.idPessoa = idPessoa; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public LocalDate getCriadoEm() { return criadoEm; }
    public void setCriadoEm(LocalDate criadoEm) { this.criadoEm = criadoEm; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pessoa pessoa)) return false;
        return idPessoa == pessoa.idPessoa;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPessoa);
    }
}
