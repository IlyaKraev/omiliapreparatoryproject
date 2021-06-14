package menu;

public class Util {
    public Util() {
    }

    public void pressAnyKeyToContinue() {
        System.out.println("Press the Enter key to continue.");
        try {
            System.in.read();
            Menu menu = new Menu();
            menu.initialize();
        } catch (Exception e) {
        }
    }

    public boolean containsNonNumericalChars(String number){
        if(number.matches("^ *[0-9][0-9 ]*$")){
            return false;
        } else return true;
    }
}
