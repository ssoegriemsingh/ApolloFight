// Import:
import java.util.List;
import java.util.Scanner;

import packages.Character;
import packages.Debug;

// Class:
public class ApolloFight {
	
	// Constants:
	private static final Debug DEBUG = new Debug();
	private static final Scanner SCANNER = new Scanner(System.in);
	
	// Variables:
	Character player;
	Character enemy;
	String input;
	Integer option;
	
	boolean playerInputReq;
	boolean playerTurn = true;
	//boolean attackPhase = true;
	boolean gameOver = false;
	
	// Main:
	public static void main(String[] args) {
		ApolloFight apolloFight = new ApolloFight();
	}
	
	// Constructor:
	public ApolloFight() {
		chooseCharacter();
		showStatus();
		turnHandeler();
		// atkPhase();
		// turnAction();
	}
	
	
	// Get the input from the player
	public void playerInput() {
		input = SCANNER.next();
	}
	
	// Checks if the input from the player is valid
	public void checkInput() {
		playerInputReq = true;
		while (playerInputReq) {
			playerInput();
			if (input.equals("1") || input.equals("2")) {
				playerInputReq = false;
				option = Integer.parseInt(input);
			} else {
				System.out.println("Invalid choice.");
			}
		}
	}
	
	// Let's the player choose his character
	public void chooseCharacter() {
		System.out.println("Choose your character: (1) Nik or (2) Sheik");
		checkInput();
		if (input.equals("1")) {
			player = new Character(1);
			enemy = new Character("2");
		} else {
			player = new Character("2");
			enemy = new Character(1);
		}
	}
	
	// Displays the current status
	public void showStatus() {
		System.out.println("Player: " + player.getName() + " HP: " + player.getHitpoints());
		System.out.println("Enemy: " + enemy.getName() + " HP: " + enemy.getHitpoints());
	}
	
	// Displays the current choices of the player
	public void displayOptions(List<String> options, String move) {
		System.out.println("Choose your " + move + " \n " 
												 + "(1) " + options.get(0)
												 + " \n " 
												 + "(2) " + options.get(1));
	}
	
	public void turnHandeler() {
		while (!gameOver) {
			playerTurn();
			enemyTurn();
			checkHit();
			toggleTurns();
			checkGameOver();
			showStatus();
		}
	}
	
	public void playerTurn() {		
		if (playerTurn) {
			displayOptions(player.getAttackOptions(), "Attack");
			checkInput();
			player.action(true, option);
		} else {
			displayOptions(player.getDefenseOptions(), "Defense");
			checkInput();
			player.action(false, option);
		}
	}
	
	public void enemyTurn() {
		if (playerTurn) {
			DEBUG.log("Enemy Defense");
		} else {
			DEBUG.log("Enemy Attack");
		}
	}
	
	public void toggleTurns() {
		if (playerTurn) {
			playerTurn = false;
		} else {
			playerTurn = true;
		}
	}
	
	public void checkHit() {
		DEBUG.log("Check for Hit.");
	}
	
	public void checkGameOver() {
		DEBUG.log("Check for Game Over.");
	}
	
	// Should not be here >>> Character Class methode
	// public void atkPhase() {
		// System.out.println("Choose your attack:" + NEWLINE 
												 // + "(1) " + playerOne.getAttackOptions().get(0)
												 // + NEWLINE 
												 // + "(2) " + playerOne.getAttackOptions().get(1));
		
		// playerInput();
		// int atk = getOption();
		
		// playerOne.action(playerOneATK, atk);
	// }
	
	// public void turnAction() {
		// DEBUG.log("P1 ATK: " + playerOneATK);
		// DEBUG.log("P@ ATK: " + playerTwoATK);
		// DEBUG.log("Funtion turnAction");
		
		// playerOne.action(playerOneATK, Integer.parseInt(input));
		// playerTwo.action(playerTwoATK, Integer.parseInt(input));
		// Toggelturns();
		
		// DEBUG.log("P1 ATK: " + playerOneATK);
		// DEBUG.log("P2 ATK: " + playerTwoATK);
	// }
	
	// public int getOption() {
		// return Integer.parseInt(input);
	// }
}