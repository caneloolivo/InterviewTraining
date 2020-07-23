package Amazon;

public class BattleshipsInABoard {
	public int countBattleships(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int count = 0;
        boolean [] row = new boolean[m];
        boolean [] col = new boolean[n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++) {
            	if(board[i][j]=='X'){
                    if(!row[i] && !col[j]){
                        count++;           
                        row[i] = true;
                        col[j] = true;
                    }
                }
                else{
                    row[i] = false;
                    col[j] = false;
                }
            }
        }
        return count;
    }
	
	 public int countBattleships2(char[][] board) {
	        int m = board.length, n = board[0].length;
	        boolean[] row = new boolean[m];
	        boolean[] col = new boolean[n];
	        int count=0;
	        for(int i=0;i<m;i++){
	            for(int j=0;j<n;j++){
	                if(board[i][j]=='X'){
	                    if(!row[i] && !col[j]){
	                        count++;
	                        row[i]=true;
	                        col[j]=true;
	                    }
	                } else {
	                    row[i] = false;
	                    col[j] = false;
	                }
	            }
	        }
	        return count;
	    }
	
	public static void main(String[] args) {
		BattleshipsInABoard solution = new BattleshipsInABoard();
		char[][] board = {{'.','.','.'}};
		int result = solution.countBattleships(board);
		System.out.println("La cantidad de barcos " + result);
	}
}
