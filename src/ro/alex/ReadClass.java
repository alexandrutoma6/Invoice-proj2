package ro.alex;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ReadClass {

    public Invoice readInvoiceValidate(){
        Scanner read = new Scanner(System.in);
        boolean noError;

        int serialNumber = 0;
        //validate SerialNumber
        do {
            System.out.print("Serial Number: ");
            noError = true;
            try {
                serialNumber = read.nextInt();
            }
            catch (InputMismatchException e) {
                noError = false;
                System.out.println("Introduceti un numar!");
                read.nextLine();
            }
        }while(!noError);

        System.out.print("Company Name: ");
        String companyName = read.nextLine();
        System.out.print("Address: ");
        Address address = readAddressValidate();
        System.out.print("Date: ");
        LocalDate date = readDateValidate();
        int cif = 0;

        //validateCif
        do {
            System.out.print("CIF: ");
            noError = true;
            try {
                cif = read.nextInt();
            }
            catch (InputMismatchException e) {
                noError = false;
                System.out.println("Introduceti un numar!");
                read.nextLine();
            }
        }while(!noError);
        double invoiceTotal = 0;

        //validateInvoiceTotal
        do {
            System.out.print("InvoiceTotal: ");
            noError = true;
            try {
                invoiceTotal = read.nextInt();
            }
            catch (InputMismatchException e) {
                noError = false;
                System.out.println("Introduceti un numar!");
                read.nextLine();
            }
        }while(!noError);

        return new Invoice(serialNumber,companyName,address,date,cif,invoiceTotal);
    }
    public Address readAddressValidate(){
        System.out.println();
        Scanner read = new Scanner(System.in);
        boolean noError;
        System.out.print("TARA: ");
        String country = read.nextLine();
        System.out.print("ORAS: ");
        String city = read.nextLine();
        int number = 0;
        do {
            System.out.print("NR: ");
            noError = true;
            try {
                number = read.nextInt();
            }
            catch (InputMismatchException e) {
                noError = false;
                System.out.println("Introduceti un numar!");
                read.nextLine();
            }
        }while(!noError);
        return new Address(country,city,number);

    }
    public LocalDate readDateValidate(){
        int day =0 ,month = 0,year = 0;
        System.out.println();
        Scanner read = new Scanner(System.in);
        boolean noError;
        //validate Year
        do {
            System.out.print("AN: ");
            noError = true;
            try {
                year = read.nextInt();
                if(year < 1800 || year > LocalDate.now().getYear()){
                    System.out.println("Introduceti un numar intre 1800-"+LocalDate.now().getYear());
                    noError = false;
                }
            } catch (InputMismatchException e) {
                noError = false;
                System.out.println("Introduceti un numar intre 1800-"+LocalDate.now().getYear());
                read.nextLine();
            }
        }while(!noError);

        //validate Month
        do {
            System.out.print("LUNA: ");
            noError = true;
            try {
                month = read.nextInt();
                if(month < 1 || month > 12){
                    System.out.println("Introduceti un numar intre 1-12");
                    noError = false;
                }
            } catch (InputMismatchException e) {
                noError = false;
                System.out.println("Introduceti un numar intre 1-12");
                read.nextLine();
            }
        }while(!noError);

        //validate Day
        do {
            System.out.print("ZI: ");
            noError = true;
            try {
                day = read.nextInt();

                if(day > 28){
                    if(month == 2 && isLeap(year) && day > 29){
                        System.out.println("Introduceti un numar intre 1-29");
                        noError = false;
                    }
                    if(month == 2 && !isLeap(year)){
                        System.out.println("Introduceti un numar intre 1-28");
                        noError = false;
                    }
                    if((month == 4 || month == 6 || month == 9 || month == 11) && day > 30){
                        System.out.println("Introduceti un numar intre 1-30");
                        noError = false;
                    }
                    else if((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && day > 31){
                        System.out.println("Introduceti un numar intre 1-31");
                        noError = false;
                    }
                }
            } catch (InputMismatchException e) {
                noError = false;
                System.out.println("Introduceti un numar intre 1-30/31");
                read.nextLine();
            }
        }while(!noError);

        return LocalDate.of(year,month,day);
    }
    private boolean isLeap(int year) {
        return (((year % 4 == 0) && (year % 100 != 0)) ||
                (year % 400 == 0));
    }
}
