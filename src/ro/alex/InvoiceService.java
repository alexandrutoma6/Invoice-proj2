package ro.alex;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

public class InvoiceService {

    private List<Invoice> invoices = new ArrayList<>();



    public void createInvoice(){
        Invoice invoice = ReadClass.readInvoice();
        addInvoice(invoice);
    }

    public boolean isEmpty(){
        if(invoices.isEmpty())
            return true;
        return false;
    }
    public void viewInvoice(){
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

    public void addInvoice(Invoice invoice){
        invoices.add(invoice);
    }

    public void removeInvoice(int index){
        invoices.remove(index);
    }

    public void modifyInvoice() {
        System.out.println();
        System.out.print("Indexul facturii pe care o modificati: ");
        int index = ReadClass.readInt();
        System.out.println();
        PrintOptions.printArguments();
        System.out.println();
        System.out.print("Argumentul pe care il modificati: ");
        int argument = ReadClass.readInt();
        Invoice newInvoice = switchModify(argument,index);
        replaceInvoice(index,newInvoice);

    }

    public Invoice switchModify(int argument,int index) {
        Invoice oldInvoice = invoices.get(index);
        switch (argument) {
            case 1:
                System.out.print("New serial number: ");
                int serialNumber = ReadClass.readInt();
                return new Invoice(serialNumber, oldInvoice.companyName(), oldInvoice.address(), oldInvoice.date(), oldInvoice.cif(), oldInvoice.invoiceTotal());

            case 2:
                System.out.print("New Company Name: ");
                String companyName = ReadClass.readString();
                return new Invoice(oldInvoice.serialNumber(), companyName, oldInvoice.address(), oldInvoice.date(), oldInvoice.cif(), oldInvoice.invoiceTotal());

            case 3:
                System.out.print("New Address: ");
                String stringAddress = ReadClass.readString();
                Address address = DataProcessing.addressProcessing(stringAddress);
                return new Invoice(oldInvoice.serialNumber(), oldInvoice.companyName(), address, oldInvoice.date(), oldInvoice.cif(), oldInvoice.invoiceTotal());

            case 4:
                System.out.print("New Date: ");
                String stringDate = ReadClass.readString();
                Date_alex date = DataProcessing.dateProcessing(stringDate);
                return new Invoice(oldInvoice.serialNumber(), oldInvoice.companyName(), oldInvoice.address(), date, oldInvoice.cif(), oldInvoice.invoiceTotal());

            case 5:
                System.out.print("New CIF: ");
                int cif = ReadClass.readInt();
                return new Invoice(oldInvoice.serialNumber(), oldInvoice.companyName(), oldInvoice.address(), oldInvoice.date(), cif, oldInvoice.invoiceTotal());

            case 6:
                System.out.print("New Invoice Total: ");
                double invoiceTotal = ReadClass.readDouble();
                return new Invoice(oldInvoice.serialNumber(), oldInvoice.companyName(), oldInvoice.address(), oldInvoice.date(), oldInvoice.cif(), invoiceTotal);

            default:
                System.out.println("ERROR!");
                return null;

        }
    }
    public void replaceInvoice(int index,Invoice inv){
        invoices.set(index,inv);
    }
}
