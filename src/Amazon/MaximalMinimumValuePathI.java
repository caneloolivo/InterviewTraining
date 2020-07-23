package Amazon;

import java.util.ArrayDeque;
import java.util.Queue;

public class MaximalMinimumValuePathI {
	public class Coordinates{
		int r, c;
		public Coordinates(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	public int maxMinValue(int[][] grid) {
		int m = grid.length; int n = grid[0].length;
		int[][] dp = new int[m][n];
		int[][] dirs = {{1,0}, {0,1}};
		Queue<Coordinates> queue = new ArrayDeque<Coordinates>();
		queue.offer(new Coordinates(0,0));
		while(!queue.isEmpty()) {
			Coordinates p = queue.poll();
			for(int[] dir: dirs) {
				int r = p.r + dir[0];
				int c = p.c + dir[1];
				if(isValid(r, c, m, n)) {
					int minValue = Math.min(dp[r][c], grid[p.r][p.c]);
					if(minValue > dp[r][c]) {
						dp[r][c] = minValue;
						queue.offer(new Coordinates(r, c));
					}
				}
			}			
		}
		return dp[m-1][n-1];		
	}
	
	public boolean isValid(int r, int c, int m, int n) {
		return (0 <= r && r < m ) && (0 <= c && c < n);
	}
}
