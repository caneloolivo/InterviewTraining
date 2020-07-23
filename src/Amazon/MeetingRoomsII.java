package Amazon;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRoomsII {
	
	public int minMeetingRooms(int[][] intervals) {
		if(intervals.length == 0 )
			return 0;
        int rooms = 1;
     // Sort the intervals by start time 
        Arrays.sort( intervals, new Comparator<int[]>() { 
        	public int compare(final int[] a, final int[] b) 
        	{ return a[0] - b[0]; } });
        int l = 0,r = intervals.length-1;
        while(l < r) {
        	if(intervals[l][1] > intervals[r][0] || intervals[l][0] == intervals[r][0]) {
        		rooms++;
        		r--;
        	}
        	else
        		l++;
        }
        return rooms;
    }
	
	public static void main(String[] args) {
		MeetingRoomsII solution = new MeetingRoomsII();
		int [][] intervals = {{1,5},{8,9},{8,9}};
		int rooms = solution.minMeetingRooms(intervals);
		System.out.println("Se necesitan "+ rooms +" salas");
	}
}
