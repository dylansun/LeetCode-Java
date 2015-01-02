package org.sdancer.leetcode;

import java.util.Stack;

public class PlusOne {
	public int[] plusOne(int[] digits){
		Stack<Integer> stack = new Stack<Integer>();
		int carry = 1;
		for(int i= digits.length -1; i >=0; i--){
			int sum = carry + digits[i];
			carry = sum / 10;
			sum = sum % 10;
			stack.push(sum);
		}
		if(carry > 0)
			stack.push(carry);
		int size = stack.size();
		int [] result = new int[size];
		for(int i=0; i < size ; i++){
			result[i] = stack.pop();
		}
		
		return result;
	}
}
