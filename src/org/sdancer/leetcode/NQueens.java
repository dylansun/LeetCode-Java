package org.sdancer.leetcode;
import java.util.*;

public class NQueens {
	private static boolean debug = false;
	public static ArrayList<String[]> solveNQueens(int n){
		ArrayList<String[]> res = new  ArrayList<String[]>();
		//current path
		ArrayList<Integer> path = new ArrayList<Integer>();
		dfs(path,0,n,res);
		return res;
	}
	
	private static void dfs(ArrayList<Integer> path, int step, int n,ArrayList<String[]> res){
		if(debug){
			System.out.println("Debug info: step " + step +"\t");
			System.out.print("Current Path:");
			for(int i=0; i< path.size();i++){
				System.out.print(path.get(i)+"\t");
			}
			System.out.println();
			System.out.println();
		}
		for(int i=0; i<n;i++){
			//check if we can place a queen 
			//in this layer with i th position
			boolean conflict = false;
			for(int j=0; j< path.size();j++)
			{
				//check diagonal
				if(Math.abs(path.get(j) - i) == Math.abs(j - step))
				{
					conflict = true;
					break;
				}
				
				//check same column
				if(path.get(j) == i){
					conflict = true;
					break;
				}
			}
			
			//If we can't place the queen here
			if(conflict) 
				continue;
			else{
				path.add(i);
				if(debug){
					System.out.println("Add "+i+" to path");
					System.out.print("Current Path:");
					for(int k=0; k< path.size();k++){
						System.out.print(path.get(k)+"\t");
					}
					System.out.println();
				}
				//if we deal the last level
				//put the result to res
				if(step == n-1){
					if(debug){
						System.out.print("Found Path:");
						for(int k=0; k< path.size();k++){
							System.out.print(path.get(k)+"\t");
						}
						System.out.println();
					}
					res.add(buildGraph(path,n));
				}
				//dfs next layer
				else{
					dfs(path, step+1, n, res);
				}
				
				if(debug){
					System.out.println("remove "+path.get(path.size()-1)+" from path");
				}
				path.remove(path.get(path.size()-1));
				if(debug){
					System.out.print("Current Path:");
					for(int k=0; k< path.size();k++){
						System.out.print(path.get(k)+"\t");
					}
					System.out.println();
				}
			}
		}
	}
	
	/**
	 * build graph from path
	 * @param path current path
	 * @param n
	 * @return
	 */
	public static String[] buildGraph(ArrayList<Integer> path, int n){
		String[] graph = new String[n];
		char[] line = new char[n];
		for(int i=0; i<n ; i++){
			line[i] = '.';
		}
		for(int i=0;i<n;i++){
			line[path.get(i)] = 'Q';
			graph[i] = new String(line);
			line[path.get(i)] = '.';
		}
		return graph;
	}
	
	/**
	 * Simple Test for function build graph
	 */
	public static void testBuildGraph(){
		ArrayList<Integer> path = new ArrayList<Integer>();
		path.add(3);
		path.add(6);
		path.add(2);
		path.add(7);
		path.add(1);
		path.add(4);
		path.add(0);
		path.add(5);
		String[] res = buildGraph(path, 8);
		for(int i=0; i<res.length;i++){
			System.out.println(res[i]);
		}
	}
	public static void printRes(ArrayList<String[]> res){
		for(int i=0;i< res.size();i++){
			for(int j=0; j< res.get(i).length ;j++){
				System.out.println(res.get(i)[j]);
			}
		}
	}
	public static void main(String[] args){
		ArrayList<String[]> res = solveNQueens(4);
		printRes(res);
	}
}
