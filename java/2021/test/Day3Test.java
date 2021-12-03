import bjorn.adventofcode.Diagnostics;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

public class Day3Test {
    @Test
    public void testGammaRateOf1() {
        Diagnostics diagnostics = new Diagnostics();
        Stream<String> readings = Stream.of("00100");
        int gamma = diagnostics.getGamma(readings);
        Assertions.assertEquals(0B00100, gamma);
    }

    @Test
    public void testGetGammaRate() {
        Diagnostics diagnostics = new Diagnostics();
        Stream<String> readings = Stream.of(
                "00100,11110,10110,10111,10101,01111,00111,11100,10000,11001,00010,01010".split(","));
        int gamma = diagnostics.getGamma(readings);
        Assertions.assertEquals(0B10110, gamma);
    }

    @Test
    public void testGetAverageBitMask() {
        Diagnostics diagnostics = new Diagnostics();
        Stream<String> readings = Stream.of(
                "00100,11110,10110,10111,10101,01111,00111,11100,10000,11001,00010,01010".split(","));
        String bits = diagnostics.getAverageBits(readings.toList());
        Assertions.assertEquals("10110", bits);
    }

    @Test
    public void testFindMostSignificantBit() {
        Diagnostics diagnostics = new Diagnostics();
        Stream<String> readings = Stream.of(
                "00100,11110,10110,10111,10101,01111,00111,11100,10000,11001,00010,01010".split(","));
        String bit = diagnostics.getMostSignificantBit(readings.toList(), 0);
        Assertions.assertEquals("1", bit);
    }

    @Test
    public void testFindOxygenGenerator() {
        Diagnostics diagnostics = new Diagnostics();
        Stream<String> readings = Stream.of(
                "00100,11110,10110,10111,10101,01111,00111,11100,10000,11001,00010,01010".split(","));
        int result = diagnostics.getOxygenGenerator(readings);
        Assertions.assertEquals(0B10111, result);
    }

    @Test
    public void testFindCO2Scrubber() {
        Diagnostics diagnostics = new Diagnostics();
        Stream<String> readings = Stream.of(
                "00100,11110,10110,10111,10101,01111,00111,11100,10000,11001,00010,01010".split(","));
        int result = diagnostics.getCO2Scrubber(readings);
        Assertions.assertEquals(0B01010, result);
    }
}
