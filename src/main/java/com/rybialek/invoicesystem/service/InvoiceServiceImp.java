package com.rybialek.invoicesystem.service;

import com.rybialek.invoicesystem.dao.InvoiceRepo;
import com.rybialek.invoicesystem.dto.InvoiceDTO;
import com.rybialek.invoicesystem.mapper.InvoiceMapper;
import com.rybialek.invoicesystem.model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class InvoiceServiceImp implements InvoiceService {

    private final InvoiceRepo invoiceRepo;
    private final InvoiceMapper invoiceMapper;


    @Autowired
    public InvoiceServiceImp(InvoiceRepo invoiceRepo, InvoiceMapper invoiceMapper) {
        this.invoiceRepo = invoiceRepo;
        this.invoiceMapper = invoiceMapper;
    }

    @Override
    public List<InvoiceDTO> findAllInvoices() {
        return invoiceMapper.toDTOList(invoiceRepo.findAll());
    }

    @Override
    public Optional<Invoice> findById(Long id) {
        return invoiceRepo.findById(id);
    }

    @Override
    public void saveInvoice(InvoiceDTO invoiceDTO) {
        invoiceRepo.save(invoiceMapper.toEntity(invoiceDTO));
    }

    @Override
    public void deleteInvoice(Long id) {
        invoiceRepo.deleteById(id);
    }

}
