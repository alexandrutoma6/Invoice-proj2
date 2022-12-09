package ro.alex;

import java.util.ArrayList;
import java.util.List;

public class InvoiceService {

    private final List<Invoice> invoices = new ArrayList<>();
    ReadClass read = new ReadClass();

    public void createInvoice(){
        Invoice invoice = read.readInvoiceValidate();
        addInvoice(invoice);
    }
    public boolean isEmpty(){
        return invoices.isEmpty();
    }
    public void removeInvoice(int index){
        invoices.remove(index);
    }
    public void modifyInvoice(DoubleVar result){
        System.out.println();
        replaceInvoice(result.index(), result.invoice());
    }
    public List<Invoice> getInvoices(){
        return invoices;
    }
    private void replaceInvoice(int index,Invoice inv){
        invoices.set(index,inv);
    }
    private void addInvoice(Invoice invoice){
        invoices.add(invoice);
    }
}
