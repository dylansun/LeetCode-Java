package org.sdancer.leetcode;

import java.util.Arrays;

public class ScrambleString {
	public static boolean isScramble(String s1, String s2){
		if(s1.length() != s2.length() ) return false;
		if(s1.equals(s2)) return true;
		char[] ts1 = s1.toCharArray();
		char[] ts2 = s2.toCharArray();
		Arrays.sort(ts1);
		Arrays.sort(ts2);
		String ss1 = new String(ts1);
		String ss2 = new String(ts2);
		if(!ss1.equals(ss2))
			return false;
		for(int i=1; i < s1.length() ;i++){
			String seg11 = s1.substring(0,i);
			String seg12 = s1.substring(i);

			String seg21 = s2.substring(0,i);
			String seg22 = s2.substring(i);
			if(isScramble(seg11,seg21) && isScramble(seg12,seg22))
				return true;
			seg21 = s2.substring(s2.length() - i);
			seg22 = s2.substring(0,s2.length()-i);
			if(isScramble(seg11,seg21)&&isScramble(seg12,seg22))
				return true;
		}
		return false;
	}
	
	public static void main(String[] args){
		String s1 = "ABCDE";
		String s2 = "CAEBD";
		System.out.println(isScramble(s1,s2));
	}
}
