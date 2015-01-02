package org.sdancer.leetcode;

public class StringToIntegerATOI {
	private boolean isDigit(char x){
		if(x>='0' && x<= '9'){
			return true;
		}
		
		return false;
	}
	public int atoi(String str){
		if(str == null || str.length() ==0 ){
			return 0;
		}
		boolean neg = false;
		boolean sign = false;
		if(str.charAt(0) == '-'){
			neg = true;
			sign = true;
		}
		
		if(str.charAt(0) == '+'){
			sign = true;
		}
		long ret =0;
		int begin = 0;
		if(sign){begin++;}
		while(begin < str.length()){
			if(!isDigit(str.charAt(begin)) )
				break;
			ret = ret*10 + (str.charAt(begin)-'0');
		}
		
		if(ret >= Integer.MAX_VALUE && !neg) return Integer.MAX_VALUE;
		if(ret >= Integer.MAX_VALUE && neg) return Integer.MIN_VALUE;
		if(neg) return -(int)ret;
		return (int)ret;
	}
}
