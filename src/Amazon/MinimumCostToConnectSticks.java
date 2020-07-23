package Amazon;

import java.util.PriorityQueue;

public class MinimumCostToConnectSticks {
	public int connectSticks(int[] sticks) {
		int result = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int stick : sticks)
			pq.offer(stick);
		while(pq.size()>1) {
			int left = pq.poll();
			int right = pq.poll();
			result += left+right;
			pq.offer(left+right);
		}
		return result;
    }
}
