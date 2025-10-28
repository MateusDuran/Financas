package com.financas.domains.dtos;

import com.financas.domains.Lancamento;
import com.financas.domains.enums.Situacao;
import com.financas.domains.enums.TipoLancamento;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class LancamentoDTO {

    private int idLancamento;

    @NotNull(message = "O campo descricao não pode ser nulo")
    @NotBlank(message = "O campo descricao não pode estar vazio")
    private String descricao;

    private String parcela;

    @NotNull(message = "O campo dataLancamento não pode ser nulo")
    private LocalDate dataLancamento;

    private LocalDate dataVencimento;
    private LocalDate dataBaixa;

    @NotNull(message = "O campo valorDocumento não pode ser nulo")
    @Digits(integer = 15, fraction = 2)
    private BigDecimal valorDocumento;

    @NotNull(message = "O campo tipoLancamento não pode ser nulo")
    private TipoLancamento tipoLancamento; // CREDITO / DEBITO

    @NotNull(message = "O campo situacao não pode ser nulo")
    private Situacao situacao; // ABERTO / BAIXADO

    @NotNull(message = "O campo valorBaixado não pode ser nulo")
    @Digits(integer = 15, fraction = 2)
    private BigDecimal valorBaixado;

    @NotNull(message = "O campo contaId não pode ser nulo")
    private Integer contaId;

    private Integer centroCustoId; // opcional

    public LancamentoDTO() {}

    public LancamentoDTO(Lancamento l) {
        this.idLancamento   = l.getIdLancamento();
        this.descricao      = l.getDescricao();
        this.parcela        = l.getParcela();
        this.dataLancamento = l.getDataLancamento();
        this.dataVencimento = l.getDataVencimento();
        this.dataBaixa      = l.getDataBaixa();
        this.valorDocumento = l.getValorDocumento();
        this.tipoLancamento = l.getTipoLancamento();
        this.situacao       = l.getSituacao();
        this.valorBaixado   = l.getValorBaixado();
        this.contaId        = (l.getConta() != null ? l.getConta().getIdConta() : null);
        this.centroCustoId  = (l.getCentroCusto() != null ? l.getCentroCusto().getIdCentroCusto() : null);
    }

    public int getIdLancamento() { return idLancamento; }
    public void setIdLancamento(int idLancamento) { this.idLancamento = idLancamento; }

    public String getDescricao() { return descricao; }
    public void setDescricao(@NotNull @NotBlank String descricao) { this.descricao = descricao; }

    public String getParcela() { return parcela; }
    public void setParcela(String parcela) { this.parcela = parcela; }

    public LocalDate getDataLancamento() { return dataLancamento; }
    public void setDataLancamento(@NotNull LocalDate dataLancamento) { this.dataLancamento = dataLancamento; }

    public LocalDate getDataVencimento() { return dataVencimento; }
    public void setDataVencimento(LocalDate dataVencimento) { this.dataVencimento = dataVencimento; }

    public LocalDate getDataBaixa() { return dataBaixa; }
    public void setDataBaixa(LocalDate dataBaixa) { this.dataBaixa = dataBaixa; }

    public BigDecimal getValorDocumento() { return valorDocumento; }
    public void setValorDocumento(@NotNull BigDecimal valorDocumento) { this.valorDocumento = valorDocumento; }

    public TipoLancamento getTipoLancamento() { return tipoLancamento; }
    public void setTipoLancamento(@NotNull TipoLancamento tipoLancamento) { this.tipoLancamento = tipoLancamento; }

    public Situacao getSituacao() { return situacao; }
    public void setSituacao(@NotNull Situacao situacao) { this.situacao = situacao; }

    public BigDecimal getValorBaixado() { return valorBaixado; }
    public void setValorBaixado(@NotNull BigDecimal valorBaixado) { this.valorBaixado = valorBaixado; }

    public Integer getContaId() { return contaId; }
    public void setContaId(@NotNull Integer contaId) { this.contaId = contaId; }

    public Integer getCentroCustoId() { return centroCustoId; }
    public void setCentroCustoId(Integer centroCustoId) { this.centroCustoId = centroCustoId; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LancamentoDTO that)) return false;
        return idLancamento == that.idLancamento &&
                Objects.equals(descricao, that.descricao) &&
                Objects.equals(parcela, that.parcela) &&
                Objects.equals(dataLancamento, that.dataLancamento) &&
                Objects.equals(dataVencimento, that.dataVencimento) &&
                Objects.equals(dataBaixa, that.dataBaixa) &&
                Objects.equals(valorDocumento, that.valorDocumento) &&
                tipoLancamento == that.tipoLancamento &&
                situacao == that.situacao &&
                Objects.equals(valorBaixado, that.valorBaixado) &&
                Objects.equals(contaId, that.contaId) &&
                Objects.equals(centroCustoId, that.centroCustoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLancamento, descricao, parcela, dataLancamento, dataVencimento, dataBaixa,
                valorDocumento, tipoLancamento, situacao, valorBaixado, contaId, centroCustoId);
    }
}
