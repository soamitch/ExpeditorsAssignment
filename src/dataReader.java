import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Mitchell Henrie
 *
 *	Parses Data given as input to the console and prints specified output to console.
 */
public class dataReader {
	
	/**
	 * @param args
	 * 
	 * Main Entry point for Java program
	 */
	public static void main(String[] args) {
		System.out.println("Please enter your input below (might have to hit enter twice submit input):");
		Scanner input = new Scanner(System.in);
		
		// Household is implemented to maintain uniqueness in HashMap (Override equals and hash)
		HashMap<Household, ArrayList<Occupant>> households = new HashMap<Household, ArrayList<Occupant>>();
		
		while(input.hasNextLine()) {
			String line = input.nextLine();
			
			if(line.isBlank()) {
				break;
			}
			
			String[] dataArray = line.split("\",");
			
			// Clean data
			for(int i = 0; i < dataArray.length; i++) {
				// https://www.javatpoint.com/how-to-remove-special-characters-from-string-in-java
				dataArray[i] = dataArray[i].replaceAll("[\",.]", "").strip();
				
				//account for capitalization errors for everything except names and age
				if(i > 1 && i < 5) {
					dataArray[i] = dataArray[i].toUpperCase();
				}
			}
			
			// Populate Data Structures
			String city = dataArray[3].charAt(0) + dataArray[3].substring(1).toLowerCase();
			
			Household currHouse = new Household(dataArray[2], city, dataArray[4]);
			Occupant currOccupant = new Occupant(dataArray[0], dataArray[1], Integer.parseInt(dataArray[5]), currHouse);
			
			if(households.containsKey(currHouse)) {
				households.get(currHouse).add(currOccupant);
			}
			else {
				ArrayList<Occupant> newOccupants = new ArrayList<Occupant>();
				newOccupants.add(currOccupant);
				households.put(currHouse, newOccupants);
			}
		}
		
		input.close();
		
		
		// Print data
		households.forEach((house, occupants) -> {
			System.out.println("Household: " + house.toString() + "; Num Occupants: " + occupants.size());
			System.out.println("Sorted occupants over the age of 18:");
			getSortedOccupantsOver18(occupants).forEach((occ) -> System.out.println(occ.toString()));
			System.out.println();
		});
	}
	
	
	/**
	 * @param An ArrayList of occupants
	 * @return A Stream of Occupants that filter out all under the age of 18 and sort by LastName+FirstName
	 */
	private static Stream<Occupant> getSortedOccupantsOver18(ArrayList<Occupant> occupants) {
		Collections.sort(occupants, (x1, x2) -> x1.getFullName().compareTo(x2.getFullName()));
		
		// https://howtodoinjava.com/java8/java-stream-filter-example/
		return occupants.stream().filter(x -> x.getAge() >= 18);
	}
}
