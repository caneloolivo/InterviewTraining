package Amazon;

import java.util.ArrayDeque;
import java.util.Queue;

public class ZombieInfection {
	public class Coordinates{
		int r, c;
		public Coordinates(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public int neededDaysForInfection(int[][] grid) {
		int days = -1;
		Queue<Coordinates> queue = new ArrayDeque<Coordinates>();
		int[][] dirs = {{1,0},{0, 1}, {-1,0},{0,-1}};
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j <grid[i].length; j++ ) {
				if(grid[i][j] == 1) {
					queue.offer(new Coordinates(i, j));
				}
			}
		}
		if(queue.isEmpty())
			return -1;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(size > 0) {
				Coordinates p = queue.poll();
				for(int[] dir : dirs) {
					int r = p.r + dir[0];
					int c = p.c + dir[1];
					if(isHuman(grid, r, c)) {
						grid[r][c] = 1;
						queue.offer(new Coordinates(r, c));
					}
				}
				size--;
			}
			days++;
		}
		
		return days;
	}
	
	public boolean isHuman(int[][] grid, int r, int c) {
		return (0 <= r && r < grid.length) &&
				(0 <= c && c < grid[0].length) &&
				grid[r][c] == 0;
	}
	
	public static void main(String[] args) {
		ZombieInfection infection = new ZombieInfection();
		int[][] grid = {{0, 1, 1, 0, 1},
		                  {0, 1, 0, 1, 0},
		                  {0, 0, 0, 0, 1},
		                  {0, 1, 0, 0, 0}};
		int days = infection.neededDaysForInfection(grid);
		System.out.println("Se necesitaron "+ days +" para que se comieran a los humanos");
	}
}
