package ro.alex;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner read = new Scanner(System.in);
        OptionSwitcher optionSwitcher = new OptionSwitcher();
        int option;
        do{
            System.out.println();
            PrintOptions.printOption();
            System.out.println();
            System.out.print(":-:  ");
            option = read.nextInt();
            optionSwitcher.choseOption(option);
            System.out.println();
        }while(option != 0);

    }
}