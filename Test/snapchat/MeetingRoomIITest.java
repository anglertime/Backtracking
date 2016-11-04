package snapchat;

import static org.junit.Assert.*;

import org.junit.Test;

public class MeetingRoomIITest {
	MeetingRoomII test = new MeetingRoomII();
	
	@Test
	public void testMeetingRoomII1() {
		int[][] input = new int[][] {
			{0, 30},
			{5, 10},
			{10, 20}
		};
		int expected = 2;
		assertEquals(expected, test.meetingRoomII(input));
	}
	
	@Test
	public void testMeetingRoomII2() {
		int[][] input = new int[][] {
			{0, 30},
			{5, 10},
			{5, 8},
			{7, 9},
			{2, 5},
			{1, 4},
			{9, 10}
		};
		int expected = 4;
		assertEquals(expected, test.meetingRoomII(input));
	}
}
