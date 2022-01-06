package bjorn.adventofcode.day8;

import java.util.stream.Stream;

public class Display {

    private String[] numberOne;
    private String[] numberFour;
    private String[] numberSeven;
    private String[] numberEight;

    public Display() {
        numberOne = new String[2];
        numberFour = new String[4];
        numberSeven = new String[3];
        numberEight = new String[7];
    }

    public void setPattern(Stream<String> pattern) {
        pattern.forEach(this::findSimpelNumber);
    }

    private void findSimpelNumber(String signal) {
        if(signal.length() == 2) {
            numberOne = signal.split("");
        } else if(signal.length() == 4) {
            numberFour = signal.split("");
        } else if(signal.length() == 3) {
            numberSeven = signal.split("");
        } else if(signal.length() == 7) {
            numberEight = signal.split("");
        }
    }

    public String translateOutput(Stream<String> output) {
        StringBuilder translated = new StringBuilder();
        for(String signal : output.toList()) {
            if(isNumber(signal, numberOne)) {
                translated.append("1");
            } else if (isNumber(signal, numberFour)) {
                translated.append("4");
            } else if (isNumber(signal, numberSeven)) {
                translated.append("7");
            } else if (isNumber(signal, numberEight)) {
                translated.append("8");
            }
        }
        return translated.toString();
    }

    private boolean isNumber(String signal, String[] number) {
        for(String n : number) {
            if(n == null || !signal.contains(n)) {
                return false;
            }
        }
        return signal.length() == number.length;
    }

    public int countNumbers(Stream<String> stream) {
        String translated = translateOutput(stream);
        return translated.length();
    }
}
