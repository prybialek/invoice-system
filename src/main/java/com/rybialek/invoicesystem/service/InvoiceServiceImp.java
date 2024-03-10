package com.rybialek.invoicesystem.service;

import com.rybialek.invoicesystem.dao.InvoiceRepo;
import com.rybialek.invoicesystem.model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class InvoiceServiceImp implements InvoiceService {

    private final InvoiceRepo invoiceRepo;

    @Autowired
    public InvoiceServiceImp(InvoiceRepo invoiceRepo) {
        this.invoiceRepo = invoiceRepo;
    }


    @Override
    public List<Invoice> findAllInvoices() {
        return invoiceRepo.findAll();
    }

    @Override
    public void saveInvoice(Invoice invoice) {
        invoiceRepo.save(invoice);
    }

    @Override
    public void deleteInvoice(Long id) {
        invoiceRepo.deleteById(id);
    }
}
