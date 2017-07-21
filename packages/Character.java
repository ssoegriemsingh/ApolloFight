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
	
	private  List<String> ATKOPTIONS = new ArrayList<>();
	private  List<String> DEFOPTIONS = new ArrayList<>();
	
	// Global vars:
	private String name;
	private int hitpoints = 3;
	
	// Main:
	public static void main(String[] args) {
		
	}
	
	// Constructors:
	public Character(String character) {		
		name = "Sheik";
		
		ATKOPTIONS.addAll(Arrays.asList("Boardgame Day", "C# coding style"));
		DEFOPTIONS.addAll(Arrays.asList("Bollywood", "Suriname time"));
		
		// "Boardgame Day"; 	It worked, Nik lost at a boardgame
		// "C# coding style"; 	It worked, Nik is confused by the coding style
		
		// "Bollywood";			It worked, Sheik danced out of the way
		// "Suriname time";		It worked, Sheik was to late to get hit
	}
	
	public Character(int character) {
		name = "Nik";
		
		ATKOPTIONS.addAll(Arrays.asList("Arial Ace", "Salesforce"));
		DEFOPTIONS.addAll(Arrays.asList("I'm sorry", "The Russian bear"));
		
		// "Arial Ace";			It worked, Sheik got dizzy from the loop-the-loops
		// "Salesforce";		it worked, Sheik was bored to sleep
		
		// "I'm sorry";			It worked, Nik charmed his way out
		// "The Russian bear";	It worked, Nik takes no shit from others
	}
	
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
				System.out.println("default action");
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
				System.out.println("default action");
				break;
			}
		}
	}
}