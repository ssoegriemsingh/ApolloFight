// Import:
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

import packages.Character;
import packages.Debug;

// Class:
public class ApolloFight {
	
	// Constants:
	private static final Debug DEBUG = new Debug();
	private static final Scanner SCANNER = new Scanner(System.in);
	private static final Random RANDOM = new Random();
	
	private final boolean ATK = true;
	private final boolean DEF = false;
	private final int ZERO = 0;
	
	// Variables:
	Character player;
	Character enemy;
	String input;
	Integer playerOption;
	Integer enemyOption;
	
	boolean playerInputReq;
	boolean playerTurn = true;
	
	// Main:
	public static void main(String[] args) {
		ApolloFight apolloFight = new ApolloFight();
	}
	
	// Constructor:
	public ApolloFight() {
		chooseCharacter();
		showStatus();
		turnHandeler();
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
				playerOption = Integer.parseInt(input);
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
	
	// Keeps alternating turns until game over
	public void turnHandeler() {
		boolean gameOver = false;

		while (!gameOver) {
			playerTurn();
			enemyTurn();
			checkHit();
			toggleTurns();
			gameOver = checkGameOver();
			showStatus();
		}
		System.out.println("GAME OVER ");
	}
	
	// Handels the player turn
	public void playerTurn() {
		String move;
		List<String> ops;
		boolean attack;
		
		
		if (playerTurn) {
			move = "Attack";
			ops = player.getAttackOptions();
			attack = ATK;
		} else {
			move = "Defense";
			ops = player.getDefenseOptions();
			attack = DEF;
		}

		displayOptions(ops, move);
		checkInput();
		player.action(attack, playerOption);
	}
	
	// Handels the enemy turn
	public void enemyTurn() {
		enemyOption = RANDOM.nextInt(2) + 1;
		
		if (playerTurn) {
			enemy.action(DEF, enemyOption);
		} else {
			enemy.action(ATK, enemyOption);
		}
	}
	
	// Toggles between turns
	public void toggleTurns() {
		if (playerTurn) {
			playerTurn = false;
		} else {
			playerTurn = true;
		}
	}
	
	// Check for hit
	public void checkHit() {
		if (playerTurn) {
			if (playerOption == enemyOption) {
				enemy.gotHit(enemyOption);
			} else {
				enemy.avoid(enemyOption);
			}
		} else {
			if (enemyOption == playerOption) {
				player.gotHit(playerOption);
			} else {
				player.avoid(playerOption);
			}
		}
	}
	
	// Check for game over
	public boolean checkGameOver() {
		
		List<Character> players = Arrays.asList(player, enemy);
		
		for (Character p : players) {
			if (p.getHitpoints() == ZERO) {
				System.out.println(p.getName() + " loses.");
				return true;
			}
		}
		return false;
	}
}