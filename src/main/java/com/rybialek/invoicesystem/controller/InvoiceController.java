package com.rybialek.invoicesystem.controller;

import com.rybialek.invoicesystem.model.Invoice;
import com.rybialek.invoicesystem.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class InvoiceController {

    private final InvoiceService invoiceService;

    @Autowired
    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping
    public String findAllInvoices(Model model) {
        List<Invoice> invoices = invoiceService.findAllInvoices();
        model.addAttribute("invoices", invoices);
        return "gui";
    }

    @PostMapping("/save")
    public String saveInvoice(@ModelAttribute Invoice invoice) {
        invoiceService.saveInvoice(invoice);
        return "redirect:/";
    }


    @GetMapping("/delete")
    public String deleteInvoice(@RequestParam Long id) {
        invoiceService.deleteInvoice(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editInvoice(@PathVariable Long id, Model model) {
        Invoice invoice = invoiceService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid invoice id:" + id));
        model.addAttribute("invoice", invoice);
        return "edit_invoice";
    }

    @PostMapping("/update/{id}")
    public String updateInvoice(@PathVariable("id") Long id, Invoice updatedInvoice) {
        Invoice invoice = invoiceService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid invoice id:" + id));
        invoice.setName(updatedInvoice.getName());
        invoice.setDate(updatedInvoice.getDate());
        invoice.setAmount(updatedInvoice.getAmount());

        invoiceService.saveInvoice(invoice);
        return "redirect:/";
    }
}
