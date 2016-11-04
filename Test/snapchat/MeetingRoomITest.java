package snapchat;

import static org.junit.Assert.*;

import org.junit.Test;
import snapchat.MeetingRoomI.Interval;

public class MeetingRoomITest {
	MeetingRoomI test = new MeetingRoomI();
	
	@Test
	public void testCanAttendMeetings() {
		Interval[] input = new Interval[3];
		input[0] = new Interval(0, 30);
		input[1] = new Interval(5, 10);
		input[2] = new Interval(15, 20);
		assertEquals(false, test.canAttendMeetings(input));
	}

}
