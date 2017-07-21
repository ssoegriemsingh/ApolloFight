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
	private final String SUCCESS =  "Defense worked, ";
	private final String FAIL =  "Defense failed, ";
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
		String text = name + " used ";
		
		text += attack 
			? ATKOPTIONS.get(option - 1) 
			: DEFOPTIONS.get(option - 1);
		
		System.out.println(text);
	}
	
	// Displays flavor text if hit and removes one hitpoint
	public void gotHit(int option) {
		String text = FAIL + name;
		
		text += (option == ATKONE)
			? atkOneText
			: atkTwoText;
		
		System.out.println(text);
		hitpoints -= 1;
	}
	
	// Displays flavor text if avoided
	public void avoid(int option) {
		String text = SUCCESS + name;
		
		text += (option == ATKONE)
			? defOneText
			: defTwoText;
		
		System.out.println(text);
	}
}