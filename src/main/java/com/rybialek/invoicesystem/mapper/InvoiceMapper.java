package com.rybialek.invoicesystem.mapper;

import com.rybialek.invoicesystem.dto.InvoiceDTO;
import com.rybialek.invoicesystem.model.Invoice;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class InvoiceMapper {
    public InvoiceDTO toDTO(Invoice invoice) {
        InvoiceDTO invoiceDTO = new InvoiceDTO();
        invoiceDTO.setId(invoice.getId());
        invoiceDTO.setName(invoice.getName());
        invoiceDTO.setDate(invoice.getDate());
        invoiceDTO.setAmount(invoice.getAmount());
        return invoiceDTO;
    }

    public Invoice toEntity(InvoiceDTO invoiceDto) {
        Invoice invoice = new Invoice();
        invoice.setId(invoiceDto.getId());
        invoice.setName(invoiceDto.getName());
        invoice.setDate(invoiceDto.getDate());
        invoice.setAmount(invoiceDto.getAmount());
        return invoice;
    }

    public List<InvoiceDTO> toDTOList(List<Invoice> invoices) {
        return invoices.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public List<Invoice> toEntityList(List<InvoiceDTO> invoicesDTO) {
        return invoicesDTO.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }
}
