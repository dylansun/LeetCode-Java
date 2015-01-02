package org.sdancer.leetcode;

public class MergeSortedArray {
	public static void merge(int A[], int m, int B[], int n){
	if(n==0) return ;
	if(m==0) {
	    for(int i=0; i< n;i++){
	        A[i] = B[i];
	    }
	    return;
	}
	int[] a = new int[m];
	for(int i=0; i < m; i++){
		a[i] = A[i];
	}
	int a_begin = 0;
	int b_begin = 0;
	int A_begin = 0;
	while(a_begin < m && b_begin < n)
	{
		A[A_begin++] = Math.min(a[a_begin], B[b_begin]);
		if(a[a_begin] < B[b_begin]){
			a_begin ++;
		}
		else{
			b_begin ++;
		}
	}
	if(a_begin == m){
		while(A_begin < m+n){
			A[A_begin++] = B[b_begin++];
		}
	}
	if(b_begin == n){
		while(A_begin < m+n){
			A[A_begin++] = a[a_begin++];
		}
	}
}

	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = new int[10];
		int B[] = {1};
		merge(A,0, B, 1);
		for(int i: A){
			System.out.println(i+"\t");
		}
	}*/

}
