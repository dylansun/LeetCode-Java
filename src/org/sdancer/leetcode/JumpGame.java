package org.sdancer.leetcode;

public class JumpGame {
	public static boolean canJump(int[] A){
		if(A==null)
			return false;
		boolean[] dp = new boolean[A.length];
		dp[0] = true;
		for(int i=1; i<A.length;i++){
			for(int j=i-1;j>=0;j--){
				if(dp[j]&&(A[j]+j >= i)){
					dp[i] = true;
					break;
				}
			}
			if(dp[i]==false)
				return false;
		}
		return dp[A.length-1];
	}
	public static boolean canJump(int index, int[] A){
		if(index >= A.length)
			return true;
		int n = A[index];
		for(int i=1; i<=n;i++){
			if(canJump(index+i,A))
				return true;
		}
		return false;
	}
	public static void test(){
		int [] A ={2,3,1,1,4};
		int [] B = {3,2,1,0,4};
		int [] C = {2,0,6,9,8,4,5,0,8,9,1,2,9,6,8,8,0,6,3,1,2,2,1,2,6,5,3,1,2,2,6,4,2,4,3,0,0,0,3,8,2,4,0,1,2,0,1,4,6,5,8,0,7,9,3,4,6,6,5,8,9,3,4,3,7,0,4,9,0,9,8,4,3,0,7,7,1,9,1,9,4,9,0,1,9,5,7,7,1,5,8,2,8,2,6,8,2,2,7,5,1,7,9,6};
		System.out.println(canJump(A));
		System.out.println(canJump(B));
		System.out.println(canJump(C));
	}
}
