package bjorn.adventofcode.day3;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Diagnostics {
    public int getGamma(Stream<String> readings) {
        List<String> readingsList = readings.toList();
        return Integer.parseInt(getAverageBits(readingsList), 2);
    }

    public int getEpsilon(Stream<String> readings) {
        List<String> readingsList = readings.toList();
        String averageBits = getAverageBits(readingsList);
        StringBuilder reversedBits = new StringBuilder();

        for (char bit : averageBits.toCharArray()) {
            if(bit == '1') {
                reversedBits.append("0");
            } else {
                reversedBits.append("1");
            }
        }
        return Integer.parseInt(reversedBits.toString(), 2);
    }

    private int[] getListAverages(List<String> readingsList) {
        int[] gammaResult = new int[readingsList.get(0).length()];
        for(String reading : readingsList) {
            for(int i = 0; i<reading.length(); i++) {
                if(reading.charAt(i) == '1') {
                    gammaResult[i] += 1;
                } else {
                    gammaResult[i] -= 1;
                }
            }
        }
        return gammaResult;
    }

    public String getAverageBits(List<String> readings) {
        // set to 0 by default
        int[] gammaResult = getListAverages(readings);

        StringBuilder result = new StringBuilder();
        for (int j : gammaResult) {
            if (j > 0) {
                result.append("1");
            } else {
                result.append("0");
            }
        }
        return result.toString();
    }

    public int getOxygenGenerator(Stream<String> readings) {
        List<String> matches = readings.toList();
        int position = 0;

        while (matches.size() > 1) {
            String mostSignificant = getMostSignificantBit(matches, position);
            if (mostSignificant.equals("")) {
                mostSignificant = "1";
            }
            ArrayList<String> newMatches = new ArrayList<>();
            for(String match : matches) {
                if(match.substring(position).startsWith(mostSignificant)) {
                    newMatches.add(match);
                }
            }
            matches = newMatches;
            position++;
        }

        return Integer.parseInt(matches.get(0),2);
    }

    public int getCO2Scrubber(Stream<String> readings) {
        List<String> matches = readings.toList();
        int position = 0;

        while (matches.size() > 1) {
            String mostSignificant = getLeastSignificantBit(matches, position);
            if (mostSignificant.equals("")) {
                mostSignificant = "0";
            }
            ArrayList<String> newMatches = new ArrayList<>();
            for(String match : matches) {
                if(match.substring(position).startsWith(mostSignificant)) {
                    newMatches.add(match);
                }
            }
            matches = newMatches;
            position++;
        }
        return Integer.parseInt(matches.get(0),2);
    }

    private String getLeastSignificantBit(List<String> matches, int position) {
        String bit = getMostSignificantBit(matches, position);
        if(bit.equals("0")) {
            return "1";
        } else if (bit.equals("1")){
            return "0";
        }
        return bit;
    }

    public String getMostSignificantBit(List<String> readings, int position) {
        int bitCount = 0;
        for(String reading : readings) {
            if(reading.charAt(position) == '1') {
                bitCount++;
            } else {
                bitCount--;
            }
        }
        if (bitCount < 0) {
            return "0";
        } else if (bitCount > 0){
            return "1";
        }
        // Draw
        return "";
    }
}
