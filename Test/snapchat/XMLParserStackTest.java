package snapchat;

import static org.junit.Assert.*;

import org.junit.Test;

public class XMLParserStackTest {
	XMLParserStack test = new XMLParserStack();
	
	@Test
	public void testXMLParserStack1() {
		String[][] input = new String[][] {
			{"open", "Story"},
			
			{"open","id"},
			{"text","John"},
			{"close","id"},
			
			{"open","Snaps"},
			
			{"open","Snap"},
			{"text","Smile"},
			{"close","Snap"},
						
			{"open","Snap"},
			{"text","Happy"},
			{"close","Snap"},
						
			{"open","Snap"},
			{"text","Jump"},
			{"close","Snap"},
			
			{"close","Snaps"},
			{"close","Story"}
		};
		test.xMLParserStack(input);
	}
	
	@Test
	public void testXMLParserStack2() {
		String[][] input = new String[][] {
			{"open", "Story"},
			
			{"open","id"},
			{"text","John"},
			{"close","id"},
			
			{"open","Snaps"},
			
			{"open","Snap"},
			{"text","Smile"},
			{"close","Snap"},
						
			{"open","Snap"},
			{"text","Happy"},
			{"close","Snap"},
						
			{"open","Snap"},
			{"text","Jump"},
			{"close","Snap"},
			
			{"open","Snaps"},
			{"close","Story"}
		};
		
		try {
			test.xMLParserStack(input);
			fail();
		} catch (IllegalArgumentException e) {
			System.out.println();
			System.out.println("Exception " + e);
		};
		
		try {
			test.xMLParserStack(input);
			fail();
		} catch (Exception e) {
			System.out.println();
			System.out.println("Exception " + e);
		};
	}

}
