package org.sdancer.leetcode;

public class ClimbingStairs {
	public static int climbStairs(int n){
		int [] dp = new int [n+1];
		dp[0] = 1;
		dp[1] = 1;
		if(n==1) return dp[1];
		dp[2] = dp[0] + dp[1];
		for(int i = 3; i<=n; i++){
			dp[i] = dp[i-1] + dp[i-2];
		}
		return dp[n];
	}
	
/*	public static void main(String[] args){
		System.out.println( climbStairs(1));
	}*/
	
}
