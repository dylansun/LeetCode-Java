package org.sdancer.leetcode;

public class LongestCommonPrefix {
	String commonPrefix(String a, String b){
		if(a.length()== 0 || b.length() ==0)
			return "";
		int n = a.length();
		int m = b.length();
		int min = Math.min(m, n);
		int i = 0;
		while(i<min && a.charAt(i) == b.charAt(i) ){ i++;}			
		
		return a.substring(0, i);
	}
	public String longestCommonPrefix(String[] strs){
		int n = strs.length;
		if(n==0) return "";
		String ret = strs[0];
		if(n == 1) return ret;
		
		for(int i=1; i< n ; i++){
				ret = commonPrefix(strs[i],ret);
		}
		return ret;
	}
}
