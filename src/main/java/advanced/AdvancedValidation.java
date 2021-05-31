package advanced;

import menu.Menu;
import menu.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AdvancedValidation {

    public AdvancedValidation() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the advanced part of the exercise.\nPlease input a phone number, in sequences of up to 3 numbers at a time, separated by space, then press enter.");
        initiateAdvancedDemonstration(sc.nextLine());
    }

    public void initiateAdvancedDemonstration(String number) {
        List<ArrayList> results = new ArrayList<>();

        List<ArrayList> interpretations = ambiguityInterpretation(number);

        results.addAll(interpretations);
        for (int i = 0; i < number.split(" ").length; i++) {
            for (int j = 0; j < number.split(" ").length - i; j++) {
                try {
                    interpretations = ambiguityInterpretation(interpretations.get(j - i).toString().replace(",", "").replace("[", "").replace("]", ""));
                } catch (Exception e) {
                    System.out.println(e);
                    continue;
                }
                results.addAll(interpretations);
            }
        }

        ArrayList<ArrayList> uniqueResults = removeDuplicates(results);

        ArrayList<String> stringifiedNumbers = new ArrayList<>();

        for (ArrayList result : uniqueResults) {
            String stringifiedNumber = "";
            for (int i = 0; i < result.size(); i++) {
                stringifiedNumber += result.get(i);
            }
            stringifiedNumbers.add(stringifiedNumber);
        }

        ArrayList<String> validatedNumbers = validateNumbers(stringifiedNumbers);

        System.out.println("You have input: " + number + "\n");
        System.out.println("------------Possible Interpretations:------------\n");
        for (String finalVerdict : validatedNumbers) {
            System.out.println(finalVerdict + "\n");
        }
        Util util = new Util();
        util.pressAnyKeyToContinue();
        Menu menu = new Menu();
    }

    public List<ArrayList> ambiguityInterpretation(String number) {
        List<ArrayList> results = new ArrayList<>();

        String[] arrayOfDigits = number.split(" ");
        ArrayList<String> arrayListOfDigits = new ArrayList<>(Arrays.asList(arrayOfDigits));


        System.out.println("You have input: " + arrayListOfDigits.toString());
        //check number of digits

        results.add(arrayListOfDigits);
        for (int i = 0; i < arrayListOfDigits.size(); i++) {

            String following;
            String current;

            System.out.println("THE NUMBER EXAMINED IS " + arrayListOfDigits.get(i));

            // Join X0-X -> XX  else  Split XX -> X0-X
            if (arrayListOfDigits.get(i).length() == 2) {
                if (arrayListOfDigits.get(i).endsWith("0") && i != arrayListOfDigits.size() - 1 && arrayListOfDigits.get(i + 1).length() == 1) {
                    // Important to check that the algorithm doesn't interpret 11 as 10-1 or 12 as 10-2 and vice versa, since there's no ambiguity for this case in Greek
                    if (!arrayListOfDigits.get(i).startsWith("1") && !arrayListOfDigits.get(i + 1).startsWith("1") && !arrayListOfDigits.get(i + 1).startsWith("2")) {
                        following = arrayListOfDigits.get(i + 1);

                        ArrayList<String> newCombinationInstance = new ArrayList<>(arrayListOfDigits);
                        current = newCombinationInstance.get(i).replace("0", following);

                        newCombinationInstance.set(i, current);
                        newCombinationInstance.remove(i + 1);

                        results.add(newCombinationInstance);

                    }

                } else if (!arrayListOfDigits.get(i).endsWith("0") && (!arrayListOfDigits.get(i).equals("11") && !arrayListOfDigits.get(i).equals("12")) &&
                        !(arrayListOfDigits.get(i).equals("69") && (i == 0 || i == 3))) {
                    current = arrayListOfDigits.get(i);

                    ArrayList<String> newCombinationInstance = new ArrayList<>(arrayListOfDigits);
                    newCombinationInstance.add(i, String.valueOf(current.charAt(0)).concat("0"));
                    newCombinationInstance.add(i + 1, String.valueOf(current.charAt(1)));
                    newCombinationInstance.remove(i + 2);

                    results.add(newCombinationInstance);
                }

            } else if (arrayListOfDigits.get(i).length() == 3) {
                // Join X00 + followingNumbers else Split XXX -> X00 + xx
                if (arrayListOfDigits.get(i).endsWith("00")) {
                    if (arrayListOfDigits.get(i + 1).length() == 2) {
                        if (arrayListOfDigits.get(i + 1).endsWith("0")) {
                            // Join X00 + X0 + X
                            // Also check that it doesn't turn 10-1 into 11 and 10-2 into 12
                            if (arrayListOfDigits.get(i + 2).length() == 1 && !arrayListOfDigits.get(i + 1).equals("10") && (!arrayListOfDigits.get(i + 2).equals("1") && !arrayListOfDigits.get(i + 2).equals("2"))) {

                                String secondFollowing = arrayListOfDigits.get(i + 2);

                                ArrayList<String> newCombinationInstance = new ArrayList<>(arrayListOfDigits);

                                following = newCombinationInstance.get(i + 1).replace("0", secondFollowing);
                                current = newCombinationInstance.get(i).replace("00", following);

                                newCombinationInstance.set(i, current);
                                newCombinationInstance.remove(i + 2);
                                newCombinationInstance.remove(i + 1);

                                results.add(newCombinationInstance);
                            } else { //Join X00 + X0
                                following = arrayListOfDigits.get(i + 1);

                                ArrayList<String> newCombinationInstance = new ArrayList<>(arrayListOfDigits);

                                current = newCombinationInstance.get(i).replace("00", following);

                                newCombinationInstance.set(i, current);
                                newCombinationInstance.remove(i + 1);

                                results.add(newCombinationInstance);
                            }

                        } else { // Join X00 + XX

                            following = arrayListOfDigits.get(i + 1);

                            ArrayList<String> newCombinationInstance = new ArrayList<>(arrayListOfDigits);

                            current = newCombinationInstance.get(i).replace("00", following);

                            newCombinationInstance.set(i, current);
                            newCombinationInstance.remove(i + 1);

                            results.add(newCombinationInstance);

                        }
                    } else if (arrayListOfDigits.get(i + 1).length() == 1) {
                        following = arrayListOfDigits.get(i + 1);
                        current = arrayListOfDigits.get(i);

                        ArrayList<String> newCombinationInstance = new ArrayList<>(arrayListOfDigits);
                        current = current.valueOf(current.charAt(0)).concat("0").concat(following);

                        newCombinationInstance.set(i, current);
                        newCombinationInstance.remove(i + 1);
                        results.add(newCombinationInstance);
                    }
                } else if (arrayListOfDigits.get(i).charAt(1) == '0') {
                    current = arrayListOfDigits.get(i);
                    String hundred = String.valueOf(current.charAt(0)).concat("00");
                    String singular = String.valueOf(current.charAt(2));

                    ArrayList<String> newCombinationInstance = new ArrayList<>(arrayListOfDigits);

                    newCombinationInstance.set(i, hundred);
                    newCombinationInstance.add(i + 1, singular);

                    results.add(newCombinationInstance);

                } else {
                    //Split XXX into X00 + XX
                    current = arrayListOfDigits.get(i);
                    String hundred = String.valueOf(current.charAt(0)).concat("00");
                    String decimal = String.valueOf(current.charAt(1)).concat(String.valueOf(current.charAt(2)));

                    ArrayList<String> newCombinationInstance = new ArrayList<>(arrayListOfDigits);

                    newCombinationInstance.set(i, hundred);
                    newCombinationInstance.add(i + 1, decimal);

                    results.add(newCombinationInstance);

                }
            }
        }
        return results;
    }

    public static ArrayList<ArrayList> removeDuplicates(List<ArrayList> list) {

        ArrayList<ArrayList> listOfUniques = new ArrayList<>();

        for (ArrayList element : list) {

            if (!listOfUniques.contains(element)) {
                listOfUniques.add(element);
            }
        }
        return listOfUniques;
    }

    public static ArrayList<String> validateNumbers(ArrayList<String> numbers) {
        ArrayList<String> validatedList = new ArrayList<>();
        for (String number : numbers) {
            if (number.length() == 14 && ((number.startsWith("00302") || number.startsWith("003069")))) {
                String validated = number.concat(" - [VALID]");
                validatedList.add(validated);
            } else if (number.length() == 10 && ((number.startsWith("2") || number.startsWith("69")))) {
                String validated = number.concat(" - [VALID]");
                validatedList.add(validated);
            } else {
                String validated = number.concat(" - [INVALID]");
                validatedList.add(validated);
            }
        }
        return validatedList;
    }

}