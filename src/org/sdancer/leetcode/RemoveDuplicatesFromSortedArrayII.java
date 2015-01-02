package org.sdancer.leetcode;

public class RemoveDuplicatesFromSortedArrayII {
	public static int removeDuplicates(int[] A) {
		int dup = 0;
		for(int i=2;i<A.length - dup;i++){
        	//we find 3 duplicates 
        	//count total number of duplicates and shift the array
        	if(A[i]==A[i-2]){
        		int count=1;
        		int j=i+1;
        		while(j<A.length-dup && A[j] == A[i]){
        			j++;
        			count++;
        		}
        		//shift the array 
        		for(int k=i;k<A.length - dup - count; k++){
        			A[k] = A[k+count];
        		}
        		dup = dup + count;
        	}
        }
		return A.length - dup;
    }
	
	public static void test(){
		int [] A = {1,1,1,1,1,1,1,1,2,2,2,2,2,2,3,4,4};
		int n = removeDuplicates(A);
		for(int i=0; i<n ;i++){
			System.out.println(A[i]);
		}
	}
	public static void main(String[] args){
		test();
	}
}
