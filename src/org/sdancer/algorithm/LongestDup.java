package org.sdancer.algorithm;
import java.util.*;
public class LongestDup {

	public static int expression(String exp){
		Stack<Integer> stack = new Stack<>();
		int n = exp.length();
		for(int i=0; i < n; i++){
			if(exp.charAt(i) <= '9' && exp.charAt(i)>='0'){
				System.out.println(exp.charAt(i) - '0');
				stack.push(exp.charAt(i)-'0');
			}
			else if(exp.charAt(i) == '*'){
				int a=stack.pop();
				int b = stack.pop();
				stack.push(a*b);
			}
			else if(exp.charAt(i)=='/'){
				int a = stack.pop();
				int b = stack.pop();
				stack.push(b/a);
			}
			else if(exp.charAt(i) == '+'){
				int a = stack.pop();
				int b = stack.pop();
				stack.push(a+b);
			}
			else if(exp.charAt(i) == '-'){
				int a = stack.pop();
				int b = stack.pop();
				stack.push(b-a);
			}
			else{
			}
		}
		if(stack.size() == 1)
			return stack.peek();
		else
			return 0;
	}
	public static String longestdup(String a){
		int n = a.length();
		String max = "";
		for(int i=0; i< n ;i++){
			for(int j=i+1; j<n;j++){
				//find first match
				if(a.charAt(i) == a.charAt(j)){
					int count = 1;
					while((j+count < n) &&a.charAt(i+count) == a.charAt(j+count)){
						count ++;
					}
					if(count > max.length()){
						max = a.substring(j,j+count);
					}
				}
			}
		}
		
		return max;
	}
	public static void main(String [] args){
		String a = "abcabc";
		String b = "abcbc";
		String c = "aaaaaaaaaaaaaaaaaaaaaaaaaa";
		System.out.println(longestdup(a));
		System.out.println(longestdup(b));
		System.out.println(longestdup(c));
	
		String exp = "18*2/4+1-";
		System.out.println(expression(exp));
	}
}
