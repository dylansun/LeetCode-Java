package org.sdancer.leetcode;

import java.util.*;
public class PalindromePartitioning {
	public static boolean debug = true;

	public  static List<List<String>> partition(String s){
		List<List<String>> result = new ArrayList<List<String>>();
		//build dp table
		int n = s.length();
		boolean [][]dp = new boolean[n][n];
		
		//initial
		for(int i=0; i<n;i++){
			dp[i][i] = true;;
		}
		
		for(int k=0;k<n-1;k++)
		{
			for(int i= 0; i< n - k -1; i++){
				int j= i+ k + 1;
				if((s.charAt(i)== s.charAt(j))){
					
						if(i+1  > j -1){
							dp[i][j] = true;
						}
						else{
							if(i+1 < n && j-1 >0)
								dp[i][j] = dp[i+1][j-1]; 
						}
					}
			}
		}
		
		if(debug)
		{
			System.out.println("DP table");
			for(int i=0; i< n;i++){
				for(int j=0; j<n;j++){
					System.out.print(dp[i][j]+"\t");
				}
				System.out.println();
			}
		}
		
		ArrayList<String> path = new ArrayList<String>();
		bfs(s,dp,n,0,0, path,result);
		
		return result;
	}
	
	private static void bfs(String s,boolean[][] dp, int n,int layer,int position, ArrayList<String> path,List<List<String>> result){
		for(int i=position ; i< n; i++){
			
			if(dp[layer][i]){
				String sub = s.substring(layer, i+1);
				path.add(sub);
				if(debug){
					System.out.println("BFS position true: "+layer+ "\t"+i);
					System.out.println("palindrome=" + sub);	
					System.out.println("Current Path:"+path);
					
				}
				
				if(i == n-1){
					List<String> tmpPath = new ArrayList<String>(path);
					result.add(tmpPath);
					if(debug){
						System.out.println("layer: "+ layer);
						System.out.println("position: "+ position);
						System.out.println("Add path:" + tmpPath);
						System.out.println("After Result:"+result);
					}
				}
				else{
					if(debug){
						System.out.println("layer: "+ layer);
						System.out.println("position: "+ position);
						System.out.println("Perform BFS: layer= "+(position+1) +"\t position: "+(position+1));
					}
					bfs(s,dp,n,i+1, i+1,path,result);
				}
				//should remove the last
				path.remove(path.size()-1);
				if(debug){
					System.out.println("Path Removed:" + sub);
					System.out.println("Current Path:" + path);
				}
			}
		}
	}
	
/*	public static void main(String[] args){
		String s = "cbbbcc";
		List<List<String>> result = partition(s);
		for(List<String> i:result){
			for(String j:i){
				System.out.print(j+"\t");
			}
			System.out.println();
		}
	}*/
}
