package org.sdancer.leetcode;
import java.util.*;


public class SpiralMatrix {
	public static ArrayList<Integer> spiralOrder(int[][] matrix){
		if(matrix == null||matrix.length==0 ||matrix[0].length ==0) 
			return new ArrayList<>();
		int row = matrix.length;
		int col = matrix[0].length;
		boolean[][] visited = new boolean[row][col];
		for(boolean[] x:visited){
			Arrays.fill(x, false);
		}
		ArrayList<Integer> res = new ArrayList<>();
		Point start = new Point(0,0);
		//right down left up
		Point[] step = {new Point(0,1), new Point(1,0), new Point(0,-1),new Point(-1,0)};
		int step_idx = 0;
		if(col==1)
			step_idx = 1;
		generate(matrix,res, visited, row,col, start, step_idx , step);
		return res;
	}
	
	
	public static void generate(int[][] matrix, ArrayList<Integer> res, boolean[][] visited, int row, int col, Point pos, int step_idx,Point[] step){
		for(int i = 1; i<=(row*col); i++){
			res.add(matrix[pos.x][pos.y]);
			visited[pos.x][pos.y] = true;
			//update pos
			pos = new Point(pos.x+step[step_idx].x, pos.y+step[step_idx].y);
			//update dir
			if(!isValid(visited,row,col,pos,step[step_idx])){
				//if dir -> right
				step_idx = (step_idx + 1)%4;
			}
		}
	}
	
	private static boolean isValid(boolean[][] visited, int row, int col, Point pos, Point dir ){
		int x = pos.x + dir.x;
		int y = pos.y + dir.y;
		if(x<0 || x >row-1 || y < 0 || y > col-1 || visited[x][y]){
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
		int[][] matrix = {{1},{2}};
		ArrayList<Integer> res = spiralOrder(matrix);
		for(Integer x:res){
			System.out.print(x+"\t");
		}
	}
	public static void main(String[] args){
		test();
	}
}
