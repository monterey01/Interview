package com.anant.string;

public class RepeatString {

	public static void main(String[] args) {
		StringBuilder s = new StringBuilder();
		char c = 'x';
		int n = 201;
		int d = 0;

		while (s.length() != n) {
			++d;
			if (s.length() >= 1 && s.length() * 2 <= n) {

				s.append(s);
			}

			else {
				s.append(c);
			}
		}
		System.out.println(d);

		//System.out.println(uniquePathsWithObstacles(new int[3][3]));
		System.out.println(uniquePaths(3, 3));

	}

	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid.length == 0)
			return 0;
		int nr = obstacleGrid.length;
		int nc = obstacleGrid[0].length;

		int[][] memoization = new int[nr][nc];

		for (int i = 0; i < nr; i++) {
			for (int j = 0; j < nc; j++) {
				memoization[i][j] = -1;
			}
		}

		return uniquePathsWithObstacles(0, 0, obstacleGrid, memoization, new boolean[nr][nc]);
	}
	
	  public static int uniquePaths(int m, int n) {
		    int memo[][]=new int[m+1][n+1];
		        for(int i=0;i<m+1;i++){
		            for(int j=0;j<n+1;j++){
		                memo[i][j]=Integer.MIN_VALUE;
		            }
		        }
		        

		            
		        
		     return backTrack(m,n,1,1,memo);
		        
		   
		    }
		    
		    public static int backTrack(int endRow,int endCol,int row,int col,int[][] memo){
		        int result=0;
		   
		        
		        if(col>endCol) return 0;
		        if(row>endRow) return 0;
		        
		        if(col==endCol && row==endRow) return 1;
		        
		        if(memo[row][col]!=Integer.MIN_VALUE){
		            return memo[row][col];
		        }
		        
		        result+=backTrack(endRow,endCol,row,col+1,memo);
		        result+=backTrack(endRow,endCol,row+1,col,memo);
		        
		        memo[row][col]=result;
		        
		        return result;
		    }

	public static int uniquePathsWithObstacles(int cr, int cc, int[][] obstacleGrid, int[][] memoization,
			boolean[][] visited) {
		int result = 0;

		if (cr < 0 || cr >= obstacleGrid.length)
			return 0;
		if (cc < 0 || cc >= obstacleGrid[0].length)
			return 0;

		if (visited[cr][cc])
			return 0;

		if (obstacleGrid[cr][cc] == 1)
			return 0;


		if (cr == obstacleGrid.length - 1 && cc == obstacleGrid[cr].length - 1) {
			System.out.println(cr +","+ cc);
			System.out.println("hello");
			return 1;
		}

		if(memoization[cr][cc]!=-1) {
			return memoization[cr][cc];
		}
		
	
		result += uniquePathsWithObstacles(cr, cc + 1, obstacleGrid, memoization, visited);
		
		result += uniquePathsWithObstacles(cr + 1, cc, obstacleGrid, memoization, visited);
		//result += uniquePathsWithObstacles(cr - 1, cc, obstacleGrid, memoization, visited);
		//result += uniquePathsWithObstacles(cr, cc - 1, obstacleGrid, memoization, visited);
		

		
		memoization[cr][cc] = result;

		return result;
	}

}