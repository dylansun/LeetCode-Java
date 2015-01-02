package org.sdancer.algorithm;
import java.util.*;
public class LongestMonoIncSub {
	ArrayList<ArrayList<Integer>> res;
	int[] num;
	int[] dp;
	int n;
	int max_length;
	ArrayList<Integer> max;
	ArrayList<Integer> min;
	LongestMonoIncSub(int[] num){
		this.num = num;
		this.max_length = 0;
		this.res = new ArrayList<>();
		this.n=num.length;
		this.dp = new int[n];
		Arrays.fill(dp, -1);
		calResDp();
		//reverseEachInRes();
		getMaxMin();
	}
	@SuppressWarnings("unused")
	private void reverseEachInRes(){
		for(ArrayList<Integer> x:res){
			for(int i=0; i<x.size()/2;i++){
				int tmp = x.get(i);
				x.set(i, x.get(x.size()-1-i));
				x.set(x.size()-1-i, tmp);
			}
		}
	}
	private void getMaxMin(){
		int index;
		int idxMax=0;
		int idxMin=0;
		int maxLen=res.get(0).size();
		int minLen=res.get(0).size();
		for(index=1; index<res.size();index++){
			if(res.get(index).size() > maxLen){
				idxMax = index;
				maxLen =res.get(index).size();
			}
			
			if(res.get(index).size() < minLen){
				idxMin = index;
				minLen =res.get(index).size();
			}
		}
		this.max = res.get(idxMax);
		this.min = res.get(idxMin);
		this.max_length = dp[n-1];
	}
	public int getMaxLength(){
		return this.max_length;
	}
	public ArrayList<Integer> getMax(){
		return this.max;
	}
	public ArrayList<Integer> getMin(){
		return this.min;
	}
	private void calResDp(){
		if(num==null || num.length ==0 ) return ;
		dp[0] = 1;
		ArrayList<Integer> first = new ArrayList<Integer>();
		first.add(num[0]);
		res.add(first);
		for(int i=1; i<n;i++){
			boolean smaller = true; 
			//go though each 
			for(ArrayList<Integer> lst:res){
				//num[i] is greater than the last element of previous
				if(num[i] >= lst.get(lst.size()-1) ){
					lst.add(num[i]);
					smaller = false;
					dp[i] = Math.max(dp[i], lst.size());
				}
			}
			if(smaller){
				ArrayList<Integer> tmp = new ArrayList<Integer>();
				
				for(int j=0;j<i; j++){
					if(num[i] > num[j]){
						boolean isdup = false;
						for(Integer k:tmp){
							if(k == num[j]){
								isdup = true;
							}
						}
						if(!isdup)
							tmp.add(num[j]);
					}
				}
				tmp.add(num[i]);
				res.add(tmp);
				dp[i] = Math.max(dp[i-1], tmp.size());
			}
		}
	}
	
	public static void main(String[] args){
		int[] num = {1,8,5,3,2,4,1,1,1,3};
		LongestMonoIncSub s = new LongestMonoIncSub(num);
		System.out.println("max length "+s.getMaxLength());
		for(Integer x:s.getMax()){
			System.out.print(x+"\t");
		}
		System.out.println();
		
		for(Integer x:s.getMin()){
			System.out.print(x+"\t");
		}
		System.out.println();
	}
	
}
