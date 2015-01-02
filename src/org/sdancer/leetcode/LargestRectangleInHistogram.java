package org.sdancer.leetcode;
import java.util.*;
public class LargestRectangleInHistogram {
	public static int largestRectangleArea(int[] height){
		// Initialize max area
		int max = 0;
		
		// Create an empty stack, The stack holds indexes of height[] array
		// The bars stored in stack are always in increasing order of their
		// heights
		Stack<Integer> s = new Stack<Integer>();
		
		// to store top of stack 
		int tp;
		
		// to store area with top bar as the smallest bar
		int area_with_top;
		
		// run through all bars of given histogram
		int i=0;
		while(i < height.length){
			if(s.isEmpty() || height[(int)s.peek()] <= height[i])
			{	
				s.push(i);
				i++;
			}
			// if this bar is lower that top of stack, then calculate area of rectanle
			// with stack top as the smallest (or minimum height) bar, 'i' is
			// 'right index' for the top and element before top in stack is 'left index'
			else{
				tp = (int)s.peek();// store the top index
				s.pop();// pop the top
				
				// calculate the area with height[t]] stack as smallest bar
				area_with_top = height[tp] * (s.isEmpty()?i:i-(int)s.peek() -1);
				
				// update max are, if needed
				if(max < area_with_top){
					max = area_with_top;
				}
			}
		}
		
		//Now pop the remaining bars from stack and calculate area with every
		//popped bar as the smallest bar
		while(!s.empty()){
			tp = (int)s.peek();
			s.pop();
			area_with_top = height[tp] * (s.empty()?i:i-(int)s.peek()-1);
		
			if(max < area_with_top){
				max = area_with_top;
			}
		}
		return max;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] height = {2,1,5,6,2,3};
		System.out.println( largestRectangleArea(height));
	}

}
