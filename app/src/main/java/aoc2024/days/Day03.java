package aoc2024.days;

import aoc2024.utils.InputReader;


public class Day03 {
        public static int solvePart1() {
            String input = InputReader.readFile("day03/input.txt");


            // regex pattern match to - mul(X, Y) where X and Y are 1-3 digit numbers
            String pattern = "mul\\((\\d{1,3}),\\s*(\\d{1,3})\\)";
            java.util.regex.Pattern r = java.util.regex.Pattern.compile(pattern);
            java.util.regex.Matcher m = r.matcher(input);

            int count = 0; // Initialize count to 0

            while (m.find()) {
                int x = Integer.parseInt(m.group(1));
                int y = Integer.parseInt(m.group(2));
                count += (x * y);
            }

        return count;
    }

    public static int solvePart2() {
        return 0;
    }
}
