package aoc2024.days;

import java.util.List;

import aoc2024.utils.InputReader;

public class Day02 {

    public static int solvePart1() {
        List<String> input = InputReader.readLines("day02/input.txt");

        // count of safe levels
        int count = 0;
        for (String line : input) {
            String[] levels = line.split(" ");

            int[] numLevels = new int[levels.length];
            
            // Convert to integers first
            for (int i = 0; i < levels.length; i++) {
                numLevels[i] = Integer.parseInt(levels[i]);
            }

            // remove spaces
            boolean isSafe = true;
            Boolean isIncreasing = null;

            for (int i = 0; i < numLevels.length - 1; i++) {
                // between 1 and 3
                int diff = Math.abs(numLevels[i] - numLevels[i + 1]);
                if (diff < 1 || diff > 3) {
                    isSafe = false;
                    break;
                }


            // Check consistency of increasing/decreasing
            if (isIncreasing == null) {
                // First comparison sets the direction
                isIncreasing = numLevels[i] < numLevels[i + 1];
            } else {
                // Subsequent comparisons must match the initial direction
                boolean currentCompare = numLevels[i] < numLevels[i + 1];
                if (currentCompare != isIncreasing) {
                    isSafe = false;
                    break;
                    }
                }
            }

            if (isSafe) {
                count++;
            }
        }

        return count;
    }
    
}
