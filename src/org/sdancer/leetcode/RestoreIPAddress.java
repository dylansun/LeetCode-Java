package org.sdancer.leetcode;
import java.util.*;
public class RestoreIPAddress {
	public static List<String> restoreIpAddresses(String s){
		ArrayList<String> result = new ArrayList<String>();
		for(int i=1; i<=s.length() -3; i++){
			for(int j=i+1; j<=s.length() -2; j++){
				for(int k=j+1; k<=s.length() -1; k++){
					//here i,j,k are the three dot position
					String ip1 = s.substring(0,i);
					String ip2 = s.substring(i,j);
					String ip3 = s.substring(j,k);
					String ip4 = s.substring(k,s.length());
					System.out.println(ip1+"\t"+ip2+"\t"+ip3+"\t"+ip4);
					if(ip1.length()>3 || ip2.length() >3 || ip3.length() >3||ip4.length()>3){continue;}
					if(!isValidIP(ip1)||!isValidIP(ip2)||!isValidIP(ip3)||!isValidIP(ip4)) continue;
					String tmpIP = ip1+"."+ip2+"."+ip3+"."+ip4;
					result.add(tmpIP);
				}
			}
		}
		
		return result;	
	}
	
	static boolean isValidIP(String s){
		if(s.charAt(0) == '0')
			return s.length() == 1;
		Integer i = Integer.parseInt(s);
		if(i>255) return false;
		return true;
	}
	
	public static void main(String[] args){
		String s="0000";
		System.out.println(restoreIpAddresses(s));
	}
}
