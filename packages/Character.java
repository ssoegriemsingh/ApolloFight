// Packages:
package packages;

// Imports:
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import packages.Debug;

// Class:
public class Character {
	
	// Constants:
	private static final Debug DEBUG = new Debug();
	private final String SUCCESS =  "It worked, ";
	private final String FAIL =  "It failed, ";
	private final int ATKONE = 1;
	private final int ATKTWO = 2;
	
	private  List<String> ATKOPTIONS = new ArrayList<>();
	private  List<String> DEFOPTIONS = new ArrayList<>();
	
	// Global vars:
	private String name;
	private String atkOneText;
	private String atkTwoText;
	private String defOneText;
	private String defTwoText;
	private int hitpoints = 3;
	
	// Main:
	public static void main(String[] args) {
		
	}
	
	// Constructors:
	public Character(String character) {		
		name = "Sheik";
		
		ATKOPTIONS.addAll(Arrays.asList("Boardgame Day", "C# coding style"));
		DEFOPTIONS.addAll(Arrays.asList("Bollywood", "Suriname time"));
		
		atkOneText = " got dizzy from the loop-the-loops.";
		atkTwoText = " was bored to sleep.";
		
		defOneText = " danced out of the way.";
		defTwoText = " was to late to get hit.";
	}
	
	public Character(int character) {
		name = "Nik";
		
		ATKOPTIONS.addAll(Arrays.asList("Arial Ace", "Salesforce"));
		DEFOPTIONS.addAll(Arrays.asList("I'm sorry", "The Russian bear"));
		
		atkOneText = " lost at a boardgame.";
		atkTwoText = " is confused by the coding style.";
		
		defOneText = " charmed his way out.";
		defTwoText = " takes no shit from others.";
	}
	
	// getName:
	public String getName() {
		return name;
	}
	
	// getHitpoints
	public int getHitpoints() {
		return hitpoints;
	}
	
	// getAttackOptions:
	public List<String> getAttackOptions() {
		return ATKOPTIONS;
	}
	
	// getDefenseOptions:
	public List<String> getDefenseOptions() {
		return DEFOPTIONS;
	}
	
	// Handels the attack and defense actions
	public void action(boolean attack, int option) {
		if (attack) {
			switch(option) {
				case 1:
				System.out.println(name + " used " + ATKOPTIONS.get(0));
				break;
				case 2:
				System.out.println(name + " used " + ATKOPTIONS.get(1));
				break;
				default:
				System.out.println("default attack action: " + option);
				break;
			}
		} else {
			switch(option) {
				case 1:
				System.out.println(name + " used " + DEFOPTIONS.get(0));
				break;
				case 2:
				System.out.println(name + " used " + DEFOPTIONS.get(1));
				break;
				default:
				System.out.println("default defense action " + option);
				break;
			}
		}
	}
	
	// Displays flavor text if hit and removes one hitpoint
	public void gotHit(int option) {
		if (option == ATKONE) {
			System.out.println(FAIL + name + atkOneText);
		} else {
			System.out.println(FAIL + name + atkTwoText);
		}
		hitpoints -= 1;
	}
	
	// Displays flavor text if avoided
	public void avoid(int option) {
		if (option == ATKONE) {
			System.out.println(SUCCESS + name + defOneText);
		} else {
			System.out.println(SUCCESS + name + defTwoText);
		}
	}
}