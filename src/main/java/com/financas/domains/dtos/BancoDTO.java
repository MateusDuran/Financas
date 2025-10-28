package com.financas.domains.dtos;

import com.financas.domains.Banco;
import com.financas.domains.enums.TipoConta;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.Objects;

public class BancoDTO {

    private int idConta;

    @NotNull(message = "O campo nome não pode ser nulo")
    @NotBlank(message = "O campo nome não pode estar vazio")
    private String nome;

    @NotNull(message = "O campo descricao não pode ser nulo")
    @NotBlank(message = "O campo descricao não pode estar vazio")
    private String descricao;

    @NotNull(message = "O campo tipoConta não pode ser nulo")
    private TipoConta tipoConta;

    @NotNull(message = "O campo agencia não pode ser nulo")
    @NotBlank(message = "O campo agencia não pode estar vazio")
    private String agencia;

    @NotNull(message = "O campo numero não pode ser nulo")
    @NotBlank(message = "O campo numero não pode estar vazio")
    private String numero;

    private double limite;

    @NotNull(message = "O campo saldo não pode estar vazio")
    @Digits(integer = 15, fraction = 2)
    private BigDecimal saldo;

    public BancoDTO() {}

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

    public int getIdConta() { return idConta; }
    public void setIdConta(int idConta) { this.idConta = idConta; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public TipoConta getTipoConta() { return tipoConta; }
    public void setTipoConta(TipoConta tipoConta) { this.tipoConta = tipoConta; }

    public String getAgencia() { return agencia; }
    public void setAgencia(String agencia) { this.agencia = agencia; }

    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }

    public double getLimite() { return limite; }
    public void setLimite(double limite) { this.limite = limite; }

    public BigDecimal getSaldo() { return saldo; }
    public void setSaldo(BigDecimal saldo) { this.saldo = saldo; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BancoDTO bancoDTO)) return false;
        return idConta == bancoDTO.idConta &&
                Objects.equals(nome, bancoDTO.nome) &&
                Objects.equals(descricao, bancoDTO.descricao) &&
                tipoConta == bancoDTO.tipoConta &&
                Objects.equals(agencia, bancoDTO.agencia) &&
                Objects.equals(numero, bancoDTO.numero) &&
                Objects.equals(saldo, bancoDTO.saldo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idConta, nome, descricao, tipoConta, agencia, numero, saldo);
    }
}
