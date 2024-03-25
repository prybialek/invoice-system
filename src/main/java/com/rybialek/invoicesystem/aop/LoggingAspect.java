package com.rybialek.invoicesystem.aop;

import com.rybialek.invoicesystem.model.Invoice;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Component
@EnableAspectJAutoProxy
public class LoggingAspect {

    @Before("@annotation(AdditionalLogging) && args(invoice)")
    public void beforeSave(Invoice invoice) {
        System.out.println("Invoice to save: {" + invoice.getName() + ", " + invoice.getDate() + ", " +invoice.getAmount() + "}");
    }

    @After("@annotation(AdditionalLogging)")
    public void afterSave() {
        System.out.println("AFTER :: SAVE");
    }

    @Around("execution(String com.rybialek.invoicesystem.controller.InvoiceController.saveInvoice(com.rybialek.invoicesystem.model.Invoice))")
    public Object aroundSave(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("AROUND1 :: SAVE1");
        Object object = proceedingJoinPoint.proceed();
        System.out.println("AROUND2 :: SAVE2");
        return object;
    }
}
