package org.sdancer.leetcode;
import java.util.*;


public class PascalTriangle {

    public static List<List<Integer>> generate(int numRows) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	if(numRows == 0){
    		return result;
    	}
    	
    	
		List<Integer> level1 = new ArrayList<Integer>();
		level1.add(1);
		result.add(level1);
		
		if(numRows == 1){
			return result;
		}
    	
		
		List<Integer> level2 = new ArrayList<Integer>();
		level2.add(1);
		level2.add(1);		
		result.add(level2);
    	
		if(numRows == 2){
			return result;
		}
    	
		for(int i = 3; i<=numRows ; i++){
			List<Integer> level_n = new ArrayList<Integer>();
			List<Integer> previous = result.get(i-2);
			int len = i-1;
			level_n.add(1);
			for(int j=1; j < len; j++ ){
				int next = previous.get(j-1)+previous.get(j);
				level_n.add(next);
			}
			level_n.add(1);
			result.add(level_n);
		}
    	
    	
		return result;
    }
	/*
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int layer = 5;
		List<List<Integer>> result = generate(5);
		for(List<Integer> i:result){
			for(Integer j:i){
				System.out.println(j+"\t");
			}
			System.out.println();
		}
	}
*/
}
