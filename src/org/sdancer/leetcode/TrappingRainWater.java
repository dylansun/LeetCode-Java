package org.sdancer.leetcode;

public class TrappingRainWater {
	public int trap(int[] A){
		int n = A.length;
		if(n==0) return 0;
		int l=0;
		int r=n-1;
		int block = 0;
		int all = 0;
		int curlevel = 0;
		while(l < r){
			if(Math.min(A[l], A[r]) > curlevel){
				all += (Math.min(A[l],A[r]) - curlevel) * (r-l +1);
				curlevel = Math.min(A[l], A[r]);
			}
			if(A[l] < A[r]){
				block += A[l++];
			}
			else
			{
				block += A[r--];
			}
		}
		return all - block;
	}
}
