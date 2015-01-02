package org.sdancer.leetcode;

import java.util.*;

public class MaximumSubarray {
/*	 Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

	 For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
	 the contiguous subarray [4,−1,2,1] has the largest sum = 6.

	 click to show more practice.
	 More practice:

	 If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
*/
	int maxSubArray(int[] num){
		if(num==null||num.length == 0)
			return 0;
		/**
		 * dp[i] records the maximum sub array include element num[i]
		 */
		int n = num.length;
		int [] dp = new int[n];
		Arrays.fill(dp, 0); 
		dp[0] = num[0];
		for(int i=1; i<n;i ++){
			dp[i] = Math.max(dp[i-1]+num[i], num[i]);
		}
		int max = Integer.MIN_VALUE;
		for(int x:dp){
			if(x > max)
				max = x;
		}
		return max;
	}
	
	public static void main(String[] args){
		MaximumSubarray s = new MaximumSubarray();
		int[] num = {-2,1,-3,4,-1,2,1,-5,4};
		int res = s.maxSubArray(num);
		System.out.println(res);
	}
}
