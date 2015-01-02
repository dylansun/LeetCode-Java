package org.sdancer.algorithm;

import java.util.Stack;

public class LongestCommonString {
String a;
String b;
String lcstr;
String lcseq;
	LongestCommonString(String a, String b){
		if(a.length() > b.length())
		{
		this.a = a;
		this.b = b;
		}
		else{
			this.a = b;
			this.b = a;
		}
		cal_lcstr();
		cal_lcseq();
	}
	private void cal_lcseq(){
		int m = a.length();
		int n = b.length();
		int [][] dp = new int[m+1][n+1];
		//Arrays.fill(dp, 0);
		for(int i=0; i< m ;i++){
			for(int j=0;j<n;j++){
				if(a.charAt(i) == b.charAt(j)){
					dp[i+1][j+1] = dp[i][j] + 1;
				}
				else{
					dp[i+1][j+1] = Math.max(dp[i+1][j],dp[i][j+1]);
				}
			}
		}
		for(int[] x:dp){
			for(int y:x){
				System.out.print(y + "\t");
			}
			System.out.println();
		}
		System.out.println("lenght of LCS= "+dp[a.length()][b.length()]);
		this.lcseq = "";
		Stack<Character> stack = new Stack<>();
		int aspotpos = m; 
		int bspotpos = n;
		while(aspotpos >0 && bspotpos > 0 ){
			if(a.charAt(aspotpos-1) == b.charAt(bspotpos-1)){
				stack.push(a.charAt(aspotpos-1));
				aspotpos--;
				bspotpos--;
			}
			else if(dp[aspotpos][bspotpos-1] >= dp[aspotpos-1][bspotpos]){
				bspotpos--;
			}
			else{
				aspotpos--;
			}
		}
		while(!stack.isEmpty()){
			this.lcseq = lcseq + stack.pop();
		}
	}
	private void cal_lcstr(){
		int n = a.length();
		int m = b.length();
		int [][] dp = new int [m][n];
		for(int i=0; i<m ;i++){
			for(int j=0; j< n;j++){
				if(b.charAt(i) == a.charAt(j)){
					if(i-1>=0 && j-1 >=0)
					{
						dp[i][j]=dp[i-1][j-1] + 1;
					}
					else
						dp[i][j] = 1 ;
				}
			}
		}
		
		
		for(int[] x:dp){
			for(int y:x){
				System.out.print(y + "\t");
			}
			System.out.println();
		}
		int max = dp[0][0];
		int idx_x = 0;
		int idx_y = 0;
		for(int i=0;i<m;i++ )
		for(int j=0;j<n;j++){
			if(dp[i][j]> max){
				max = dp[i][j];
				idx_x = i;
				idx_y = j;
			}
		}
		
		this.lcstr = a.substring(idx_y-dp[idx_x][idx_y]+1, idx_y+1);
	}
	
	public static void main(String[] args){
		LongestCommonString s = new LongestCommonString("GCTAfasdfsadfeeeeeeeeeeeeeeee","GBTAafsafeeeeeeeeeeee");
		System.out.println(s.lcstr);
		System.out.println(s.lcseq);
	}
}
