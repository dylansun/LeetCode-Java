package org.sdancer.leetcode;

public class ValidPalindrome {
	public static boolean isPalindrome(String s){
		if(s.length() <=1) return true;
		int start = 0;
		int end = s.length()-1;
		String lower = s.toLowerCase();
		while(start <= end ){
			if(!isInRange(lower.charAt(start))){
				start++;
				continue;
			}
			if(!isInRange(lower.charAt(end))){
				end--;
				continue;
			}
			if(lower.charAt(start) == lower.charAt(end) ){
				start++;
				end--;
			}
			else{
				return false;
			}
			
		}
		
		return true;
	}
	
	private static boolean isInRange(char i){
	    if( (i<='z' && i >='a') || (i <= '9' && i>='0')){
	        return true;
	    }
	    
	    return false;
	}
	/*public static void main(String args[]){
		String s1= "A man, a plan, a canal: Panama" ;
		String s2= "race a car";
		boolean b1 = isPalindrome(s1);
		boolean b2 = isPalindrome(s2);
		System.out.println(b1);
		System.out.println(b2);
	}*/
}
