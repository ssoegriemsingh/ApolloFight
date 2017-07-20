// Import:
import packages.Character;
import packages.Debug;

import java.util.Scanner;

// Class:
public class ApolloFight {
	
	// Constants:
	private static final Debug DEBUG = new Debug();
	private static final Scanner SCANNER = new Scanner(System.in);
	private static final String NEWLINE = "\n";
	
	// Variables:
	Character playerOne;
	Character playerTwo;
	String input;
	boolean playerOneATK = true;
	boolean playerTwoATK = false;
	
	// Main:
	public static void main(String[] args) {
		ApolloFight apolloFight = new ApolloFight();
	}
	
	// Constructor:
	public ApolloFight() {
		chooseCharacter();
		// atkPhase();
		turnAction();
	}
	
	public void playerInput() {
		input = SCANNER.next();
	}
	
	public void chooseCharacter() {
		System.out.println("Choose your character: Nik or Sheik");
		playerInput();
		
		if (input.equals("Nik")) {
			playerOne = new Character(1);
			playerTwo = new Character("2");
		} else if (input.equals("Sheik")) {
			playerOne = new Character("2");
			playerTwo = new Character(1);
		} else {
			System.out.println("Invalid choice.");
		}
		
		showStatus();
	}
	
	public void showStatus() {
		System.out.println("Player: " + playerOne.getName() + " HP: " + playerOne.getHitpoints());
		System.out.println("Enemy: " + playerTwo.getName() + " HP: " + playerTwo.getHitpoints());
	}
	
	public void Toggelturns() {
		if (playerOneATK) {
			playerOneATK = false;
			playerTwoATK = true;
		} else {
			playerOneATK = true;
			playerTwoATK = false;
		}
	}
	
	// Should not be here >>> Character Class methode
	public void atkPhase() {
		System.out.println("Choose your attack:" + NEWLINE 
												 + "(1) " + playerOne.getAttackOptions().get(0)
												 + NEWLINE 
												 + "(2) " + playerOne.getAttackOptions().get(1));
		
		playerInput();
		int atk = getOption();
		
		playerOne.attack(atk);
	}
	
	public void turnAction() {
		playerOne.action(playerOneATK);
		playerTwo.action(playerTwoATK);
		Toggelturns();
	}
	
	public int getOption() {
		return Integer.parseInt(input);
	}
}