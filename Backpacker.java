package hw1;


/**
 * A backpacker is a young person bumming around Europe. When they need
 * more money, they send postcards home to their parents.
 * 
 * If they run out of money, they are SOL.
 * 
 * @author AMazzie
 *
 */
public class Backpacker {
	
	/**
	 * Proportionality constant when calling home for more
	 * money: the amount of money received is this constant
	 * times the number of postcards the backpacker has sent
	 * home (since the last time she called home for money).
	 */
	public static final int SYMPATHY_FACTOR = 30;
	private int currentFunds;
	private String journalKeeper;
	private Location currentLoca;
	private int numberPostcardsSent;
	private int numNightsTrainStation;
	
	/**
	 * Constructs a backpacker starting out with the given amount of
	 * money in the given location. The journal is initially a string
	 * consisting of "locationname(start)", where locationname is the
	 * name of the starting location.
	 * @param initialFunds
	 * @param initialLocation
	 */
	public Backpacker(int initialFunds, Location initialLocation) {
		currentLoca = initialLocation;
		journalKeeper = currentLoca.getName() + "(start)";
		currentFunds = initialFunds;
		numberPostcardsSent = 0;
		numNightsTrainStation = 0;
	}
	
	/**
	 * Returns the backpacker's current location.
	 * @return
	 */
	public String getCurrentLocation() {
		return currentLoca.getName();
	}
	
	/**
	 * Returns the amount of money the backpacker currently has.
	 * @return
	 */
	public int getCurrentFunds() {
		return currentFunds;
	}
	
	/**
	 * Returns the backpacker's journal.
	 * 
	 * The journal is a string of comma-separated values of the form
	 * locationname(number_of_nights) containing the cities visited by
	 * the backpacker, in the order visited, along with the number of 
	 * nights spent in each.
	 * 
	 * The first value always has the form locationname(start) for the
	 * starting location.
	 * @return
	 */
	public String getJournal() {
		return journalKeeper;
	}
	
	/**
	 * Returns true if the backpacker does not have enough money to send
	 *  a postcard from the current location
	 * @return
	 */
	public boolean isSOL() {
		return currentFunds < currentLoca.costToSendPostcard();
	}
	
	/**
	 * Returns the number of nights the backpacker has spent in a train 
	 * station when visiting a location without enough money for lodging.
	 * @return
	 */
	public int getTotalNightsInTrainStation() {
		return numNightsTrainStation;
	}
	
	/**
	 * Simulates a visit by this backpacker to the given location for the
	 *  given number of nights.
	 *  
	 *  The backpacker's funds are reduced based on the number of nights of
	 *  lodging purchased.
	 *  
	 *  When the funds are not sufficient for numNights nights of lodging in
	 *  the location, the number of nights spent in the train station is updated
	 *  accordingly.
	 *  
	 *  The journal is updated by appending a comma, the location
	 *  name, and the number of nights in parentheses.
	 *  
	 * @param C
	 * @param numNights
	 */
	public void visit (Location C, int numNights) {  //mutator method
		currentLoca = C;
		journalKeeper = journalKeeper + "," + currentLoca.getName() + "(" + numNights + ")"; 
		
		if(currentFunds > numNights * C.lodgingCost()) {
			currentFunds -= numNights * C.lodgingCost();
			numNightsTrainStation = 0;
		}
		else {
			int nightsInLodging = currentFunds / C.lodgingCost();
			currentFunds -= nightsInLodging * C.lodgingCost();
			numNightsTrainStation = numNights - nightsInLodging;
		}
	}
	
	/**
	 * Sends the given number of postcards, if possible, 
	 * reducing the backpacker's funds appropriately and 
	 * increasing the count of postcards sent. If there is
	 *  not enough money, sends as many postcards as possible
	 *   without allowing the funds to go below zero.
	 */
	public void sendPostcardsHome(int howMany) {
		int totalCost = howMany * currentLoca.costToSendPostcard();
		
		if(totalCost < currentFunds) {
			currentFunds -= totalCost;
			numberPostcardsSent += howMany;
		}
		else {
			int numberToBuy = currentFunds/currentLoca.costToSendPostcard();
			currentFunds -= (numberToBuy * currentLoca.costToSendPostcard());
			numberPostcardsSent += numberToBuy;
		}
		
	}
	
	/**
	 * Increases the backpacker's funds by an amount equal to 
	 * SYMPATHY_FACTOR 
	 */
	public void callHomeForMoney() {
		currentFunds += numberPostcardsSent * SYMPATHY_FACTOR;
		numberPostcardsSent = 0;
	}
}
