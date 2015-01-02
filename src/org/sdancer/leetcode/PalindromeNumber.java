package org.sdancer.leetcode;

public class PalindromeNumber {
	public boolean isPalindrome(int x){
		if(x < 0) return false;
		int pal = 0;
		int input = x;
		while(x > 0){
			pal = pal * 10 + (x % 10);
			x = x / 10;
		}
		return pal == input;
	}
}
