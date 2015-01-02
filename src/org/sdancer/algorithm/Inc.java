package org.sdancer.algorithm;
import java.util.*;
public class Inc {
	private static final boolean debug = true;
	public static ArrayList<Integer> maxinc(int [] num){
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		int n = num.length;
		int [] dp = new int[n];
		Arrays.fill(dp, -1);
		dp[0] = 1;
		ArrayList<Integer> dp0 = new ArrayList<>();
		dp0.add(num[0]);
		res.add(dp0);
		for(int i=1; i< n ;i++){
			boolean smaller = true;
			for(ArrayList<Integer> x:res){
				if(x.get(x.size()-1) <= num[i]){
					x.add(num[i]);
					smaller = false;
					dp[i] = Math.max(dp[i], x.size());
				}
			}
			if(smaller){
				ArrayList<Integer> tmp = new ArrayList<>();
				for(int j=0; j<i;j++){
					if(num[i] > num[j]){
						tmp.add(num[j]);
					}
				}
				tmp.add(num[i]);
				res.add(tmp);
			}
		}
		int max = res.get(0).size();
		int index = 0;
		for(int i=1; i<res.size(); i++){
			if(res.get(i).size() > max){
				max = res.get(i).size();
				index = i;
			}
		}
		
		return res.get(index);
	}
	
	ArrayList<String> permute(String input){
		char[] ins = input.toCharArray();
		Arrays.sort(ins);
		String sorted = new String(ins);
		ArrayList<String> res = dopermute(sorted);
		return res;
	}

	ArrayList<String> dopermute(String input){
		ArrayList<String> res = new ArrayList<>();
		if(input.length() ==1)
		{
			res.add(input);
			return res;
		}
		for(int i=0; i< input.length();i++){
			char sel = input.charAt(i);
			String left ;
			left= input.substring(0,i)+ input.substring(i+1,input.length());
			
			if(debug){
				System.out.println("Selected char: " +sel);
				System.out.println("Left String: " + left);
			}
			
			ArrayList<String> tmp = dopermute(left);
			for(String s:tmp){
				res.add(sel + s);
			}
		}
		return res;
	}
	public static void main(String[] args){
		
		Inc inc = new Inc();
		ArrayList<String> res  = inc.permute("clearall");
		for(String s:res){
			System.out.println(s);
		}
	}
}
