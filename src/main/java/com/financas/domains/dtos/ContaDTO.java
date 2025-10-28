package com.financas.domains.dtos;

import com.financas.domains.Conta;
import com.financas.domains.enums.TipoConta;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.Objects;

public class ContaDTO {

    private int idConta;

    @NotNull(message = "O campo nome não pode ser nulo")
    @NotBlank(message = "O campo nome não pode estar vazio")
    private String nome;

    @NotNull(message = "O campo descricao não pode ser nulo")
    @NotBlank(message = "O campo descricao não pode estar vazio")
    private String descricao;

    @NotNull(message = "O campo tipoConta não pode ser nulo")
    private TipoConta tipoConta;

    private String agencia;
    private String numero;
    private double limite;

    @NotNull(message = "O campo saldo não pode ser nulo")
    @Digits(integer = 15, fraction = 2)
    private BigDecimal saldo;

    public ContaDTO() {}

    public ContaDTO(Conta c) {
        this.idConta = c.getIdConta();
        this.nome = c.getNome();
        this.descricao = c.getDescricao();
        this.tipoConta = c.getTipoConta();
        this.agencia = c.getAgencia();
        this.numero = c.getNumero();
        this.limite = c.getLimite();
        this.saldo = c.getSaldo();
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
        if (!(o instanceof ContaDTO contaDTO)) return false;
        return idConta == contaDTO.idConta &&
                Objects.equals(nome, contaDTO.nome) &&
                Objects.equals(descricao, contaDTO.descricao) &&
                tipoConta == contaDTO.tipoConta &&
                Objects.equals(agencia, contaDTO.agencia) &&
                Objects.equals(numero, contaDTO.numero) &&
                Objects.equals(saldo, contaDTO.saldo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idConta, nome, descricao, tipoConta, agencia, numero, saldo);
    }
}
