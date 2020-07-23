package Nemesis;

import java.util.ArrayDeque;
import java.util.Queue;

public class NumberOfIslands {
	class Coordinates{
		int r, c;
		public Coordinates(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	public int numIslands(char[][] grid) {
		int count =0;
        int[][] dirs = {{1,0}, {0,1},{-1,0},{0,-1}};
        Queue<Coordinates> queque = new ArrayDeque<Coordinates>();
        for(int i = 0; i< grid.length; i++) {
        	for(int j = 0; j < grid[i].length; j++) {
        		if(grid[i][j] == '1') {
        			count ++;
        			grid[i][j] = '0';
        			queque.offer(new Coordinates(i, j));
        			while(!queque.isEmpty()) {
        				int size = queque.size();
        				Coordinates p = queque.poll();
        				while(size > 0) {
        					for(int[] dir: dirs) {
        						int r = p.r + dir[0];
        						int c = p.c + dir[1];
        						if(isLand(grid, r, c)) {
        							grid[r][c] = '0';
        							queque.offer(new Coordinates(r, c));
        						}
        					}
        					size--;
        				}
        			}        			
        		}
        	}
        }
        return count;
	}
	public boolean isLand(char[][] grid, int r, int c) {
		return (0 <= r && r<= grid.length-1) 
				&& (0<= c && c<=grid[0].length-1)
				&& (grid[r][c] == '1');
	}
	
	public static void main(String[] args) {
		NumberOfIslands solution = new NumberOfIslands();
//		char[][] grid = {
//				{'1','1','1','1','0'},
//				{'1','1','0','1', '0'},
//				{'1','1','0','0', '0'},
//				{'0','0','0','0', '0'}};
		
		char[][] grid = {
				{'1','1','0','0','0'},
				{'1','1','0','0','0'},
				{'0','0','1','0','0'},
				{'0','0','0','1','1'}
		};
		int island = solution.numIslands(grid);
		System.out.println("Cantidad: " + island);
	}
}
