package org.sdancer.leetcode;

public class ReverseInteger {
	public int reverse(int x){
		boolean neg = false;
		if(x< 0) {neg = true; x = -x;}
		long ret =0;
		while(x / 10 >= 1 ){
			ret = ret * 10 + x%10;
			x /= 10;
		}
		ret = ret * 10 + x;
		if(ret > Integer.MAX_VALUE) return 0;
		if(neg) return -(int)ret;
		return (int)ret;
	}
}
