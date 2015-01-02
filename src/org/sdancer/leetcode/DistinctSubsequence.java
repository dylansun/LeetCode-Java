package org.sdancer.leetcode;

public class DistinctSubsequence {
	public int numDistinct(String S, String T){
		int m = T.length();
		int n = S.length();
		if(m > n ) return 0;
		int[][] path = new int[m+1][n+1];
		for(int k=0; k<=n; k++){ path[0][k] = 1;}
		for(int j=1; j<=n ;j++){
			for(int i=1; i<=m; i++){
				path[i][j] = path[i][j-1] + (T.charAt(i-1) == S.charAt(j-1) ? path[i-1][j-1] : 0 );
			}
		}
		return path[m][n];
	}
	
	public static void main(String[] args){
		DistinctSubsequence ds = new DistinctSubsequence();
		int count = ds.numDistinct("rabbbit", "rabbit");
		System.out.println(count);
	}
}
