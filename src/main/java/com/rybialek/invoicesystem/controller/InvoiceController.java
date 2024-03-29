package com.rybialek.invoicesystem.controller;

import com.rybialek.invoicesystem.aop.AdditionalLogging;
import com.rybialek.invoicesystem.dto.InvoiceDTO;
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

    public static final String REDIRECT_TO_INVOICES = "redirect:/invoices";
    private final InvoiceService invoiceService;

    @Autowired
    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping("/")
    public String home() {
        return REDIRECT_TO_INVOICES;
    }
    @GetMapping("/invoices")
    public String findAllInvoices(Model model) {
        List<InvoiceDTO> invoicesDTO = invoiceService.findAllInvoices();
        model.addAttribute("invoicesDTO", invoicesDTO);
        return "gui";
    }

    @PostMapping("/save")
    @AdditionalLogging
    public String saveInvoice(@ModelAttribute InvoiceDTO invoiceDTO) {
        invoiceService.saveInvoice(invoiceDTO);
        return REDIRECT_TO_INVOICES;
    }

    @GetMapping("/delete")
    public String deleteInvoice(@RequestParam Long id) {
        invoiceService.deleteInvoice(id);
        return REDIRECT_TO_INVOICES;
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        invoiceService.findById(id)
                .ifPresentOrElse(i -> model.addAttribute("invoiceDTO", i),
                        () -> {
                            throw new IllegalArgumentException("Invalid invoice Id:" + id);
                        });
        return "edit-invoice";
    }

    @PostMapping("/update/{id}")
    public String updateInvoice(@PathVariable("id") Long id, @Valid @ModelAttribute("invoiceDTO") InvoiceDTO invoiceDTO, BindingResult result) {
        if (result.hasErrors()) return "edit-invoice";
        invoiceService.saveInvoice(invoiceDTO);

        return REDIRECT_TO_INVOICES;
    }
}
