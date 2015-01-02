package org.sdancer.leetcode;
import java.util.*;
public class GenerateParentheses {
	public ArrayList<String> generateParenthesis(int n){
		ArrayList<String> list = new ArrayList<>();
		Stack<String> stack = new Stack<>();
		Stack<Integer> validationStack = new Stack<>();
		stack.push("(");
		validationStack.push(0);
		while(stack.size() != 0){
			String s = stack.pop();
			int v = validationStack.pop();
			if(s.length() == n * 2){
				list.add(s);
				continue;
			}
			if(s.length() - v < n){
				stack.push(s + "(");
				validationStack.push(v);
			}
			if(2 * v < s.length()){
				stack.push(s+")");
				validationStack.push(v+1);
			}
		}
		return list;
	}

	
	public static void main(String[] args){
		GenerateParentheses s = new GenerateParentheses();
		for(int i=1; i<= 4;i ++){
			ArrayList<String> k = s.generateParenthesis(i);
			System.out.println("=========="+"Step " + i +"=========");
			System.out.println("Size : " + k.size());
			for(String x:k){
				
				System.out.println(x);
			}
		}
	}
}
