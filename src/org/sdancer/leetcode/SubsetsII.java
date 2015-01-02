package org.sdancer.leetcode;
import java.util.*;
public class SubsetsII {
	public static ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num){
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		result.add(new ArrayList<Integer>());
		Arrays.sort(num);
		for(int i=0; i< num.length ;){
			int count = 0;
			while(count + i < num.length && num[count + i] == num[i])
				count ++;
			int previousN = result.size();
			for(int k=0; k < previousN ; k++){
				ArrayList<Integer> instance = result.get(k);
				for(int j=0; j<count; j++){
					instance = new ArrayList<Integer>(instance);
					instance.add(num[i]);
					result.add(instance);
				}
			}
			i+= count;
		}
		return result;
	}
	
	public static void main(String[] args){
		int[] num = new int[2];
		num[0] = 1;
		num[1] = 2;
		System.out.println(subsetsWithDup(num));
	}
}
