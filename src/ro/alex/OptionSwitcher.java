package ro.alex;

public class OptionSwitcher {

    InvoiceService invoiceService = new InvoiceService();
    PrintClass print = new PrintClass();

    public void choseOption(int option) {
        switch (option) {
            case 1 -> creareFactura();
            case 2 -> modificareFactura();
            case 3 -> stergereFactura();
            case 4 -> afisareFactura();
            case 0 -> exit();
            default -> System.out.print("ATI INTRODUS O VALOARE GRESITA!");
        }
    }
    private void creareFactura () {
        System.out.println();
        invoiceService.createInvoice();
        print.messageInvoiceCreated();
    }
    private void modificareFactura(){
        if(invoiceService.isEmpty()){print.messageNoInvoice();}
        else {
            print.printInvoices(invoiceService.getInvoices());
            System.out.println();
            invoiceService.modifyInvoice(print.inputModifyInvoice(invoiceService.getInvoices()));
            print.messageInvoiceModified();
        }
    }
    private void stergereFactura(){
        if(invoiceService.isEmpty()){print.messageNoInvoice();}
        else {
            print.printInvoices(invoiceService.getInvoices());
            invoiceService.removeInvoice(print.inputDeleteInvoice());
            print.messageInvoiceDeleted();
        }
    }
    private void afisareFactura(){
        if(invoiceService.isEmpty()){print.messageNoInvoice();}
        else {
            print.printInvoices(invoiceService.getInvoices());
        }
    }
    private void exit(){
        System.out.println("EXIT!");
    }
}

