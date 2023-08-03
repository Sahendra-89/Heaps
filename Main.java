import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Word Counter tool!");

        System.out.println("Please enter your text or provide a file path to count the words:");

        String input = scanner.nextLine().trim();

        while (input.isEmpty()) {
            System.out.println("Input is empty. Please try again:");
            input = scanner.nextLine().trim();
        }

        List<String> wordsList;
        if (input.endsWith(".txt")) {

            try {
                wordsList = readWordsFromFile(input);
            } catch (IOException e) {
                System.out.println("Error reading the file. Please check the file path and try again.");
                scanner.close();
                return;
            }
        } else {

            wordsList = splitTextIntoWords(input);
        }

        int wordCount = wordsList.size();

        System.out.println("Total count of words: " + wordCount);

        Set<String> stopWords = new Hash<>(Arrays.asList("the", "and", "is", "are", "in", "to", "of", "a"));

        wordsList.removeAll(stopWords);

        Set<String> uniqueWords = new Hash<>(wordsList);
        System.out.println("Number of unique words: " + uniqueWords.size());

        Map<String, Integer> wordFrequency = new HashMap<>();
        for (String word : wordsList) {
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }

        System.out.println("Word Frequency:");
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        scanner.close();
    }

    private static List<String> readWordsFromFile(String filePath) throws IOException {
        List<String> wordsList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                wordsList.addAll(splitTextIntoWords(line));
            }
        }
        return wordsList;
    }

    private static List<String> splitTextIntoWords(String text) {
        String[] words = text.split("\\s+|\\p{Punct}+");
        return Arrays.asList(words);
    }
}
