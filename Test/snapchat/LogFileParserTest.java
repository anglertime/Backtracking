package snapchat;

import static org.junit.Assert.*;

import org.junit.Test;

public class LogFileParserTest {
	LogFileParser test = new LogFileParser();
	
	@Test
	public void testLogFileParser1() {
		String[][] input = new String[][] {
			{"true","game","0"},
			{"true","life","3"},
			{"true","life","5"},
			{"false","life","7"},
			{"false","life","10"},
			{"false","game","13"},
			{"true","gem","15"},
			{"false","gem","20"}
		};
		test.logFileParser(input);
		System.out.println();
	}
	
	@Test
	public void testLogFileParser2() {
		String[][] input = new String[][] {
			{"true","f1","1"},
			{"true","f1","2"},
			{"true","f2","4"},
			{"false","f2","8"},
			{"false","f1","16"},
			{"false","f1","32"},
			{"true","f3","64"},
			{"false","f3","128"}
		};
		test.logFileParser(input);
		System.out.println();
	}
	
	@Test
	public void testLogFileParser3() {
		String[][] input = new String[][] {
			{"true","f1","0"},
			{"true","f2","2"},
			{"true","f1","5"},
			{"false","f1","7"},
			{"false","f2","10"},
			{"true","f3","11"},
			{"false","f3","12"},
			{"false","f1","15"},
			{"true","f4","16"},
			{"false","f4","19"}
		};
		test.logFileParser(input);
	}
}
