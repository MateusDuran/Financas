package com.financas.domains;

import com.financas.domains.enums.TipoConta;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name="banco")
public class Banco {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_banco")
    private int idConta;

    @NotBlank(message = "O campo nome não pode ser nulo")
    @NotNull(message = "O campo nome não pode estar vazio")
    private String nome;

    @NotBlank(message = "O campo descricao não pode ser nulo")
    @NotNull(message = "O campo descricao não pode estar vazio")
    private String descricao;

    @Enumerated(EnumType.ORDINAL)
    @JoinColumn(name="tipoConta")
    private TipoConta tipoConta;

    @NotBlank(message = "O campo agencia não pode ser nulo")
    @NotNull(message = "O campo agencia não pode estar vazio")
    private String agencia;

    @NotBlank(message = "O campo numero não pode ser nulo")
    @NotNull(message = "O campo numero não pode estar vazio")
    private String numero;

    private double limite;

    @NotNull(message = "O campo saldo não pode estar vazio")
    @Digits(integer = 15, fraction = 2)
    private BigDecimal saldo;

    public Banco() {
    }

    public Banco(int idConta, String nome, String descricao, TipoConta tipoConta, String agencia, String numero, double limite, BigDecimal saldo) {
        this.idConta = idConta;
        this.nome = nome;
        this.descricao = descricao;
        this.tipoConta = tipoConta;
        this.agencia = agencia;
        this.numero = numero;
        this.limite = limite;
        this.saldo = saldo;
    }

    public int getIdConta() {
        return idConta;
    }

    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Banco banco = (Banco) o;
        return idConta == banco.idConta && Objects.equals(nome, banco.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idConta, nome);
    }
}
