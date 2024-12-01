package aoc2024.days;

import aoc2024.utils.InputReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day01 {
    public static int solvePart1() {
        List<String> input = InputReader.readLines("day01/input.txt");

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (String line : input) {
            // get first 5
            Integer num1 = Integer.parseInt(line.substring(0, 5));
            Integer num2 = Integer.parseInt(line.substring(8, line.length()));

            // Insert num1 into left in ascending order
            int leftIndex = 0;
            while (leftIndex < left.size() && left.get(leftIndex) < num1) {
                leftIndex++;
            }
            left.add(leftIndex, num1);

            // Insert num2 into right in ascending order
            int rightIndex = 0;
            while (rightIndex < right.size() && right.get(rightIndex) < num2) {
                rightIndex++;
            }
            right.add(rightIndex, num2);
        }

        Integer total = 0;
        for (int i = 0; i < left.size(); i++) {
            total += Math.abs(left.get(i) - right.get(i));
        }

        return total;

    }

    public static int solvePart2() {
        List<String> input = InputReader.readLines("day01/input.txt");

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (String line : input) {
            Integer num1 = Integer.parseInt(line.substring(0, 5));
            Integer num2 = Integer.parseInt(line.substring(8, line.length()));

            // Insert num1 into left
            left.add(num1);
            // Insert num2 into right 
            right.add(num2);
        }

        Integer total = 0;
        Map<Integer, Integer> occur = new HashMap<>();
        for (Integer num : right) {
            // add the occurences of right
            occur.merge(num, 1, Integer::sum);
        }
        for (Integer num : left) {
            int count = occur.getOrDefault(num, 0);
            total += num * count;
        }

        return total;
    }
}