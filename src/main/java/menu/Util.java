package menu;

public class Util {
    public Util() {
    }

    public void pressAnyKeyToContinue() {
        System.out.println("Press the Enter key to continue.");
        try {
            System.in.read();
            Menu menu = new Menu();
        } catch (Exception e) {
        }
    }
}
