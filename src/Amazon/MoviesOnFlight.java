package Amazon;

import java.util.Arrays;
import java.util.HashMap;

public class MoviesOnFlight {
	//60, 75, 85, 90, 120, 125, 150
	//90, 85, 75, 60, 120, 150, 125
	public int[] movies(int[] movies, int d){
		int [] result = new int[2];
		int time = d - 30;
		int minDif = Integer.MAX_VALUE;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i< movies.length; i++) {
			for(int key: map.keySet()) {
				if(key + movies[i] <= time && minDif >  time-(key +movies[i])) {
					minDif = time-(key +movies[i]);
					result[0] = key;
					result[1] = movies[i];
				}
			}
			map.put(movies[i], i);
		}
		return result;
	}
	
	public int[] movies2(int[] movies, int d){
		//60, 75, 85, 90, 120, 125, 150
		int [] result = new int[2];
		int time = d - 30;
		int sum = 0;
		int max = 0;
		Arrays.sort(movies);
		int l = 0; int r = movies.length-1;
		while(l < r) {
			sum = movies[l] + movies[r];
			if(sum <= time && sum > max ||					
			(Math.max(movies[l], movies[r]) > Math.max(result[0], result[1])
					&& sum == max)) {
				max = sum;
				result[0] = movies[l];
				result[1] = movies[r];
			}
			if(sum > time)
				r--;
			else
				l++;
		}
		return result;
	}
	
	public static void main(String[] args) {
		MoviesOnFlight solution = new MoviesOnFlight();
		//int [] movies = {90, 85, 75, 60, 120, 150, 125};
		int[] movies = { 90, 85, 75, 60, 155, 150, 125 };
		int d = 250;
		int [] result = solution.movies2(movies, d);
		for(int res: result) {
			System.out.println("pelicua " + res);
		}		
	}
}
