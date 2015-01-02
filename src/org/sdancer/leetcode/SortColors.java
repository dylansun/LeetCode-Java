package org.sdancer.leetcode;

import java.util.Arrays;

public class SortColors {
	public void sortColors(int[] A){
		if(A==null||A.length==0) return;
		int zeros=0;
		int ones=0;
		int twos=0;
		for(int i=0; i<A.length;i++){
			if(A[i] == 0)
				zeros++;
			else if(A[i]==1)
				ones++;
			else if(A[i]==2)
				twos++;
			else
				;
		}
		
		if(zeros >=1)
			Arrays.fill(A, 0, zeros, 0);
		if(ones >=1)
			Arrays.fill(A, zeros,zeros+ones,1);
		if(twos >=1)
			Arrays.fill(A, zeros+ones,zeros+ones+twos,2);
	}
}
