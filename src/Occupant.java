/**
 * @author Mitchell Henrie
 *
 * OO representation of an Occupant
 */
public class Occupant {
	private String firstName;
	private String lastName;
	private int age;
	private Household house;
	
	public Occupant(String firstName, String lastName, int age, Household house) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.house = house;
	}
	
	/**
	 * @return Age of current occupant
	 */
	public int getAge() {
		return age;
	}
	
	/**
	 * @return Household object representing the House in which the Occupant currently resides
	 */
	public Household getHouse() {
		return house;
	}
	
	/**
	 * @return Occupants full name by Last Name + First Name with no space in between
	 */
	public String getFullName() {
		return lastName + firstName;
	}
	
	@Override
    public String toString() {
        return "Name: " + firstName + " " + lastName + "; Address: " + house.getAddress()
        + "; Age: " + age;
    }
}