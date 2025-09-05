package com.financas.domains.dtos;

import com.financas.domains.Banco;
import com.financas.domains.enums.TipoConta;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class BancoDTO {

    private int idConta;

    @NotBlank(message = "O campo nome não pode ser nulo")
    @NotNull(message = "O campo nome não pode estar vazio")
    private String nome;

    @NotBlank(message = "O campo nome não pode ser nulo")
    @NotNull(message = "O campo nome não pode estar vazio")
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


    public BancoDTO() {
    }


    public BancoDTO(Banco banco) {
        this.idConta = banco.getIdConta();
        this.nome = banco.getNome();
        this.descricao = banco.getDescricao();
        this.tipoConta = banco.getTipoConta();
        this.agencia = banco.getAgencia();
        this.numero = banco.getNumero();
        this.limite = banco.getLimite();
        this.saldo = banco.getSaldo();
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
}
