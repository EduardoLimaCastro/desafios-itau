package com.desafio.itau.domain.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.UUID;

public class Transaction {
    //==============
    // Atributes
    //==============

    private UUID id;
    private BigDecimal valor;
    private OffsetDateTime dataHora;

    //==============
    // Constructors
    //==============

    protected Transaction() {}

    public Transaction (
            UUID id,
            BigDecimal valor,
            OffsetDateTime dataHora
    ) {
        this.id = id;
        this.valor = valor;
        this.dataHora = dataHora;
    }

    //==============
    // Factory
    //==============

    public static Transaction create(
            BigDecimal valor,
            OffsetDateTime dataHora
    ) {

        validate(valor, dataHora);

        return new Transaction(
                UUID.randomUUID(),
                valor,
                dataHora);
    }

    public static Transaction reconstitute(
            UUID id,
            BigDecimal valor,
            OffsetDateTime dataHora
    ) {
        return new Transaction(
                id,
                valor,
                dataHora);
    }

    //==============
    // Validators
    //==============

    private static void validate(BigDecimal valor, OffsetDateTime dataHora) {
        if (valor.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Valor da transação deve ser maior que zero.");
        }
        if(dataHora.compareTo(OffsetDateTime.now()) > 0) {
            throw new IllegalArgumentException("Data e hora da transação não podem ser futuras.");
        }
    }

    //==============
    // Identity
    //==============

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transaction other)) return false;
        return Objects.equals(id, other.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    // =========================
    // Getters
    // =========================
    public UUID getId() {return id;}
    public BigDecimal getValor() {return valor;}
    public OffsetDateTime getDataHora() {return dataHora;}
}
