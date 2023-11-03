import java.lang.Math;
import java.util.Scanner;

interface CharLamb {
	String run(char ch);
}

class Main {
	static void clear() {
		System.out.println("\033[H\033[2J");
	}
	
	static void del() {
		System.out.print("\u001B[2K");
		System.out.print("\r"); 
	}

	public static void main(String[] args) {
		Words words = new Words();
			
		String word = words.randomWord();
		Scanner in = new Scanner(System.in);

		String[] guesses = {"", "", "", "", "", ""}; // list of guesses
		String w = ""; // guess

		// System.out.println(word);
		
		CharLamb correctPlace = ch -> "\u001B[32m" + ch + "\u001B[0m";
		CharLamb wrongPlace = ch -> "\u001B[34m" + ch + "\u001B[0m";
		CharLamb notInWord = ch -> "\u001B[90m" + ch + "\u001B[0m";


		int i = 1; // looping var
		String guess; // user input

		boolean correct = false;

		while (i < 6) {
			if (i != 1) {
				w = "";
				clear(); // clears console so that all guesses can be printed and then how many guesses you have left can be printed
			}
			
			if (guesses.length != 0) {
				for (String el : guesses) {
					 if (el.length() != 0)
						 System.out.print("\n"+ el + "\n");
				}
			}
			
			System.out.print("\n" + (6 - i) + " guesses left.\nEnter your guess: ");
			guess = in.next();


			if (words.isInList(word)) System.out.println("Guess must be 5 letters");
			else {
				del();
				for (int j = 0; j < word.length(); j++) {
					if (guess.charAt(j) == word.charAt(j)) {
						System.out.print(correctPlace.run(guess.charAt(j)));
						w += correctPlace.run(guess.charAt(j));

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
						System.out.print(wrongPlace.run(guess.charAt(j)));
						w += wrongPlace.run(guess.charAt(j));
					} else {
						System.out.print(notInWord.run(guess.charAt(j)));
						w += notInWord.run(guess.charAt(j));
					}
				}
				guesses[i-1] = w;
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