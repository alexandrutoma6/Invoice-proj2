package ro.alex;

import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;

public class OptionSwitcher {

    InvoiceService invoiceService = new InvoiceService();
    public void choseOption(int option){

        switch (option){

            case 1:
                System.out.println("CREARE FACTURA");
                System.out.println();
                invoiceService.createInvoice();
                System.out.println("FACUTRA CREATA!");
                break;

            case 2:
                if(invoiceService.isEmpty())
                    System.out.println("NU EXISTA FACTURI!");
                else {
                    invoiceService.viewInvoice();
                    System.out.println();
                    invoiceService.modifyInvoice();
                    System.out.println("FACTURA MODIFICATA");
                }
                break;

            case 3:
                if(invoiceService.isEmpty())
                    System.out.println("NU EXISTA FACTURI!");
                else {
                    invoiceService.viewInvoice();
                    System.out.println();
                    System.out.print("Stergeti factura cu index: ");
                    int index = ReadClass.readInt();
                    invoiceService.removeInvoice(index);
                    System.out.println("FACTURA STEARSA!");
                }
                break;

            case 4:
                if(invoiceService.isEmpty())
                    System.out.println("NU EXISTA FACTURI!");
                else
                    invoiceService.viewInvoice();
                break;

            case 0:
                System.out.println("EXIT!");
                break;
            default:
                System.out.print("ATI INTRODUS O VALOARE GRESITA!");
        }
    }
}
