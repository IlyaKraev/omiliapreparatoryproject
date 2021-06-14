package base;

import interfaces.IValidate;
import menu.Util;
import models.PhoneNumber;

public class BaseValidation implements IValidate {

    public BaseValidation(){

    }

    public void process(String number){
        Util util = new Util();
        checkValidityOfUtteranceNodes(number, util);

        String trimmedNumber = number.replace(" ","");
        objectifyNumber(trimmedNumber);
        util.pressAnyKeyToContinue();
    }

    public PhoneNumber objectifyNumber(String number){
        PhoneNumber phoneNumber = new PhoneNumber();

        phoneNumber.setDigits(number);

        phoneNumber.setType(checkType(phoneNumber));
        phoneNumber.setLength(checkLength(phoneNumber));
        phoneNumber.setInternational(checkIfInternational(phoneNumber));
        phoneNumber.setValid(checkPhoneNumberValidity(phoneNumber));

        return phoneNumber;
    }

    public void checkValidityOfUtteranceNodes(String number, Util util){
        String[] arrayOfDigits = number.split(" ");
        for (String cell: arrayOfDigits) {
            if(cell.length()>3){
                System.out.println("Please make sure to enter a number in a format that mimics voice-to-text; in sequences of up to 3 digits at a time, separated by space. ");
                util.pressAnyKeyToContinue();
            }
        }
    }

    public boolean checkIfInternational(PhoneNumber number){
        if(number.getDigits().startsWith("0030")){
            return true;
        } else return false;
    }

    public String checkType(PhoneNumber number){
        if(number.getDigits().startsWith("69")||number.getDigits().startsWith("003069")){
            return "Mobile";
        } else if (number.getDigits().startsWith("2")||number.getDigits().startsWith("00302")){
            return "Landline";
        } else return "Undefined";
    }

    public int checkLength(PhoneNumber number){
         return number.getDigits().length();
    }

    public boolean checkPhoneNumberValidity(PhoneNumber number) {
    if (!number.isInternational()&&number.getLength()==10&&(number.getType().equals("Landline")||number.getType().equals("Mobile"))){
        return true;
    } else if (number.isInternational()&&number.getLength()==14&&(number.getType().equals("Landline")||number.getType().equals("Mobile"))){
        return true;
    } else return false;
    }

}
