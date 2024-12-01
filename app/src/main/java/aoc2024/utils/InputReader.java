package aoc2024.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class InputReader {
    private static final String INPUT_DIR = "app/src/main/resources";

    /**
     * Reads all lines from an input file.
     * @param fileName The name of the file in the resources directory
     * @return List of strings, one for each line in the file
     */
    public static List<String> readLines(String fileName) {
        try {
            Path path = Paths.get(INPUT_DIR, fileName);
            return Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read input file: " + fileName, e);
        }
    }

    /**
     * Reads all lines from an input file as a stream.
     * Useful for large files or when you want to process lines lazily.
     * @param fileName The name of the file in the resources directory
     * @return Stream of strings, one for each line in the file
     */
    public static Stream<String> readLinesStream(String fileName) {
        try {
            Path path = Paths.get(INPUT_DIR, fileName);
            return Files.lines(path);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read input file: " + fileName, e);
        }
    }

    /**
     * Reads all lines and converts them to integers.
     * Useful for puzzles where each line is a number.
     * @param fileName The name of the file in the resources directory
     * @return List of integers
     */
    public static List<Integer> readLinesAsInts(String fileName) {
        return readLines(fileName).stream()
            .map(Integer::parseInt)
            .toList();
    }

    /**
     * Reads the entire file as a single string.
     * Useful when the input needs to be processed as a whole.
     * @param fileName The name of the file in the resources directory
     * @return The entire file content as a string
     */
    public static String readFile(String fileName) {
        try {
            Path path = Paths.get(INPUT_DIR, fileName);
            return Files.readString(path);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read input file: " + fileName, e);
        }
    }
} 