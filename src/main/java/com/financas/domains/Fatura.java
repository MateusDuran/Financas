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
    private IdConta idConta;
    private StatusFatura statusFatura;

    @NotNull
    @Digits(integer = 15, fraction = 2)
    private BigDecimal valorFechamento;
    private LocalDate dataFechamento;
    private LocalDate dataPagamento;

}
