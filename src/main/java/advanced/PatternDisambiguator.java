package advanced;

import java.util.ArrayList;

public class PatternDisambiguator {

    public PatternDisambiguator(){
    }


    public ArrayList<ArrayList> patternXX(String XX, ArrayList<String> prototype, int position){
        ArrayList<ArrayList> results = new ArrayList<>();

        ArrayList<String> branch1 = new ArrayList<>(prototype);
        ArrayList<String> branch2 = new ArrayList<>(prototype);

        String x0 = String.valueOf(XX.charAt(0)).concat("0");
        String x = String.valueOf(XX.charAt(0));

        // XX
        results.add(branch1);

        // In case the number doesn't start with 1-
        if(!String.valueOf(XX.charAt(0)).equals("1")){
            // XO X
            branch2.set(position, x0);
            branch2.add(position+1, x);
            results.add(branch2);
        }

        return results;
    }

    public ArrayList<ArrayList> patternX0X(String X0, String X, ArrayList<String> prototype, int position){
        ArrayList<ArrayList> results = new ArrayList<>();

        ArrayList<String> branch1 = new ArrayList<>(prototype);
        ArrayList<String> branch2 = new ArrayList<>(prototype);

        String xx = String.valueOf(X0.charAt(0)).concat(X);


        // XOX
        results.add(branch1);

        // In case the first number doesn't start with 1-
        if(!String.valueOf(X0.charAt(0)).equals("1")) {
            // XX
            branch2.set(position, xx);
            branch2.remove(position+1);
            results.add(branch2);
        }

        return results;
    }

    public ArrayList<ArrayList> patternXXX(String XXX, ArrayList<String> prototype, int position){
        ArrayList<ArrayList> results = new ArrayList<>();

        ArrayList<String> branch1 = new ArrayList<>(prototype);
        ArrayList<String> branch2 = new ArrayList<>(prototype);
        ArrayList<String> branch3 = new ArrayList<>(prototype);
        ArrayList<String> branch4 = new ArrayList<>(prototype);

        String x00 = String.valueOf(XXX.charAt(0)).concat("00");
        String xx0 = String.valueOf(XXX.charAt(0)).concat(String.valueOf(XXX.charAt(1))).concat("0");
        String x0 = String.valueOf(XXX.charAt(1)).concat("0");
        String xx = String.valueOf(XXX.charAt(1)).concat(String.valueOf(XXX.charAt(2)));
        String x = String.valueOf(XXX.charAt(2));

        // XXX
        results.add(branch1);

        // XXO X
        branch2.set(position, xx0);
        branch2.add(position+1, x);
        results.add(branch2);

        // XOO XX
        branch3.set(position, x00);
        branch3.add(position+1, xx);
        results.add(branch3);

        // XOO XO X
        branch4.set(position, x00);
        branch4.add(position+1, x);
        branch4.add(position+1, x0);
        results.add(branch4);

        return results;

    }
    public ArrayList<ArrayList> patternX00X0X(String X00, String X0, String X, ArrayList<String> prototype, int position){
        ArrayList<ArrayList> results = new ArrayList<>();

        ArrayList<String> branch1 = new ArrayList<>(prototype);
        ArrayList<String> branch2 = new ArrayList<>(prototype);
        ArrayList<String> branch3 = new ArrayList<>(prototype);
        ArrayList<String> branch4 = new ArrayList<>(prototype);

        String xxx = String.valueOf(X00.charAt(0)).concat(String.valueOf(X0.charAt(1))).concat(String.valueOf(X));
        String xx0 = String.valueOf(X00.charAt(0)).concat(X0);
        String xx = X0.concat(X);

        // XOO XO X
        results.add(branch1);

        // XOO XX
        branch2.set(position+1, xx);
        branch2.remove(position+2);
        results.add(branch2);

        // XXO X
        branch3.set(position, xx0);
        branch3.remove(position+1);
        results.add(branch3);

        // XXX
        branch4.set(position, xxx);
        branch4.remove(position+1);
        branch4.remove(position+1);
        results.add(branch4);

        return results;

    }

    public ArrayList<ArrayList> patternXX0(String XX0, ArrayList<String> prototype, int position){
        ArrayList<ArrayList> results = new ArrayList<>();

        ArrayList<String> branch1 = new ArrayList<>(prototype);
        ArrayList<String> branch2 = new ArrayList<>(prototype);

        String x00 = String.valueOf(XX0.charAt(0)).concat("00");
        String x0 = String.valueOf(XX0.charAt(1)).concat("0");

        // XX0
        results.add(branch1);

        // XOO XO
        branch2.set(position, x00);
        branch2.add(position+1, x0);
        results.add(branch2);

        return results;

    }

    public ArrayList<ArrayList> patternXOOXO(String X00, String X0, ArrayList<String> prototype, int position){
        ArrayList<ArrayList> results = new ArrayList<>();

        ArrayList<String> branch1 = new ArrayList<>(prototype);
        ArrayList<String> branch2 = new ArrayList<>(prototype);

        String xx0 = String.valueOf(X00.charAt(0)).concat(X0);

        // XOO XO
        results.add(branch1);

        // XXO
        branch2.set(position, xx0);
        branch2.remove(position+1);
        results.add(branch2);

        return results;

    }

    public ArrayList<ArrayList> patternX00XX(String X00, String XX, ArrayList<String> prototype, int position){
        ArrayList<ArrayList> results = new ArrayList<>();

        ArrayList<String> branch1 = new ArrayList<>(prototype);
        ArrayList<String> branch2 = new ArrayList<>(prototype);
        ArrayList<String> branch3 = new ArrayList<>(prototype);

        String xxx = String.valueOf(X00.charAt(0)).concat(XX);
        String x0 = String.valueOf(XX.charAt(0)).concat("0");
        String x = String.valueOf(XX.charAt(1));

        // XOO XX
        results.add(branch1);

        // XOO XO X
        branch2.set(position, X00);
        branch2.add(position+1, x);
        branch2.add(position+1, x0);
        results.add(branch2);

        // XXX
        branch3.set(position, xxx);
        branch3.remove(position+1);
        results.add(branch3);

        return results;

    }



}
