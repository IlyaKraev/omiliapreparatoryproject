package menu;

import advanced.AdvancedValidation;
import base.BaseValidation;
import interfaces.IValidate;

import java.util.Scanner;

public class Menu {

    public Menu() {

    }

    public void initialize(){
        System.out.println("This application simulates a voice-to-text recognition scenario.\n" +
                "It checks for number validity at the base level and at the advanced\n" +
                "it deals with potential speech ambiguities, such as TWENTY FIVE,\n" +
                "which could be interpreted as 25 or as 20 - 5.\n" +
                "--------------------------------------------------------------------\n" +
                "Please select function to perform:\n" +
                "\n" +
                "1) Base validation\n" +
                "2) Advanced validation\n" +
                "3) Exit");

        Scanner sc = new Scanner(System.in);
        Util util = new Util();
        String selection = sc.nextLine();

        while (!selection.equals("1") || !selection.equals("2") || !selection.equals("3")) {
            if (selection.equals("1")) {
                IValidate validator = new BaseValidation();
                System.out.println("Welcome to the base validation module. To proceed type a phone number, in seqeunces" +
                        " of up to 3 digits, separated by space.");
                String number = sc.nextLine();

                while(util.containsNonNumericalChars(number)){
                    System.out.println("Please make sure to only use numbers or space.");
                    number = sc.nextLine();
                }

                validator.process(number);

            } else if (selection.equals("2")) {
                IValidate validator = new AdvancedValidation();

                System.out.println("Welcome to the advanced part of the exercise.\nPlease input a phone number, " +
                        "in sequences of up to 3 numbers at a time, separated by space, then press enter.");
                String number = sc.nextLine();

                while(util.containsNonNumericalChars(number)){
                    System.out.println("Please make sure to only use numbers or space.");
                    number = sc.nextLine();
                }
                validator.process(number);

            } else if (selection.equals("3")) {
                System.out.println("Goodbye!");
                System.exit(0);
            } else {
                System.out.println("Please type 1-3 and press enter.");
                selection = sc.nextLine();
            }
        }
    }

}
