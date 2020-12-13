package hw1;

/**
 * 
 * This class keeps the location of a backpacker and holds some
 * information like name, lodging cost, cost to send postcard,
 * max length of stay and max number of postcards can send.
 * 
 * @author AMazzie
 */
public class Location {
	
	public static final double RELATIVE_COST_OF_POSTCARD = 0.05;
	private String givenName;
	private int givenLodgingCost;
	
	/**
	 * There is one public constructor that constructs a new
	 * Location class object with the given name and lodging
	 * cost per night.
	 * @param givenName
	 * @param givenLodgingCost
	 */
	public Location(String givenName, int givenLodgingCost) {
		this.givenName = givenName;
		this.givenLodgingCost = givenLodgingCost;
	}
	
	/**
	 * Returns the object of Location class type's name
	 * @return
	 */
	public String getName() {
		return givenName;
	}
	
	/**
	 * Returns the object of Location class type's lodging cost
	 * per night.
	 * @return
	 */
	public int lodgingCost() {
		return givenLodgingCost;
	}
	
	/**
	 *Returns the cost to send a postcard from this location.
	 *Returned as a percentage of lodging cost specified by
	 *the constant RELATIVE_COST_OF_POSTCARD, rounded to the
	 *nearest integer.
	 * @return
	 */
	public int costToSendPostcard() {
		return (int)Math.round(givenLodgingCost * RELATIVE_COST_OF_POSTCARD);
	}
	
	/**
	 * Returns the number of nights of lodging in this location
	 * that a backpacker could afford with the given amount of
	 * money.
	 * @param Funds
	 * @return
	 */
	public int maxLengthOfStay(int Funds) {
		return Funds / givenLodgingCost;
	}
	
	/**
	 * Returns the number of postcards that a backpacker could
	 * afford to send from this location with the given amount
	 * of money.
	 * @param Funds
	 * @return
	 */
	public int maxNumberOfPostcards(int Funds) {
		return Funds /(costToSendPostcard());
	}
}
