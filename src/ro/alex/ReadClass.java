package ro.alex;

import java.util.Scanner;

public class ReadClass {

    public static Invoice readInvoice(){
        Scanner read = new Scanner(System.in);
        System.out.print("Serial Number: ");
        int serialNumber = Integer.parseInt(read.nextLine());
        System.out.print("Company Name: ");
        String companyName = read.nextLine();
        System.out.print("Address: ");
        String adr = read.nextLine();
        Address address = DataProcessing.addressProcessing(adr);
        //String[] buffer = adr.split(" ");
        //Address address = new Address(buffer[0],buffer[1],Integer.parseInt(buffer[2]));
        System.out.print("Date: ");
        String dat = read.nextLine();
        Date_alex date = DataProcessing.dateProcessing(dat);
        //String[] buffer2 = dat.split("\\.");
        //Date_alex date = new Date_alex(Integer.parseInt(buffer2[0]),Integer.parseInt(buffer2[1]),Integer.parseInt(buffer2[2]));
        System.out.print("CIF: ");
        int cif = read.nextInt();
        System.out.print("Invoice Total:");
        double invoiceTotal = read.nextDouble();

        return new Invoice(serialNumber,companyName,address,date,cif,invoiceTotal);
    }

    public static int readInt(){
        Scanner read = new Scanner(System.in);
        return read.nextInt();
    }

    public static double readDouble(){
        Scanner read = new Scanner(System.in);
        return read.nextDouble();
    }

    public static String readString() {
        Scanner read = new Scanner(System.in);
        return read.nextLine();
    }
}
