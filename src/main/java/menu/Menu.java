package menu;

import advanced.AdvancedValidation;
import base.BaseValidation;

import java.util.Scanner;

public class Menu {

    public Menu() {
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
        String selection = sc.nextLine();

        while (!selection.equals("1") || !selection.equals("2") || !selection.equals("3")) {
            if (selection.equals("1")) {
                BaseValidation baseValidation = new BaseValidation();

            } else if (selection.equals("2")) {
                AdvancedValidation advancedValidation = new AdvancedValidation();

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
