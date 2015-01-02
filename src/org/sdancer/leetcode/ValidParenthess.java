package org.sdancer.leetcode;

import java.util.Stack;

public class ValidParenthess {
	public boolean isValid(String s){
		if(s.length() % 2 == 1) return false;
		if(s.length() == 0) return true;
		int len = s.length();
		Stack<Character> stack = new Stack<Character>(); 
		for(int i= 0; i<len;i++){
			if(stack.empty()){
				stack.push(new Character(s.charAt(i)));
			}
			else{
				Character c = stack.peek();
				if(s.charAt(i)=='('){
					if(c.charValue() == ')'){
						stack.pop();
					}
					else{
						stack.push(new Character(s.charAt(i)));
					}
				}
				else if(s.charAt(i)=='{'){
					if(c.charValue() == '}'){
						stack.pop();
					}
					else{
						stack.push(new Character(s.charAt(i)));
					}
				}
				else if(s.charAt(i)=='['){
					if(c.charValue() == ']'){
						stack.pop();
					}
					else{
						stack.push(new Character(s.charAt(i)));
					}
				}
				else{
					;
				}
			}
		}
		
		return stack.empty();
	}
}
