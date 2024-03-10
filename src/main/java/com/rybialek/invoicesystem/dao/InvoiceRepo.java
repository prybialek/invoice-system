package com.rybialek.invoicesystem.dao;

import com.rybialek.invoicesystem.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepo extends JpaRepository<Invoice, Long> {
}
