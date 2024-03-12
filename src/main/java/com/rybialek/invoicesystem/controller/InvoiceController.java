package com.rybialek.invoicesystem.controller;

import com.rybialek.invoicesystem.model.Invoice;
import org.springframework.ui.Model;

public interface InvoiceController {
    String deleteInvoice(Long id);
    String editInvoice(Long id, Model model);
    String saveInvoice(Invoice invoice);

}
