package aoc2024.days;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
    
    public static int solvePart2() {
        List<String> input = InputReader.readLines("day02/input.txt");

        int count = 0;
        for (String line : input) {
            String[] levels = line.split(" ");

            int[] numLevels = new int[levels.length];
            
            // Convert to integers first
            for (int i = 0; i < levels.length; i++) {
                numLevels[i] = Integer.parseInt(levels[i]);
            }

            // If already safe, count it
            if (isSafe(numLevels) == -1) {
                count++;
                continue;
            }

            boolean foundSafeSequence;
            // Try removing each number
            for (int removeIndex = 0; removeIndex < numLevels.length; removeIndex++) {
                int[] newNumLevels = new int[numLevels.length - 1];
                
                // Copy array, skipping the number at removeIndex
                for (int j = 0, k = 0; j < numLevels.length; j++) {
                    if (j != removeIndex) {
                        newNumLevels[k++] = numLevels[j];
                    }
                }

                // Check if the new sequence is safe
                if (isSequenceSafe(newNumLevels)) {
                    count++;
                    foundSafeSequence = true;
                    break;
                }
            }
        }

        return count;
    }

    public static int isSafe(int[] numLevels) {
            Boolean isIncreasing = null;
            for (int i = 0; i < numLevels.length - 1; i++) {
                // between 1 and 3
                int diff = Math.abs(numLevels[i] - numLevels[i + 1]);
                if (diff < 1 || diff > 3) {
                    return i;
                }

                // Check consistency of increasing/decreasing
                if (isIncreasing == null) {
                    // First comparison sets the direction
                    isIncreasing = numLevels[i] < numLevels[i + 1];
                } else {
                    // Subsequent comparisons must match the initial direction
                    boolean currentCompare = numLevels[i] < numLevels[i + 1];
                    if (currentCompare != isIncreasing) {
                        return i+1;
                    }
                }
            }

        return -1; // Return -1 if the sequence is safe
    }

    // New method to comprehensively check sequence safety
    private static boolean isSequenceSafe(int[] levels) {
        // Check if sequence is monotonic (always increasing or always decreasing)
        Boolean isIncreasing = null;
        
        for (int i = 0; i < levels.length - 1; i++) {
            int diff = Math.abs(levels[i] - levels[i + 1]);
            
            // Check difference constraint
            if (diff < 1 || diff > 3) {
                return false;
            }

            // Check monotonicity
            if (isIncreasing == null) {
                isIncreasing = levels[i] < levels[i + 1];
            } else {
                boolean currentCompare = levels[i] < levels[i + 1];
                if (currentCompare != isIncreasing) {
                    return false;
                }
            }
        }
        
        return true;
    }

}
