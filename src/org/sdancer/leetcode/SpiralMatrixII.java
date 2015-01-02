package org.sdancer.leetcode;

import java.util.Arrays;

public class SpiralMatrixII {
	public static int[][] generateMatrix(int n){
		//OJ has a test case: 0 []
		if(n<=0) return new int[0][0];
		Point start = new Point(0,0);
		//right down left up
		Point[] step = {new Point(0,1), new Point(1,0), new Point(0,-1),new Point(-1,0)};
		int[][] res = new int[n][n];
		for(int[] i:res)
			Arrays.fill(i, 0);
		generate(res, n, start, 0 , step);
		return res;
	}
	
	public static void generate(int[][] res, int n,Point pos, int step_idx,Point[] step){
		for(int i = 1; i<=(n*n); i++){
			res[pos.x][pos.y] = i;
			//update pos
			pos = new Point(pos.x+step[step_idx].x, pos.y+step[step_idx].y);
			//update dir
			if(!isValid(res,n,pos,step[step_idx])){
				//if dir -> right
				step_idx = (step_idx + 1)%4;
			}
		}
	}
	
	private static boolean isValid(int[][]res, int n, Point pos, Point dir ){
		int x = pos.x + dir.x;
		int y = pos.y + dir.y;
		if(x<0 || x >n-1 || y < 0 || y > n-1 || res[x][y] >0){
			return false;
		}
		return true;
	}
	
	public static class Point{
		int x;
		int y;
		Point(int x,int y){
			this.x = x;
			this.y = y;
		}
	}
	public static void test(){
		int [][] matrix = generateMatrix(5);
		for(int[] x : matrix){
			for(int y:x){
				System.out.print(y+"\t");
			}
			System.out.println();
		}
	}
	public static void main(String[] args){
		test();
	}
}
