import java.lang.Math;
import java.util.Scanner;

class Main {
	static String randomWord() {
		String[] randomWords = {
    "apple", "happy", "cloud", "beach", "music",
    "jazz", "zebra", "dream", "ocean", "mango",
    "water", "tiger", "light", "table", "smile",
    "dance", "globe", "waltz", "quick", "juice",
    "grape", "lemon", "chess", "vivid", "queen",
    "sweep", "fairy", "lucky", "peace", "jolly",
    "mouse", "honey", "sunny", "noble", "magic",
    "flame", "bloom", "grace", "sharp", "happy",
    "peace", "frost", "wings", "alive", "dream",
    "brave", "piano", "earth", "salsa", "beard",
    "panda", "kitty", "oasis", "fable", "whale",
    "tulip", "dream", "sweet", "music", "laser",
    "shine", "puppy", "smile", "chirp", "beard",
    "frost", "lucky", "swift", "tiger", "jolly",
    "lemon", "queen", "globe", "dance", "jazz",
    "cloud", "zebra", "apple", "grape", "sweep",
    "waltz", "table", "water", "sunny", "juice",
    "happy", "magic", "panda", "grace", "dream",
    "sharp", "alive", "fairy", "quick", "earth",
    "noble", "whale", "music", "frost", "bloom",
    "honey", "salsa", "peace", "beach", "dream",
		"carti", "opium", "fwahh"
		};

		return randomWords[(int)(Math.random() * randomWords.length)];
	}

	public static void main(String[] args) {
		// String word = randomWord();
		String word = "carti";
		Scanner in = new Scanner(System.in);

		String correctPlace = "y";
		String wrongPlace = "a";
		String notInWord = "n";

		int i = 1;
		String guess;

		boolean correct = false;

		while (i < 6) {
			System.out.println("\nEnter your guess: ");
			guess = in.next();

			if (guess.length() != 5) System.out.println("Guess must be 5 letters");
			else {
				for (int j = 0; j < word.length(); j++) {
					if (guess.charAt(j) == word.charAt(j)) {
						System.out.print(correctPlace);

						if (j == word.length() - 1 && (guess.charAt(0) == word.charAt(0) && 
									guess.charAt(1) == word.charAt(1) &&
									guess.charAt(2) == word.charAt(2) &&
									guess.charAt(3) == word.charAt(3) &&
									guess.charAt(4) == word.charAt(4)
						)) {
							System.out.println("\nYou got it in " + i + " tries");
							correct = true;
							break;
						}
					} else if (word.contains(String.valueOf(guess.charAt(j)))) {
						System.out.print(wrongPlace);
					} else System.out.print(notInWord);
				}
			}

			if (correct) {
				break;
			}

			i++;
		}
		
		if (!correct) System.out.println("\nYou didn't get the word :(. The answer was: " + word);
		in.close();
	}
}