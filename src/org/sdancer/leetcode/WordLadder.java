package org.sdancer.leetcode;

import java.util.*;

public class WordLadder {
	public static int ladderLength(String start, String end, HashSet<String> dict){
		if(start == null || end == null) return 0;
		HashMap<String, Integer> visited = new HashMap<String, Integer>();
		visited.put(start, 1);
		int size = start.length();
		String alph = "abcdefghijklmnopqrstuvwxyz";
		
		for(int i=0; i<size; i++){
			for(int j=0; j< 26; j++){
				String tmp = start.substring(0,i)+alph.substring(j,j+1)+start.substring(i+1,size);
				if(tmp.equals(end)){
					return 2;
				}
			}
		}
		
		//queue BFS
		Queue<String> queue = new LinkedList<String>();
		queue.offer(start);
		while(!queue.isEmpty()){
			String top = queue.poll();
			int step = visited.get(top);
			for(int i=0; i< size;i++){
				for(int j=0; j< 26; j++){
					String tmp = top.substring(0,i)+alph.substring(j,j+1)+top.substring(i+1,size);
					if(tmp.equals(end)){
						return step+1;
					}
					else if(dict.contains(tmp) && !visited.containsKey(tmp)){
						visited.put(tmp, step+1);
						queue.offer(tmp);
					}
				}
			}
		}
		
		return 0;
	}

	

	public static void main(String[] args){
		String start = "hit";
		String end= "dog";
		HashSet<String> dict = new HashSet<String>();
		dict.add("hit");
		dict.add("dog");
		dict.add("hot");
		dict.add("dot");
		dict.add("cat");
		System.out.println(ladderLength(start,end,dict));
	}
}
