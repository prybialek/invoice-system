package com.rybialek.invoicesystem.service;


import com.rybialek.invoicesystem.model.Invoice;

import java.util.List;

public interface InvoiceService {
    List<Invoice> findAllInvoices();

    void saveInvoice(Invoice invoice);

    void deleteInvoice(Long id);
}
