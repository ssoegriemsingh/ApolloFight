// Packages:
package packages;

// Imports:
import packages.Debug;


// Class:
public class Character {
	
	// Constants:
	private static final Debug DEBUG = new Debug();
	private String NAME;
	private String ATK1;
	private String ATK2;
	private String DEF1;
	private String DEF2;
	
	// Main:
	public static void main(String[] args) {
		
	}
	
	// Constructors:
	public Character(String character) {		
		NAME = "Sheik";
	}
	
	public Character(int character) {
		NAME = "Nik";
	}
	
	public String getName() {
		return NAME;
	}
	
	// Options:
	public void Options(Character character) {
		if (character.NAME == "Sheik") {			
			ATK1 = "Boardgame Day"; 	// It worked, Nik lost at a boardgame
			ATK2 = "C# coding style"; 	// It worked, Nik is confused by the coding style
			
			DEF1 = "Bollywood";			// It worked, Sheik danced out of the way
			DEF2 = "Suriname time";		// It worked, Sheik was to late to get hit
		} else {			
			ATK1 = "Arial Ace";			// It worked, Sheik got dizzy from the loop-the-loops
			ATK2 = "Salesforce";		// it worked, Sheik was bored to sleep
			
			DEF1 = "I'm sorry";			// It worked, Nik charmed his way out
			DEF2 = "The Russian bear";	// It worked, Nik takes no shit from others
		}
		
		System.out.println(ATK1 + "\n" + ATK2 + "\n" + DEF1 + "\n" + DEF2);
	}
}