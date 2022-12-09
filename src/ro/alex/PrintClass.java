package ro.alex;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class PrintClass {
    Scanner reading = new Scanner(System.in);
    ReadClass read = new ReadClass();

    public void printOption(){

        System.out.println("0.Exit ");
        System.out.println("1.Creare factura ");
        System.out.println("2.Modificare factura ");
        System.out.println("3.Stergere factura ");
        System.out.println("4.Administare facturi ");
    }
    public  void printArguments(){

        System.out.println("1.Serial Number");
        System.out.println("2.Company Name");
        System.out.println("3.Address");
        System.out.println("4.Date");
        System.out.println("5.CIF");
        System.out.println("6.Invoice Total");
    }
    public void printInvoices(List<Invoice> invoices){
        for (Invoice invoice : invoices) {
            System.out.println("--------------------------");
            System.out.println("~~~~~~~~");
            System.out.println("INDEX: "+invoices.indexOf(invoice));
            System.out.println("~~~~~~~~");
            System.out.println("Serial Number: "+ invoice.serialNumber());
            System.out.println("Company Name: "+ invoice.companyName());
            System.out.println("Address: "+ invoice.address());
            System.out.println("Date: "+ invoice.date());
            System.out.println("CIF: "+ invoice.cif());
            System.out.println("Invoice Total: "+ invoice.invoiceTotal());
            System.out.println("--------------------------");
        }
    }
    public DoubleVar inputModifyInvoice(List<Invoice> invoices){
        System.out.println();
        System.out.print("Indexul facturii: ");
        int index = reading.nextInt();
        System.out.println();
        Invoice invoiceModifiabile = invoices.get(index);
        printArguments();
        System.out.println();
        System.out.print("Argumentul: ");
        int argument = reading.nextInt();
        Invoice returnInvoice = switchModifyInvoice(argument,invoiceModifiabile);
        return new DoubleVar(returnInvoice,index);
    }
    private Invoice switchModifyInvoice(int argument,Invoice invoiceModifiabile) {
        Invoice returnInvoice;
        switch (argument) {
            case 1 -> returnInvoice = modificareSerialNumber(invoiceModifiabile);
            case 2 -> returnInvoice = modificareName(invoiceModifiabile);
            case 3 -> returnInvoice = modificareAddress(invoiceModifiabile);
            case 4 -> returnInvoice = modificareDate(invoiceModifiabile);
            case 5 -> returnInvoice = modificareCIF(invoiceModifiabile);
            case 6 -> returnInvoice = modificareInvoiceTotal(invoiceModifiabile);
            default -> {
                System.out.println("ERROR!");
                return null;
            }
        }
        return returnInvoice;
    }
    private Invoice modificareInvoiceTotal(Invoice oldInvoice) {
        System.out.print("New Invoice Total: ");
        double invoiceTotal = reading.nextDouble();
        return new Invoice(oldInvoice.serialNumber(), oldInvoice.companyName(), oldInvoice.address(), oldInvoice.date(), oldInvoice.cif(), invoiceTotal);
    }
    private Invoice modificareCIF(Invoice oldInvoice) {
        System.out.print("New CIF: ");
        int cif = reading.nextInt();
        return new Invoice(oldInvoice.serialNumber(), oldInvoice.companyName(), oldInvoice.address(), oldInvoice.date(), cif, oldInvoice.invoiceTotal());
    }
    private Invoice modificareDate(Invoice oldInvoice) {
        System.out.print("New Date: ");
        LocalDate date = read.readDateValidate();
        return new Invoice(oldInvoice.serialNumber(), oldInvoice.companyName(), oldInvoice.address(), date, oldInvoice.cif(), oldInvoice.invoiceTotal());
    }
    private Invoice modificareAddress(Invoice oldInvoice) {
        System.out.print("New Address: ");
        Address address = read.readAddressValidate();
        return new Invoice(oldInvoice.serialNumber(), oldInvoice.companyName(), address, oldInvoice.date(), oldInvoice.cif(), oldInvoice.invoiceTotal());
    }
    private Invoice modificareName(Invoice oldInvoice) {
        System.out.print("New Company Name: ");
        String companyName = reading.next();
        return new Invoice(oldInvoice.serialNumber(), companyName, oldInvoice.address(), oldInvoice.date(), oldInvoice.cif(), oldInvoice.invoiceTotal());
    }
    private Invoice modificareSerialNumber(Invoice oldInvoice) {
        System.out.print("New serial number: ");
        int serialNumber = reading.nextInt();
        return new Invoice(serialNumber, oldInvoice.companyName(), oldInvoice.address(), oldInvoice.date(), oldInvoice.cif(), oldInvoice.invoiceTotal());
    }
    public int inputDeleteInvoice(){
        System.out.println();
        System.out.print("Stergeti factura cu index: ");
        int index = reading.nextInt();
        System.out.println();
        return index;
    }
    public void messageNoInvoice(){
        System.out.println("NU EXISTA FACTURI!");
    }
    public void messageInvoiceCreated(){System.out.println("FACTURA CREATA!");}
    public void messageInvoiceModified(){System.out.println("FACTURA MODIFICATA!");}
    public void messageInvoiceDeleted(){System.out.println("FACTURA STEARSA!");}

}