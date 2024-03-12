package com.rybialek.invoicesystem.service;


import com.rybialek.invoicesystem.model.Invoice;

import java.util.List;
import java.util.Optional;

public interface InvoiceService {

    void saveInvoice(Invoice invoice);

    void deleteInvoice(Long id);

    void editInvoice(Invoice invoice);

    List<Invoice> findAllInvoices();

    Optional<Invoice> findById(Long id);
}
