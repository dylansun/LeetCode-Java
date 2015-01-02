package org.sdancer.leetcode;

import java.util.HashSet;

public class ValidSudoku {
	private static boolean debug = true;
	private static boolean isDigit(char c){
		if( c>= '0' && c <= '9'){
			return true;
		}
		return false;
	}
	/**
	 * To check if any digit occurs twice
	 * @param board
	 * @param regionId
	 * @return
	 */
	private static boolean checkRegion(char[][] board, int regionId){
		int n = 3;
		int begin_rows = 0;
		int begin_cols = 0;
		
		int delta_rows = regionId / 3;
		int delta_cols = regionId % 3;
		
		begin_rows = begin_rows + 3*delta_rows;
		begin_cols = begin_cols + 3*delta_cols;
		
		//check 
		HashSet<Character> set = new HashSet<Character>(); 
		for(int i= begin_rows;i <begin_rows +n; i++ ){
			for(int j=begin_cols; j<begin_cols +n; j++){
				Character ch = new Character(board[i][j]);
				if(isDigit(ch)){
					if(set.contains(ch)){
						return false;
						}
					else{
						set.add(ch);
					}
				}
			}
		}
		
		if(debug){
			System.out.println("Check region: " + regionId);
			for(Character c:set){
				System.out.print(c+"\t");
			}
			System.out.println();
		}
		
		return true;
	}
	
	public static boolean isValidSudoku(char[][] board){
		int n=9;
		//check rows		 
		for(int i=0;i<n;i++){
			HashSet<Character> set = new HashSet<Character>();
			if(debug){
				System.out.println("Check row begin: row = " + i);
			}
			for(int j=0; j<n ; j++){
				Character ch = new Character(board[i][j]);
				if(isDigit(ch)){
					if(set.contains(ch)){
						return false;
						}
					else{
						set.add(ch);
					}
				}
			}
			if(debug){
				System.out.println("Check rows: " + i);
				for(Character c:set){
					System.out.print(c + "\t");
				}
				System.out.println();
			}
		}
		
		//check cols 
		for(int i=0;i<n;i++){
			HashSet<Character> set = new HashSet<Character>();
			for(int j=0; j<n ; j++){
				Character ch = new Character(board[j][i]);
				if(isDigit(ch)){
					if(set.contains(ch)){
						return false;
						}
					else{
						set.add(ch);
					}
				}
			}
			
			if(debug){
				System.out.println("Check cols: " + i);
				for(Character c:set){
					System.out.print(c + "\t");
				}
				System.out.println();
			}
		}
		
		//check regions
		for(int i=0; i < n; i++){
			if(!checkRegion(board, i)){
				return false;
			}
		}
		
		
		return true;
	}
	
/*	public static void main(String [] args){
		char[][] board = new char[9][9];
		board[0] = (new String(".87654321")).toCharArray();
		board[1] = (new String("2........")).toCharArray();
		board[2] = (new String("3........")).toCharArray();
		board[3] = (new String("4........")).toCharArray();
		board[4] = (new String("5........")).toCharArray();
		board[5] = (new String("6........")).toCharArray();
		board[6] = (new String("7........")).toCharArray();
		board[7] = (new String("8........")).toCharArray();
		board[8] = (new String("9........")).toCharArray();
		
		System.out.println(isValidSudoku(board));
		
	}*/
	
}
