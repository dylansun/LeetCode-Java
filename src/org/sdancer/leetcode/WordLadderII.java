package org.sdancer.leetcode;
import java.util.*;
public class WordLadderII {
	  public ArrayList<ArrayList<String>> findLadders(String start, String end, Set<String> dict) {
		  //
		  HashMap<String, Queue<String>> adjMap = new HashMap<String, Queue<String>>();
		  int currlen = 0;
		  boolean found = false;
		  
		  //result
		  ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		  
		  //Queue for BFS
		  Queue<String> queue = new LinkedList<String>();
		  
		  //unvisited words
		  Set<String> unVisited = new HashSet<String>(dict);	
		  
		  // check words visited during same level
		  Set<String> visitedThisLev = new HashSet<String>(); 
		  unVisited.add(end);
		  
		  queue.offer(start);
		  int currlev = 1;
		  int nextlev = 0;
		  
		  for(String word:unVisited){
			  adjMap.put(word, new LinkedList<String>());
		  }
		  
		  unVisited.remove(start);
		  
		  
		  //BFS
		  while(!queue.isEmpty()){
			  String currLadder = queue.poll();
			  //for all unvisited words that are one character change from current word
			  for(String nextLadder:getNextLadder(currLadder, unVisited)){
				  if(visitedThisLev.add(nextLadder)){
					  nextlev ++;
					  queue.offer(nextLadder);
				  }
				  adjMap.get(nextLadder).offer(currLadder);
				  if(nextLadder.equals(end)&&!found){
					  found = true;
					  currlen+=2;
				  }
			  }
			  
			  if(--currlev == 0){
				  if(found) break;
				  unVisited.removeAll(visitedThisLev);
				  currlev = nextlev;
				  nextlev = 0;
				  currlen ++;
			  }
		  }
		  
		  if(found){
			  LinkedList<String> path = new LinkedList<String>();
			  path.addFirst(end);
			  getLadders(start,end,path,result, adjMap,currlen);
		  }
		  return result;
	  }

	// DFS to get all possible path from start to end
	  private void getLadders(String start, String currLadder, LinkedList<String> p, ArrayList<ArrayList<String>> solu, 
	                          HashMap<String, Queue<String>> adjMap, int len){
	      if(currLadder.equals(start)){
	          solu.add(new ArrayList<String> (p));
	      }
	      else if(len > 0) {
	          Queue<String> adjs = adjMap.get(currLadder);
	          for(String lad : adjs){
	              p.addFirst(lad);
	              getLadders(start, lad, p, solu, adjMap, len-1);
	              p.removeFirst();
	          }
	      }
	  }
	  
	  /**
	   * return the strings next to current ladder in dictionary
	   * @param currLadder
	   * @param unVisited
	   * @return
	   */
	private ArrayList<String> getNextLadder(String currLadder, Set<String> unVisited) {
		// TODO Auto-generated method stub
		ArrayList<String> nextLadders = new ArrayList<String>();
		StringBuffer replace = new StringBuffer(currLadder);
		for(int i=0; i<currLadder.length();i++){
			char old = replace.charAt(i);
			for(char ch = 'a'; ch <= 'z'; ch++){
				replace.setCharAt(i, ch);
				String replaced = replace.toString();
				if(ch!=currLadder.charAt(i) && unVisited.contains(replaced)){
					nextLadders.add(replaced);
				}
			}
			replace.setCharAt(i, old);
		}
		return nextLadders;
	}
}
