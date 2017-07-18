// Import:
import packages.Character;
import packages.Debug;

import java.util.Scanner;

// Class:
public class ApolloFight {
	
	// Constants:
	private static final Debug DEBUG = new Debug();
	private static final Scanner SCANNER = new Scanner(System.in);
	
	// Variables:
	Character playerOne;
	Character playerTwo;
	
	// Main:
	public static void main(String[] args) {
		ApolloFight apolloFight = new ApolloFight();
	}
	
	// Constructor:
	public ApolloFight() {
		chooseCharacter();
	}
	
	public void chooseCharacter() {
		System.out.println("Choose your character: Nik or Sheik");
		String p1 = SCANNER.next();
		
		if (p1.equals("Nik")) {
			playerOne = new Character(1);
			playerTwo = new Character("2");
		} else if (p1.equals("Sheik")) {
			playerOne = new Character("2");
			playerTwo = new Character(1);
		} else {
			System.out.println("Invalid choice.");
		}
		
		System.out.println("Player: " + playerOne.getName());
		System.out.println("Enemy: " + playerTwo.getName());
		
		playerOne.Options(playerOne);
	}
	
}