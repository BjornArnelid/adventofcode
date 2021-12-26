import bjorn.adventofcode.day18.SnailFishCalculator;
import bjorn.adventofcode.day18.SnailNumber;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Day18Test {
    @Test
    public void testCreateNumber() {
        SnailNumber number = new SnailNumber(null, "[1,2]");
        assertEquals("[1,2]", number.toString());
    }

    @Test
    public void testLevelNumber() {
        SnailNumber number = new SnailNumber(null, "[[1,2],3]");
        assertEquals("[[1,2],3]", number.toString());
    }

    @Test
    public void testLevelNumber2() {
        SnailNumber number = new SnailNumber(null, "[9,[8,7]]");
        assertEquals("[9,[8,7]]", number.toString());
    }

    @Test
    public void testDeepNumber() {
        SnailNumber number = new SnailNumber(null, "[[[[1,3],[5,3]],[[1,3],[8,7]]],[[[4,9],[6,9]],[[8,2],[7,3]]]]");
        assertEquals("[[[[1,3],[5,3]],[[1,3],[8,7]]],[[[4,9],[6,9]],[[8,2],[7,3]]]]", number.toString());
    }
    @Test
    public void testAddNumbers() {
        SnailNumber result = SnailFishCalculator.add(new SnailNumber(null, "[1,2]"), new SnailNumber(null, "[[3,4],5]"));
        assertEquals("[[1,2],[[3,4],5]]", result.toString());
    }

    @Test
    public void testExplodeNumberLeft() {
        SnailNumber input = new SnailNumber(null, "[[[[[9,8],1],2],3],4]");
        input.explode();
        assertEquals("[[[[0,9],2],3],4]", input.toString());
    }

    @Test
    public void testExplodeNumberRight() {
        SnailNumber input = new SnailNumber(null, "[7,[6,[5,[4,[3,2]]]]]");
        input.explode();
        assertEquals("[7,[6,[5,[7,0]]]]", input.toString());
    }

    @Test
    public void testExplodeInnerRight() {
        SnailNumber input = new SnailNumber(null, "[[6,[5,[4,[3,2]]]],1]");
        input.explode();
        assertEquals("[[6,[5,[7,0]]],3]", input.toString());
    }

    @Test
    public void testExplodeReturnsTrue() {
        SnailNumber input = new SnailNumber(null, "[[3,[2,[8,0]]],[9,[5,[4,[3,2]]]]]");
        assertTrue(input.explode());
        assertEquals("[[3,[2,[8,0]]],[9,[5,[7,0]]]]", input.toString());
    }

    @Test
    public void testSplit() {
        SnailNumber number = new SnailNumber(null, "[0,10]");
        assertTrue(number.split());
        assertEquals("[0,[5,5]]", number.toString());
    }

    @Test
    public void testFailingExplode() {
        SnailNumber number = new SnailNumber(null, "[[[[0,7],4],[[7,8],[0,[6,7]]]],[1,1]]");
        number.explode();
        assertEquals("[[[[0,7],4],[[7,8],[6,0]]],[8,1]]", number.toString());
    }

    @Test
    public void testAdvancedAdd() {
        SnailNumber result = SnailFishCalculator.add(new SnailNumber(null, "[[[[4,3],4],4],[7,[[8,4],9]]]"), new SnailNumber(null, "[1,1]"));
        assertEquals("[[[[0,7],4],[[7,8],[6,0]]],[8,1]]", result.toString());
    }

    @Test
    public void testAddList1() {
        String testData = """
                [1,1]
                [2,2]
                [3,3]
                [4,4]""";
        SnailFishCalculator calculator = new SnailFishCalculator();
        for(String number : testData.split("\n")) {
            calculator.add(number);
        }
        assertEquals("[[[[1,1],[2,2]],[3,3]],[4,4]]", calculator.getResult().toString());
    }

    @Test
    public void testExplodeLeftMost() {
        SnailNumber input = new SnailNumber(null, "[[3,[2,[1,[7,3]]]],[6,[5,[4,[3,2]]]]]");
        input.explode();
        assertEquals("[[3,[2,[8,0]]],[9,[5,[4,[3,2]]]]]", input.toString());
    }

    @Test
    public void testAddList2() {
        String testData = """
                [1,1]
                [2,2]
                [3,3]
                [4,4]
                [5,5]""";
        SnailFishCalculator calculator = new SnailFishCalculator();
        for(String number : testData.split("\n")) {
            calculator.add(number);
        }
        assertEquals("[[[[3,0],[5,3]],[4,4]],[5,5]]", calculator.getResult().toString());
    }

    @Test
    public void testAddList3() {
        String testData = """
                [1,1]
                [2,2]
                [3,3]
                [4,4]
                [5,5]
                [6,6]""";
        SnailFishCalculator calculator = new SnailFishCalculator();
        for(String number : testData.split("\n")) {
            calculator.add(number);
        }
        assertEquals("[[[[5,0],[7,4]],[5,5]],[6,6]]", calculator.getResult().toString());
    }

    @Test
    public void testFailedAdd() {
        SnailNumber result = SnailFishCalculator.add(
                new SnailNumber(null, "[[[[7,0],[7,7]],[[7,7],[7,8]]],[[[7,7],[8,8]],[[7,7],[8,7]]]]"),
                new SnailNumber(null, "[7,[5,[[3,8],[1,4]]]]"));
        assertEquals("[[[[7,7],[7,8]],[[9,5],[8,7]]],[[[6,8],[0,8]],[[9,9],[9,0]]]]", result.toString());
    }

    @Test
    public void testFailedStep() {
        SnailNumber step = new SnailNumber(null, "[[[[7,7],[7,8]],[[9,5],[8,0]]],[[[9,10],20],[8,[9,0]]]]");
        step.split();
        assertEquals("[[[[7,7],[7,8]],[[9,5],[8,0]]],[[[9,[5,5]],20],[8,[9,0]]]]", step.toString());
    }

    @Test
    public void testAddListFinal() {
        String testData = """
                [[[0,[4,5]],[0,0]],[[[4,5],[2,6]],[9,5]]]
                [7,[[[3,7],[4,3]],[[6,3],[8,8]]]]
                [[2,[[0,8],[3,4]]],[[[6,7],1],[7,[1,6]]]]
                [[[[2,4],7],[6,[0,5]]],[[[6,8],[2,8]],[[2,1],[4,5]]]]
                [7,[5,[[3,8],[1,4]]]]""";
        SnailFishCalculator calculator = new SnailFishCalculator();
        for(String number : testData.split("\n")) {
            calculator.add(number);
        }
        assertEquals("[[[[7,7],[7,8]],[[9,5],[8,7]]],[[[6,8],[0,8]],[[9,9],[9,0]]]]", calculator.getResult().toString());
    }

    @Test
    public void testCountMagnitude1() {
        SnailNumber number = new SnailNumber(null, "[9,1]");
        assertEquals(29, number.getMagnitude());
    }

    @Test
    public void testCountMagnitude2() {
        SnailNumber number = new SnailNumber(null, "[[9,1],[1,9]]");
        assertEquals(129, number.getMagnitude());
    }

    @Test
    public void testHomework() {
        String testHomework = """
                [[[0,[5,8]],[[1,7],[9,6]]],[[4,[1,2]],[[1,4],2]]]
                [[[5,[2,8]],4],[5,[[9,9],0]]]
                [6,[[[6,2],[5,6]],[[7,6],[4,7]]]]
                [[[6,[0,7]],[0,9]],[4,[9,[9,0]]]]
                [[[7,[6,4]],[3,[1,3]]],[[[5,5],1],9]]
                [[6,[[7,3],[3,2]]],[[[3,8],[5,7]],4]]
                [[[[5,4],[7,7]],8],[[8,3],8]]
                [[9,3],[[9,9],[6,[4,9]]]]
                [[2,[[7,7],7]],[[5,8],[[9,3],[0,2]]]]
                [[[[5,2],5],[8,[3,7]]],[[5,[7,5]],[4,4]]]""";
        SnailFishCalculator calculator = new SnailFishCalculator();
        for(String number : testHomework.split("\n")) {
            calculator.add(number);
        }
        assertEquals(4140, calculator.getResult().getMagnitude());
    }
}
