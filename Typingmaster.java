package package1;


	import java.io.FileReader;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.util.*;

	public class TerminalTypingMaster {
	    private static final String WORDS_FILE_PATH = "words.json";
	    private static final String LEADERBOARD_FILE_PATH = "leaderboard.json";

	    private static List<String> words;
	    private static Map<String, Integer> leaderboard;

	    public static void main(String[] args) {
	        initialize();
	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Enter your username: ");
	        String username = scanner.nextLine();

	        while (true) {
	            System.out.println("Options:");
	            System.out.println("1. Start Typing Test");
	            System.out.println("2. Show Leaderboard");
	            System.out.println("3. Exit");

	            System.out.print("Enter your choice: ");
	            int choice = scanner.nextInt();
	            scanner.nextLine(); // Consume newline

	            switch (choice) {
	                case 1:
	                    startTypingTest(username);
	                    break;
	                case 2:
	                    showLeaderboard();
	                    break;
	                case 3:
	                    exit(username);
	                    break;
	                default:
	                    System.out.println("Invalid choice. Please enter a valid option.");
	            }
	        }
	    }

	    private static void initialize() {
	        loadWordsFromJson();
	        loadLeaderboardFromJson();
	    }

	    private static void loadWordsFromJson() {
	        // Placeholder: Replace with actual implementation to load words from the JSON file
	        words = Arrays.asList("apple", "banana", "orange", "grape", "kiwi");
	    }

	    private static void loadLeaderboardFromJson() {
	        // Placeholder: Replace with actual implementation to load leaderboard from the JSON file
	        leaderboard = new HashMap<>();
	    }

	    private static void startTypingTest(String username) {
	        Scanner scanner = new Scanner(System.in);
	        int wordsTyped = 0;
	        long startTime = System.currentTimeMillis();

	        System.out.println("Type the following words. Press 'Ctrl + Q' to quit.");
	        Collections.shuffle(words);

	        for (String word : words) {
	            System.out.print(word + " ");
	            String userTyped = scanner.next();

	            if ("Ctrl+Q".equalsIgnoreCase(userTyped)) {
	                System.out.println("Typing test aborted.");
	                return;
	            }

	            if (word.equals(userTyped)) {
	                wordsTyped++;
	            }
	        }

	        long endTime = System.currentTimeMillis();
	        long totalTime = endTime - startTime;
	        int wordsPerMinute = (int) ((wordsTyped * 60000) / totalTime);

	        System.out.println("\nTyping test complete!");
	        System.out.println("Words Typed: " + wordsTyped);
	        System.out.println("Time Taken: " + totalTime / 1000 + " seconds");
	        System.out.println("Words Per Minute: " + wordsPerMinute);

	        updateLeaderboard(username, wordsPerMinute);
	    }

	    private static void updateLeaderboard(String username, int wordsPerMinute) {
	        leaderboard.put(username, wordsPerMinute);
	        sortAndSaveLeaderboard();
	    }

	    private static void sortAndSaveLeaderboard() {
	        // Placeholder: Replace with actual implementation to sort and save the leaderboard to the JSON file
	        leaderboard = sortByValue(leaderboard);

	        try (FileWriter fileWriter = new FileWriter(LEADERBOARD_FILE_PATH)) {
	            // Use a library like Jackson for proper JSON serialization
	            // fileWriter.write(new ObjectMapper().writeValueAsString(leaderboard));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    private static Map<String, Integer> sortByValue(Map<String, Integer> unsortedMap) {
	        // Placeholder: Replace with actual implementation to sort the leaderboard by value
	        // For simplicity, return an unsorted map
	        return unsortedMap;
	    }

	    private static void showLeaderboard() {
	        System.out.println("\nLeaderboard:");
	        int rank = 1;

	        for (Map.Entry<String, Integer> entry : leaderboard.entrySet()) {
	            System.out.println(rank + ". " + entry.getKey() + ": " + entry.getValue() + " WPM");
	            rank++;
	        }
	    }

	    private static void exit(String username) {
	        System.out.println("Exiting Terminal Typing Master. Goodbye, " + username + "!");
	        saveWordsToJson();
	        saveLeaderboardToJson();
	        System.exit(0);
	    }

	    private static void saveWordsToJson() {
	        // Placeholder: Replace with actual implementation to save words to the JSON file
	    }

	    private static void saveLeaderboardToJson() {
	        // Placeholder: Replace with actual implementation to save the leaderboard to the JSON file
	    }
	}

