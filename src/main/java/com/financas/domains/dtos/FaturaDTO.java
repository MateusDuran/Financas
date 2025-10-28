package com.financas.domains.dtos;

import com.financas.domains.Fatura;
import com.financas.domains.enums.StatusFatura;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class FaturaDTO {

    private int idFatura;

    @NotNull(message = "O campo nomeCartao não pode ser nulo")
    @NotBlank(message = "O campo nomeCartao não pode estar vazio")
    private String nomeCartao;

    @NotNull(message = "O campo contaId não pode ser nulo")
    private Integer contaId;

    @NotNull(message = "O campo statusFatura não pode ser nulo")
    private StatusFatura statusFatura;

    @NotNull(message = "O campo valorFechamento não pode ser nulo")
    @Digits(integer = 15, fraction = 2)
    private BigDecimal valorFechamento;

    private LocalDate dataFechamento;
    private LocalDate dataPagamento;

    public FaturaDTO() {}

    public FaturaDTO(Fatura fatura) {
        this.idFatura = fatura.getIdFatura();
        this.nomeCartao = fatura.getNomeCartao();
        this.contaId = fatura.getConta() != null ? fatura.getConta().getIdConta() : null;
        this.statusFatura = fatura.getStatusFatura();
        this.valorFechamento = fatura.getValorFechamento();
        this.dataFechamento = fatura.getDataFechamento();
        this.dataPagamento = fatura.getDataPagamento();
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

    public Integer getContaId() {
        return contaId;
    }

    public void setContaId(Integer contaId) {
        this.contaId = contaId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FaturaDTO that)) return false;
        return idFatura == that.idFatura &&
                Objects.equals(nomeCartao, that.nomeCartao) &&
                Objects.equals(contaId, that.contaId) &&
                statusFatura == that.statusFatura &&
                Objects.equals(valorFechamento, that.valorFechamento) &&
                Objects.equals(dataFechamento, that.dataFechamento) &&
                Objects.equals(dataPagamento, that.dataPagamento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFatura, nomeCartao, contaId, statusFatura, valorFechamento, dataFechamento, dataPagamento);
    }
}
