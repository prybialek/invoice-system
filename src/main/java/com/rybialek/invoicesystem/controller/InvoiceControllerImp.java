package com.rybialek.invoicesystem.controller;

import com.rybialek.invoicesystem.model.Invoice;
import com.rybialek.invoicesystem.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class InvoiceControllerImp implements InvoiceContoller {

    private final InvoiceService invoiceService;

    @Autowired
    public InvoiceControllerImp(InvoiceService invoiceService) {
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
}
