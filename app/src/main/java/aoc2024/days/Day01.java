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
            // get first 5
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

        // Lookup and calculation

        for (Integer num : left) {
            int count = occur.getOrDefault(num, 0);
            total += num * count;
        }


        // we are checking for occurences of left IN right
        // since we have it ordered we can make a map of the occurnces to make it faster
        // eg:
        // for the example list we first check 3 (all be it unordered atm) - we will
        // find it occurs 3 times in right list
        // we save in a occur map: 3 : 3 -> 3 occurs 3 times
        // when we iterate over 3 again in the left list we will lookup the map for
        // map[3]
        // it will return 3 so we do 3*3 without iterating over the entire right side
        // again

        // 3 4
        // 4 3
        // 2 5
        // 1 3
        // 3 9
        // 3 3

        // 3 * 3 = 9
        // 4 * 1 = 4
        // 2 * 0 = 0
        // 1 * 0 = 0
        // 3 * 3 = 9
        // 3 * 3 = 9

        return total;

    }
}