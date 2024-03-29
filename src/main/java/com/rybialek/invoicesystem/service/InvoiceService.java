package com.rybialek.invoicesystem.service;


import com.rybialek.invoicesystem.dto.InvoiceDTO;
import com.rybialek.invoicesystem.model.Invoice;

import java.util.List;
import java.util.Optional;

public interface InvoiceService {

    void saveInvoice(InvoiceDTO invoiceDTO);

    void deleteInvoice(Long id);

    List<InvoiceDTO> findAllInvoices();

    Optional<Invoice> findById(Long id);
}
