package Nemesis;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 
 * @author carlosolivo
 * You have a map that marks the location of a treasure island. 
 * Some of the map area has jagged rocks and dangerous reefs. 
 * Other areas are safe to sail in. 
 * There are other explorers trying to find the treasure. 
 * So you must figure out a shortest route to the treasure island.
 * 
 * Assume the map area is a two dimensional grid, 
 * represented by a matrix of characters. 
 * You must start from the top-left corner of the map and 
 * can move one block up, down, left or right at a time. 
 * The treasure island is marked as X in a block of the matrix. 
 * X will not be at the top-left corner. 
 * Any block with dangerous rocks or reefs will be marked as D. 
 * You must not enter dangerous blocks. You cannot leave the map area. 
 * Other areas O are safe to sail in. The top-left corner is always safe. 
 * Output the minimum number of steps to get to the treasure.
 * 	   0,1
 * 1,0 1,1 1,1
 * 	   2,1
 */    

public class TreasureIsland {
	private class Coordinate { 
		int r, c; 
		Coordinate(int r, int c) 
		{ this.r = r; this.c = c; } 
	} 
	public int treasureIsland(char[][] island) {
		int[][] dirs = { { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 } };
		Queue<Coordinate> colita = new ArrayDeque<Coordinate>();
		colita.offer(new Coordinate(0, 0));
		island[0][0] = 'D';
		for(int steps = 1; !colita.isEmpty(); steps++) {
			int size = colita.size();
			while (size > 0) {
				Coordinate p = colita.poll();
				for(int[] dir: dirs) {
					int r = p.r + dir[0];
					int c = p.c + dir[1];
					if(isSafe(island, r, c)) {
						if(island[r][c] == 'X')
							return steps;
						island[r][c] = 'D';
						colita.offer(new Coordinate(r, c));
					}
				}
				size--;
			}
		}
		return -1;
	}
	public boolean isSafe(char[][] position, int r, int c) {
		return (0 <= r && r <= position.length-1) && 
				(0 <= c && c <= position[0].length-1)
				&& (position[r][c] != 'D');
	}
	
	public static void main(String[] args) {
		TreasureIsland solution = new TreasureIsland();
		char[][] island = {
				{'O', 'O', 'O', 'O'},
				{'D', 'O', 'D', 'O'},
				{'O', 'O', 'O', 'O'},
				{'X', 'D', 'D', 'O'}};
		int steps = solution.treasureIsland(island);
		System.out.println("Tus pasos fueron " +steps);
	}
}
