package org.example;

import java.util.*;

public class AnagramAnalyser {
    private static final Map<String, List<String>> wordWithAnagrams = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Welcome to Anagram Analyser!!");
        System.out.println("-----------------------------");
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.printf("Type two comma separated words and I will tell you%n"
                    + "1. If they are Anagrams%n"
                    + "2. All the Anagrams for the given words%n");
            String userInput = scanner.nextLine();
            if (isValidUserInput(userInput)) {
                List<String> wordsToAnalyze = Arrays.asList(userInput.replaceAll(" ", "").split(","));
                initializeMap(wordsToAnalyze);
                isAnagram(wordsToAnalyze);
                printAnagramsForWords(wordsToAnalyze);
            } else {
                System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
                System.out.printf("ERROR: Invalid User Input.%nTIP: Enter only single words and seperated only by comma. No numbers allowed. No other characters allowed.%n");
                System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
            }
            System.out.printf("Enter C to analyze a new set of words.(The application will exit for any other input.))%n");
        } while (scanner.nextLine().equalsIgnoreCase("c"));
    }

    public static void isAnagram(List<String> wordsToAnalyze) {
        System.out.println("FEATURE 1: The details of our analysis are");
        System.out.println("------------------------------------------");
        for (int i = 0; i < wordsToAnalyze.size(); i++) {
            for (int j = i + 1; j < wordsToAnalyze.size(); j++) {
                String word1 = wordsToAnalyze.get(i);
                String word2 = wordsToAnalyze.get(j);
                if (hasSameLetters(word1, word2)) {
                    System.out.println(word1 + " and " + word2 + " are Anagrams!");
                    addAnagramsToMap(word1, word2);
                    addAnagramsToMap(word2, word1);
                } else {
                    System.out.println(word1 + " and " + word2 + " are not Anagrams!");
                }
            }
        }
        System.out.println("------------------------------------------");
    }

    public static void printAnagramsForWords(List<String> wordsToAnalyze) {
        System.out.println("FEATURE 2: List of anagrams of all the given words are");
        System.out.println("------------------------------------------------------");
        wordsToAnalyze.forEach(word -> System.out.println("The anagrams of " + word + " : " + wordWithAnagrams.get(word)));
        System.out.println("------------------------------------------");
    }

    public static boolean isValidUserInput(String userInput) {
        List<String> userInputWordsList = Arrays.asList(userInput.split(","));
        if (userInputWordsList.size() < 2) {
            return false;
        }
        boolean errorOccurred = false;
        for (String s : userInputWordsList) {
            if (!(s.matches("[a-zA-Z]+"))) {
                errorOccurred = true;
                break;
            }
        }
        return !errorOccurred;
    }

    private static boolean hasSameLetters(String word1, String word2) {
        return getSortedLetters(word1).equals(getSortedLetters(word2));
    }

    private static String getSortedLetters(String word) {
        char[] letters = word.toCharArray();
        Arrays.sort(letters);
        return Arrays.toString(letters);
    }

    private static void addAnagramsToMap(String word, String anagram) {
        wordWithAnagrams.get(word).add(anagram);
    }

    private static void initializeMap(List<String> wordsToAnalyze) {
        wordsToAnalyze.forEach(word -> wordWithAnagrams.put(word, new ArrayList<>()));
    }
}