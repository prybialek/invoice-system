package com.rybialek.invoicesystem.controller;

import com.rybialek.invoicesystem.model.Invoice;
import com.rybialek.invoicesystem.service.InvoiceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        invoiceService.findById(id)
                .ifPresentOrElse(i -> model.addAttribute("invoice", i),
                        () -> {
                            throw new IllegalArgumentException("Invalid invoice Id:" + id);
                        });
        return "edit-invoice";
    }

    @PostMapping("/update/{id}")
    public String updateInvoice(@PathVariable("id") Long id, @Valid @ModelAttribute("invoice") Invoice invoice, BindingResult result) {

        if (result.hasErrors()) return "edit-invoice";

        invoiceService.findById(id)
                .ifPresentOrElse(i -> {
                    i.setName(invoice.getName());
                    i.setDate(invoice.getDate());
                    i.setAmount(invoice.getAmount());
                    invoiceService.saveInvoice(i);
                }, () -> {
                    throw new IllegalArgumentException("Invalid invoice Id:" + id);
                });

        return "redirect:/";
    }
}
