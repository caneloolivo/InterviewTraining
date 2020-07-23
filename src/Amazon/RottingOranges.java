package Amazon;

import java.util.ArrayDeque;
import java.util.Queue;

import Amazon.RottingOranges.Coordinates;

public class RottingOranges {
	public class Coordinates {
		int r, c;
		public Coordinates(int r, int c) {
			this.r = r; this.c = c;
		}
	}
	public int orangesRotting(int[][] grid) {
        int minutes = -1;
        int freshOranges = 0;
        int[][] dirs = {{1,0}, {0, 1}, {-1,0}, {0,-1}};
        Queue<Coordinates> queue = new ArrayDeque<>();
        for(int i = 0; i < grid.length; i++) {
        	for(int j = 0; j < grid[i].length; j++) {
        		if(grid[i][j] == 2)
        			queue.offer(new Coordinates(i, j));
        		else if(grid[i][j] == 1)
        			freshOranges ++;
        	}
        }
        while(!queue.isEmpty()) {
        	int size = queue.size();        	
        	while(size > 0) {
        		Coordinates p = queue.poll();
        		for(int[] dir: dirs) {
        			int r = dir[0] + p.r;
        			int c = dir[1] + p.c;
        			if(isOrange(grid, r, c)) {
        				grid[r][c] = 2;
        				queue.offer(new Coordinates(r, c));
        				freshOranges--;
        			}
        		}
        		size--;
        	}
        	minutes++;
        }
        if(freshOranges != 0)
        	return -1;
        return minutes == -1? minutes : 0;
    }
	public boolean isOrange(int[][] grid, int r, int c) {
		return (0 <= r && r < grid.length) &&
				(0 <= c && c < grid[0].length) &&
				(grid[r][c] == 1);
	}
	
	public static void main(String[] args) {
		RottingOranges solution = new RottingOranges();
		int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
		int time = solution.orangesRotting(grid);
		System.out.print("Se tarda en " + time);
	}
}
