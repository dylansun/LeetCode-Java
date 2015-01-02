package org.sdancer.leetcode;

public class ImplementStrStr {
	private boolean compare(char[] hay, int beginIndex, char[] nee,int len){
		for(int i=0; i< len ;i++){
			if(hay[beginIndex+i] != nee[i]){
				return false;
			}
		}
		return true;
	}
	public String strStr(String haystack, String needle){
		if(needle == ""){return haystack;}
		if(haystack == ""){return null;}
		if(haystack.length() < needle.length() ){return null;}
		char[] hay = haystack.toCharArray();
		char[] nee = needle.toCharArray();
		int len = needle.length();
		
		boolean found = false;
		int beginIndex=0;
		for(int i=0; i< haystack.length() - len +1; i++){
			if(compare(hay,i,nee,len)){
				found = true;
				beginIndex = i;
				break;
			}
		}
		if(!found){
			return null;
		}
		return haystack.substring(beginIndex);
	}
}
