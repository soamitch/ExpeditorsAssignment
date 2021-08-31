
/**
 * @author Mitchell Henrie
 *
 * OO representation of a Household
 */
public class Household {

		private String address;
		private String city;
		private String state;
		
		Household(String address, String city, String state) {
			this.state = state;
			this.city = city;
			this.address = address;
		}
		
		/**
		 * @return Address of current household
		 */
		public String getAddress() {
			return address;
		}
		
		@Override
	    public boolean equals(Object obj)
	    {
			if(!(obj instanceof Household)) {
				return false;
			}
			else {
				Household other = (Household)obj;
				return other.address.equals(this.address) &&
						other.city.equals(this.city) &&
						other.state.equals(this.state);
			}
	    }
		
		@Override
	    public int hashCode()
	    {
	        return this.address.hashCode() + this.city.hashCode() + this.state.hashCode();
	    }
		
		@Override
	    public String toString() {
	        return this.address + ", " + this.city + ", " + this.state;
	    }
		
	}