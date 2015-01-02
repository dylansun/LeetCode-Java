package org.sdancer.leetcode;
import java.util.ArrayList;

public class PermutationSequence {
	public static String getPermutation(int n, int k){
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for(int i=1;i<=n;i++){
			nums.add(i);
		}
		
		return permute(nums,n,k-1);
	}
	public static String permute(ArrayList<Integer> nums,int n,int k){
		if(n==1)
			return nums.get(0).toString();
		int index = k / fractor(n-1);
		k = k % fractor(n-1);
		String ch = nums.get(index).toString();
		nums.remove(index);
		return ch+permute(nums,n-1,k);
	}
	static int fractor(int n){
		if(n==0 || n==1)
			return 1;
		else
			return n*fractor(n-1);
		
	}
	public static void main(String[] args){
		System.out.println(getPermutation(3,1));
		System.out.println(getPermutation(3,2));
		System.out.println(getPermutation(3,3));
		System.out.println(getPermutation(3,4));
		System.out.println(getPermutation(3,5));
		System.out.println(getPermutation(3,6));
	}
}
