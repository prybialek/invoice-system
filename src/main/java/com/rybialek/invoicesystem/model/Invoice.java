package com.rybialek.invoicesystem.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Invoice {

    @Id
    @SequenceGenerator(name = "invoice_seq", sequenceName = "invoice_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "invoice_seq")
    private Long id;

    @Column
    private String name;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @Column
    private BigDecimal amount;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
