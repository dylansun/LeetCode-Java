package org.sdancer.leetcode;

public class CountAndSay {
   	private String count(String in){
		if(in.length() == 0)
			return "";
		char first = in.charAt(0);
		int i=0;
		while(i<in.length() && in.charAt(i) == first){i++;}
		String tmp = Integer.toString(i)+first;
		return tmp + count(in.substring(i));
	}
	public String countAndSay(int n){
		if(n==0) return "";
		String[] result = new String[n];
		if(n==1) return "1";
        result[0] = "1";
		if(n>1){
			for(int i=1; i<n;i++){
				result[i] = count(result[i-1]);
			}
		}
		return result[n-1];
	}
}
