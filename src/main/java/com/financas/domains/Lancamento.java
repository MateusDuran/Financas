package com.financas.domains;

import com.financas.domains.enums.Situacao;
import com.financas.domains.enums.TipoLancamento;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name="lancamento")
public class Lancamento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_lancamento")
    private int idLancamento;

    @NotNull
    private String descricao;

    private String parcela;

    @NotNull
    private LocalDate dataLancamento;

    private LocalDate dataVencimento;
    private LocalDate dataBaixa;

    @NotNull
    @Digits(integer = 15, fraction = 2)
    private BigDecimal valorDocumento;

    @Enumerated(EnumType.STRING)
    @NotNull
    private TipoLancamento tipoLancamento; // CREDITO / DEBITO

    @Enumerated(EnumType.STRING)
    @NotNull
    private Situacao situacao; // ABERTO / BAIXADO

    @NotNull
    @Digits(integer = 15, fraction = 2)
    private BigDecimal valorBaixado;

    @ManyToOne
    @JoinColumn(name = "idconta", nullable = false)
    private Conta conta;

    @ManyToOne
    @JoinColumn(name = "idcentrocusto")
    private CentroCusto centroCusto;

    public Lancamento() {}

    public Lancamento(int idLancamento, String descricao, String parcela, LocalDate dataLancamento,
                      LocalDate dataVencimento, LocalDate dataBaixa, BigDecimal valorDocumento,
                      TipoLancamento tipoLancamento, Situacao situacao, BigDecimal valorBaixado,
                      Conta conta, CentroCusto centroCusto) {
        this.idLancamento = idLancamento;
        this.descricao = descricao;
        this.parcela = parcela;
        this.dataLancamento = dataLancamento;
        this.dataVencimento = dataVencimento;
        this.dataBaixa = dataBaixa;
        this.valorDocumento = valorDocumento;
        this.tipoLancamento = tipoLancamento;
        this.situacao = situacao;
        this.valorBaixado = valorBaixado;
        this.conta = conta;
        this.centroCusto = centroCusto;
    }

    public int getIdLancamento() { return idLancamento; }
    public void setIdLancamento(int idLancamento) { this.idLancamento = idLancamento; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getParcela() { return parcela; }
    public void setParcela(String parcela) { this.parcela = parcela; }

    public LocalDate getDataLancamento() { return dataLancamento; }
    public void setDataLancamento(LocalDate dataLancamento) { this.dataLancamento = dataLancamento; }

    public LocalDate getDataVencimento() { return dataVencimento; }
    public void setDataVencimento(LocalDate dataVencimento) { this.dataVencimento = dataVencimento; }

    public LocalDate getDataBaixa() { return dataBaixa; }
    public void setDataBaixa(LocalDate dataBaixa) { this.dataBaixa = dataBaixa; }

    public BigDecimal getValorDocumento() { return valorDocumento; }
    public void setValorDocumento(BigDecimal valorDocumento) { this.valorDocumento = valorDocumento; }

    public TipoLancamento getTipoLancamento() { return tipoLancamento; }
    public void setTipoLancamento(TipoLancamento tipoLancamento) { this.tipoLancamento = tipoLancamento; }

    public Situacao getSituacao() { return situacao; }
    public void setSituacao(Situacao situacao) { this.situacao = situacao; }

    public BigDecimal getValorBaixado() { return valorBaixado; }
    public void setValorBaixado(BigDecimal valorBaixado) { this.valorBaixado = valorBaixado; }

    public Conta getConta() { return conta; }
    public void setConta(Conta conta) { this.conta = conta; }

    public CentroCusto getCentroCusto() { return centroCusto; }
    public void setCentroCusto(CentroCusto centroCusto) { this.centroCusto = centroCusto; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lancamento that)) return false;
        return idLancamento == that.idLancamento &&
                Objects.equals(descricao, that.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLancamento, descricao);
    }
}
