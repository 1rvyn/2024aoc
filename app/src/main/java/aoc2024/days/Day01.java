package aoc2024.days;

import aoc2024.utils.InputReader;
import java.util.List;

public class Day01 {
    public static int solvePart1() {
        List<String> input = InputReader.readLines("day01/input.txt");
        for (String line: input) {
            System.out.println(line);

            if (line.length() > 10) {
                System.out.println("10");
            }
        }
        return 0;
    }

    public static int solvePart2() {
        List<String> input = InputReader.readLines("day01/input.txt");
        
        return 0;
    }
} 