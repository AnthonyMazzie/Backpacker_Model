package hw1;

/**
 * Tester class for the Location class.
 * 
 * @author AMazzie
 *
 */
public class LocationTest {

	public static void main(String[] args) {
		Location c = new Location("Paris", 75);

		// We should see the values with which we constructed it
		System.out.println(c.getName()); // expected "Paris"
		System.out.println(c.lodgingCost()); // expected 75
		System.out.println(c.maxLengthOfStay(500)); // expected 6
		System.out.println(c.maxLengthOfStay(50)); // expected 0
		System.out.println(c.costToSendPostcard()); // expected 4
		System.out.println(c.maxNumberOfPostcards(50)); // expected 12

	}

}
