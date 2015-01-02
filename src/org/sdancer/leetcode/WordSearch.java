package org.sdancer.leetcode;

import java.util.ArrayList;

public class WordSearch {
    public static boolean exist(char[][] board, String word) {
        ArrayList<Point> path = new ArrayList<Point>();
        int row = board.length;
        int col = board[0].length;
        
        //find the start position
    	for(int i=0;i<row;i++){
    		for(int j=0; j<col;j++){
    			if(board[i][j] == word.charAt(0)){
    				if(word.length()==1)
    					return true;
    				else{
	    				path.add(new Point(i,j));
	    				if(search(path,1,board,row,col,word))
	    					return true;
	    				path.remove(path.get(path.size()-1));
    				}
    			}
    		}
    	}
        return false;
    }
    private static boolean search(ArrayList<Point> path, int step,char[][] board,int row,int col, String word){
    	Point last = path.get(path.size()-1);
    	int x=last.x;
    	int y=last.y;
    	Point[] delta = {new Point(1,0), new Point(0,1),new Point(-1,0),new Point(0,-1)};
    	for(Point p:delta){
    		int nx = x+p.x;
    		int ny = y+p.y;
    		if(isValid(nx,ny,row,col)&&!isInPath(nx,ny,path)&&board[nx][ny] == word.charAt(step)){
    			path.add(new Point(nx,ny));
    			if(path.size() == word.length()){
    				return true;
    			}
    			else{
    				if(search(path,step+1,board,row,col,word))
    					return true;
    			}
    			path.remove(path.get(path.size()-1));
    		}
    	}
    	
    	
    	return false;
    }
    private static boolean isValid(int x, int y, int row, int col){
    	return (x >= row || y >= col || x <0 || y <0)?false:true;
    }
    private static boolean isInPath(int x, int y, ArrayList<Point> path){
    	for(Point p:path){
    		if(p.x == x && p.y==y){
    			return true;
    		}
    	}
    	return false;
    }
    public static class Point{
    	public int x;
    	public int y;
    	Point(int x, int y){
    		this.x = x;
    		this.y = y;
    	}
    }
    public static void test(){
    	char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
    	System.out.println(board.length);
    	System.out.println(board[0].length);
    	System.out.println(exist(board,"ABCCED"));
    	System.out.println(exist(board,"SEE"));
    	System.out.println(exist(board,"ABCB"));
    }
}
