package org.sdancer.leetcode;

public class SearchInsert {
	public int searchInsert(int[] A, int target){
		int i = 0;
		for( ; i<A.length; i++){
			if(A[i] == target)
				return i;
			else if(A[i] > target)
				break;
		}
		return i;
	}
	public static void main(String[] args){
		SearchInsert s = new SearchInsert();
		int[] A = {1,3,5,6};
		System.out.println(s.searchInsert(A, 5));
		System.out.println(s.searchInsert(A, 2));
		System.out.println(s.searchInsert(A, 7));
		System.out.println(s.searchInsert(A, 0));
	}
}
