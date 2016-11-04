package snapchat;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import snapchat.MeetingRoomI.Interval;

public class MeetingRoomII {
	/*
	 * Most greedy solutions start with intuition, and then a few tests that verify
	 *  that the intuition was correct. I don't have a way to tell right away that 
	 *  a greedy solution will work. I usually start by simply drawing/plotting a 
	 *  sample scenario and observing the behavior. For this problem, I started at 
	 *  putting all the meetings on the same timeline. The idea is that when a new 
	 *  meeting starts, it may require an additional conference room, if one of the
	 *   running meetings ends we will have a vacant room for the next meeting. So 
	 *   the timeline can look something like this: [s,s,e,s,e,e]: there are three 
	 *   meetings: first meeting starts, then second meeting starts, then first meeting
	 *    ends, then third meeting starts (it uses the vacant free room from the 
	 *    first meeting that has ended), then second meeting ends, then third meeting
	 *     ends. The second meeting had no vacant room when it started, so our max # 
	 *     of rooms required increased by 1, the third meeting used one of the vacant
	 *      rooms that have been added before, so the max # overall is 2. there are 3
	 *       things that can happen when meetings overlap (note: I modified my code, 
	 *       the second if-condition didn't make sense and was not necessary): 1. All 
	 *       meetings are already running and no new meetings will start. 2. A new meeting
	 *        starts before before one of the previous ones ended. 3. A meeting ends.
	 *         These conditions correspond to the if-statements in the same order. Note,
	 *          that we don't really care which particular meeting ended or started, we 
	 *          only care that a new meeting has started or any old meeting has ended 
	 *          (look at the timeline array again). In my code, I represent the timeline 
	 *          with two sorted arrays of start times and end times and two pointers. The
	 *           way we iterate over these two arrays is similar to the merge operation 
	 *           of merge-sort: we advance the pointer with the smaller value (in our case
	 *            the value represents time). On each iteration of the while loop we simply
	 *             check whether the current value of rooms required (cur) is the max we've
	 *              encountered so far. Sorry for the wall of text, I am not very good 
	 *              at explaining :) Let me know if you have any more questions.
	 */
	
	/*
	 * should be O(n^2) time complexity. And with heap we have O(nlogn) complexity. 
	 * The result reminds us that the fast solution on OJ doesn't necessarily mean 
	 * it has a better complexity.
	 */
	
	/*
	 * Map<Integer, Integer> map = new TreeMap<Integer, Integer>(); // Sort Key based on nature order
        for (Interval i : intervals) {
            if (map.containsKey(i.start)) {
                map.put(i.start, map.get(i.start)+1);
            } else {
                map.put(i.start, 1);
            }
            if (map.containsKey(i.end)) {
                map.put(i.end, map.get(i.end)-1);
            } else {
                map.put(i.end, -1);
            }
        }
        int maxRoom = 0; int curRoom = 0;
        for (int i : map.keySet()) {
            maxRoom = Math.max(maxRoom, curRoom += map.get(i));
        }
        return maxRoom;
	 */
	
	public int minMeetingRooms(Interval[] meetings) {
		// ÒÑAccepted
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
	
	public int meetingRoomII (int[][] meetings) {
		// 1. sort
		Arrays.sort(meetings, new Comparator<int[]> () {
			@Override
			public int compare(int[] front, int[] back) {
				return front[0] - back[0];
			}
		});
		// 2. schedule meetings
		PriorityQueue<Integer> heap = new PriorityQueue<>();
		for (int i = 0 ; i < meetings.length ; i ++) {
			if (heap.isEmpty()) {
				heap.offer(meetings[i][1]);
			} else {
				if (meetings[i][0] >= heap.peek()) {
					heap.poll();
					heap.offer(meetings[i][1]);
				} else {
					heap.offer(meetings[i][1]);
				}
			}
		}
		// 3. min nr of rooms is size of priority queue
		return heap.size();
	}
}
