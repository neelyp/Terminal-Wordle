import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner; // Import the Scanner class

public class Words {
		public String randomWord() {
				String fileName = "answers.txt";

				try {
						BufferedReader reader = new BufferedReader(new FileReader(fileName));
						ArrayList<String> words = new ArrayList<>();
						String line;

						while ((line = reader.readLine()) != null) {
								words.add(line);
						}

						reader.close(); // Close the file reader when you're done reading

						if (!words.isEmpty()) {
								Random random = new Random();
								int randomIndex = random.nextInt(words.size());
								String randomWord = words.get(randomIndex);
								return randomWord;
						} else {
								return "The file is empty.";
						}
				} catch (IOException e) {
						return "An error occurred: " + e.getMessage();
				}
		}

		public boolean isInList(String wrd) {
				String fileName = "guesses.txt"; // Replace with the path to your text file

				try {
						BufferedReader reader = new BufferedReader(new FileReader(fileName));
						String line;
						boolean found = false;

						while ((line = reader.readLine()) != null) {
								if (line.trim().equalsIgnoreCase(wrd.trim())) {
										found = true;
										break;
								}
						}

						reader.close(); // Close the file reader when you're done reading

						if (found) {
								return true;
						} else {
								return false;
						}
				} catch (IOException e) {
						System.err.println("An error occurred: " + e.getMessage());
						return false;
				}
		}
}
