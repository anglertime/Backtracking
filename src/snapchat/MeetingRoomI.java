package snapchat;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MeetingRoomI {
	public int minMeetingRooms(Interval[] meetings) {
        // 1. sort
		Arrays.sort(meetings, new Comparator<Interval> () {
			@Override
			public int compare(Interval front, Interval back) {
				return front.start - back.start;
			}
		});
		// 2. schedule meetings
		PriorityQueue<Integer> heap = new PriorityQueue<>();
		for (int i = 0 ; i < meetings.length ; i ++) {
			if (heap.isEmpty()) {
				heap.offer(meetings[i].end);
			} else {
				if (meetings[i].start >= heap.peek()) {
					heap.poll();
					heap.offer(meetings[i].end);
				} else {
					heap.offer(meetings[i].end);
				}
			}
		}
		// 3. min nr of rooms is size of priority queue
		return heap.size();
	}
	
	public boolean canAttendMeetings(Interval[] intervals) {
		// ÒÑAccepted
//         Comparator<Interval> order = new StartingTime();
//         Arrays.sort(intervals, order);
        Arrays.sort(intervals, new Comparator<Interval> () {
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        
        for (int i = 1 ; i < intervals.length ; i ++) {
            if (intervals[i].start < intervals[i - 1].end) {
                return false;
            }
        }
//        List<Integer> list = new List<>();
        return true;
    }
    
    private class StartingTime implements Comparator<Interval> {
        @Override
        public int compare(Interval i1, Interval i2) {
            return i1.start - i2.start;
        }
    }
    
    public static class Interval {
		public int start;
		public int end;
		Interval() { start = 0; end = 0; }
		public Interval(int s, int e) { start = s; end = e; }
    }
}
