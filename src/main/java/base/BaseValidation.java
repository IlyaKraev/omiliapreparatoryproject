package base;

import menu.Util;

import java.util.Scanner;

public class BaseValidation {

    public BaseValidation(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Base part of the exercise.\nPlease input a phone number, in sequences of up to 3 numbers at a time, separated by space, then press enter.");
        initiateBaseDemonstration(sc.nextLine());
    }

    public void initiateBaseDemonstration(String number) {
        String trimmedNumber = number.replace(" ","");
        System.out.println(trimmedNumber);
        if(trimmedNumber.length()==10){
            if (trimmedNumber.startsWith("2")||trimmedNumber.startsWith("69")){
                System.out.println("The number "+trimmedNumber+" is VALID");

            } else {
                System.out.println("The number "+trimmedNumber+" is INVALID");
            }
        } else if (trimmedNumber.length()==14){
            if (trimmedNumber.startsWith("00302")||trimmedNumber.startsWith("003069")){
                System.out.println("The number "+trimmedNumber+" is VALID");

            } else {
                System.out.println("The number "+trimmedNumber+" is INVALID");

            }
        } else {
            System.out.println("The number "+trimmedNumber+" is INVALID");
        }
        Util util = new Util();
        util.pressAnyKeyToContinue();
    }
}
