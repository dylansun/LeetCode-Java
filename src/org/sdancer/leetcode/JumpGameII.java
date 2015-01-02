package org.sdancer.leetcode;
import java.util.Arrays;

public class JumpGameII {
	/**
	 * Block jumping
	 * Simulate the jumping game like jump from one block to another
	 * Each each time we find the max jump length 
	 * maintain the block begin and end index;
	 * @param A
	 * @return
	 */
	public static int jump(int[] A){
		if(A==null || A[0]==0 ||A.length==1) return 0;
		int begin = 1; 
		int end = A[0];
		int times = 1;
		while(end < A.length -1){
			int max =0;
			//find the max position it can reach
			for(int i=begin; i<=end;i++){
				if(max < i + A[i])
					max = i+A[i];
			}
			
			//update begin and end
			begin = end + 1;
			end = max ;
			times++;
		}
		return times;
	}
	
	/**
	 * DP still needs O(n^2) time
	 * @param A
	 * @return
	 */
	public static int jump_dp(int[] A){
		if(A==null) return 0;
		int[] dp = new int[A.length];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for(int i=1;i<A.length;i++){
			for(int j=i-1;j>=0;j--){
				if(dp[j]+A[j] >= i && dp[j]+1 < dp[i]){
					dp[i] = dp[j]+1;
				}
			}
			if(dp[i] == Integer.MAX_VALUE)
				return Integer.MAX_VALUE;
		}
		return dp[A.length-1];
	}
	public static void test(){
		int[] A = {2,3,0,1,4};
		int[] B = {1,2,3};
		System.out.println(jump(A));
		System.out.println(jump(B));
	}
	public static void main(String[] args){
		test();
	}
}
