package snapchat;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class XMLParserTest {
	XMLParser test = new XMLParser();
	
	@Test
	public void testXMLParser1() {
		String[] input = new String[] {
			"open,Story",
			
			"open,id",
			"text,John",
			"close,id",
			
			"open,Snaps",
			
			"open,Snap",
			"text,Smile",
			"close,Snap",
			
			"open,Snap",
			"text,Happy",
			"close,Snap",
			
			"open,Snap",
			"text,Jump",
			"close,Snap",
			
			"close,Snaps",
			"close,Story"
		};
		test.xMLParser(input);
	}
	
	@Test
	public void testXMLParser2() {
		String[] input = new String[] {
			"open,Story",
			
			"open,id",
			"text,John",
			"close,id",
			
			"open,Snaps",
			
			"open,Snap",
			"text,Smile",
			"close,Snap",
			
			"open,Snap",
			"text,Happy",
			"close,Snap",
			
			"open,Snap",
			"text,Jump",
			"close,Snap",
			
			"open,Snaps",
			"close,Snaps"
		};
		try {
			test.xMLParser(input);
			fail();
		} catch (IllegalArgumentException e) {
			System.out.println();
			System.out.println("Exception " + e);
		};
		
		try {
			test.xMLParser(input);
			fail();
		} catch (Exception e) {
			System.out.println();
			System.out.println("Exception " + e);
		};
	}

}
