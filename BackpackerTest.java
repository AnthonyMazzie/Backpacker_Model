package hw1;

/**
 * Tester class for the Backpacker class.
 * 
 * @author AMazzie
 *
 */
public class BackpackerTest {

	public static void main(String[] args) {
		
		// a few places to visit
		Location paris = new Location("Paris", 75);
		Location rome = new Location("Rome", 50);

		// start out in Paris
		Backpacker t = new Backpacker(500, paris);
			
		// initial state
		System.out.println(t.getCurrentLocation()); // expected "Paris"
		System.out.println(t.getJournal()); // expected "Paris(start)"
		
		// try going to Rome
		t.visit(rome, 2);
		
		System.out.println(t.getCurrentLocation()); // expected "Rome"
		System.out.println(t.getJournal()); // expected "Paris(start),Rome(2)"
		
		//back to Paris for a week
		t.visit(paris, 7);
		System.out.println(t.getCurrentLocation()); // expected "Paris"
		System.out.println(t.getJournal()); // "Paris(start),Rome(2),Paris(7)"
		
		t = new Backpacker(500, paris); // start over

		// initial state
		System.out.println(t.getCurrentFunds()); // expected 500

		// visit a location
		t.visit(rome, 2);
		System.out.println(t.getCurrentFunds()); // expected 400
		
		t.visit(paris, 7);
		System.out.println(t.getCurrentFunds()); // expected 25
		System.out.println(t.getTotalNightsInTrainStation()); // expected 2
	}
}
