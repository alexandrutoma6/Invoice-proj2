package ro.alex;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);
        OptionSwitcher optionSwitcher = new OptionSwitcher();
        PrintClass print = new PrintClass();
        int option = 0;
        do{
            try {
                System.out.println();
                print.printOption();
                System.out.println();
                System.out.print(":-:  ");
                option = read.nextInt();
                optionSwitcher.choseOption(option);
                System.out.println();
            }
            catch(Exception e){
                System.out.println("VALOARE GRESITA! REINCERCATI!");
                read.nextLine();
            }
        }while(option != 0);

    }
}