package snapchat2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ReconstructItineraryAfterDiscussTest {
	ReconstructItineraryAfterDiscuss test = new ReconstructItineraryAfterDiscuss();
	
	@Test
	public void testFindItinerary1() {
		String[][] tickets = new String[][] {
			{"MUC", "LHR"},
			{"JFK", "MUC"},
			{"SFO", "SJC"},
			{"LHR", "SFO"}
		};
		List<String> expected = new ArrayList<>();
		expected.add("JFK");
		expected.add("MUC");
		expected.add("LHR");
		expected.add("SFO");
		expected.add("SJC");
		assertEquals(expected.size(), test.reconstructItineraryAfterDiscuss(tickets).size());
		assertEquals(true, expected.containsAll(test.reconstructItineraryAfterDiscuss(tickets)));
	}
	
	@Test
	public void testFindItinerary2() {
		String[][] tickets = new String[][] {
			{"JFK", "SFO"},
			{"JFK", "ATL"},
			{"SFO", "ATL"},
			{"ATL", "JFK"},
			{"ATL", "SFO"},
		};
		List<String> expected = new ArrayList<>();
		expected.add("JFK");
		expected.add("ATL");
		expected.add("JFK");
		expected.add("SFO");
		expected.add("ATL");
		expected.add("SFO");
		assertEquals(expected.size(), test.reconstructItineraryAfterDiscuss(tickets).size());
		assertEquals(true, expected.containsAll(test.reconstructItineraryAfterDiscuss(tickets)));
	}

}
