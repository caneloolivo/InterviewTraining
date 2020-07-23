package OA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MoviesInTheFlight {
	public class PairInt{
		int first;
		int second;
		public PairInt() {			
		}
		public PairInt(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}
	
	public PairInt moviesInFlight(int time, int movies, List<Integer> movieFlight) {
		PairInt result = new PairInt();
		int realTime = time;
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < movies; i++) {
			int tmpTime = realTime - movieFlight.get(i);
			if(map.containsKey(tmpTime)) {
				if(Math.max(result.first, result.second) < Math.max(tmpTime, movieFlight.get(i))) {
					result.first = map.get(tmpTime);
					result.second = i;
				}
			}
			map.put(movieFlight.get(i), i);
		}
		return result;
	}
	
	public static void main(String[] args) {
		MoviesInTheFlight solution = new MoviesInTheFlight();
		List<Integer> movieFlight = Arrays.asList(20,30,60,70,90,110);
		int movies = 6;
		int time = 110;
		PairInt result = solution.moviesInFlight(time, movies, movieFlight);
		System.out.println("Las peliculas son "+ result.first + ", "+ result.second);
	}
}
