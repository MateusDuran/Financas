package com.financas.domains;

import com.financas.domains.Conta;
import com.financas.domains.enums.StatusFatura;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="fatura")
public class Fatura {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_fatura")
    private int idFatura;
    private String nomeCartao;

    @ManyToOne
    @JoinColumn(name ="idconta")
    private Conta conta;
    private StatusFatura statusFatura;

    @NotNull
    @Digits(integer = 15, fraction = 2)
    private BigDecimal valorFechamento;
    private LocalDate dataFechamento;
    private LocalDate dataPagamento;


    public Fatura() {
    }

    public Fatura(int idFatura, String nomeCartao, Conta conta, StatusFatura statusFatura, BigDecimal valorFechamento, LocalDate dataFechamento, LocalDate dataPagamento) {
        this.idFatura = idFatura;
        this.nomeCartao = nomeCartao;
        this.conta = conta;
        this.statusFatura = statusFatura;
        this.valorFechamento = valorFechamento;
        this.dataFechamento = dataFechamento;
        this.dataPagamento = dataPagamento;
    }


    public int getIdFatura() {
        return idFatura;
    }

    public void setIdFatura(int idFatura) {
        this.idFatura = idFatura;
    }

    public String getNomeCartao() {
        return nomeCartao;
    }

    public void setNomeCartao(String nomeCartao) {
        this.nomeCartao = nomeCartao;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public StatusFatura getStatusFatura() {
        return statusFatura;
    }

    public void setStatusFatura(StatusFatura statusFatura) {
        this.statusFatura = statusFatura;
    }

    public BigDecimal getValorFechamento() {
        return valorFechamento;
    }

    public void setValorFechamento(BigDecimal valorFechamento) {
        this.valorFechamento = valorFechamento;
    }

    public LocalDate getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(LocalDate dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
}
