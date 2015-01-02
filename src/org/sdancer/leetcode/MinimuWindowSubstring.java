package org.sdancer.leetcode;
import java.util.*;
/**
 * Solution to Minimu Window Substring 
 * Here includes a naive approac which got TLE, and without considering
 * repeat characters in T. And also an implementation of mike3' idea
 * Problem link: https://oj.leetcode.com/problems/minimum-window-substring/
 * Mike3 idea:   https://oj.leetcode.com/discuss/5469/is-the-length-of-t-considered-constant-or-m
 * @author Lili Sun
 *
 */
public class MinimuWindowSubstring {
	private static boolean debug = false;
	
	public static String minWindow(String S, String T) {

        if (S.length()==0||T.length()==0||S.length()<T.length()) return "";

        int left=T.length(),start=-1,end=S.length();

        Deque<Integer> queue= new LinkedList<Integer>();

        Map<Character,Integer> map= new HashMap<Character,Integer>();

        for (int i=0;i<T.length();i++){
            char c= T.charAt(i);
            map.put(c,map.containsKey(c)?map.get(c)+1:1);
        }

        for (int i =0;i<S.length();i++){
            char c= S.charAt(i);
            if (!map.containsKey(c))
                continue;

            int n = map.get(c);
            map.put(c,n-1);
            queue.add(i);
            if (n>0) left--;

            char head = S.charAt(queue.peek());
            while(map.get(head)<0){
                queue.poll();
                map.put(head,map.get(head)+1);
                head=S.charAt(queue.peek());
            }

            if (left==0){
                int new_length=queue.peekLast()-queue.peek()+1;
                if (new_length<end-start) {
                    start=queue.peek();
                    end=queue.peekLast()+1;
                } 
            }
        }
        if (left==0)  return S.substring(start,end);
        else return "";
    }
	public static String minWindow_naive(String S, String T){
		char[] s = S.toCharArray();
		char[] t = T.toCharArray();
		
		HashMap<Character,ArrayList<Integer>> map = new HashMap<Character,ArrayList<Integer>>();
		HashSet<Character> in = new HashSet<Character>();
		
		//record characters in t
		for(int i=0; i<t.length;i++){
			in.add(t[i]);
			map.put(t[i], new ArrayList<Integer>());
		}
		
		//step 1: go through s and record the position
		for(int i=0; i<s.length;i++){
			if(in.contains(s[i])){
				map.get(s[i]).add(i);
			}
		}
		
		if(debug)
		for(int i=0; i<t.length;i++){
			ArrayList<Integer> it = map.get(t[i]);
			System.out.print(t[i]+"index: ");
			for(int j=0;j<it.size();j++){
				System.out.print(it.get(j)+"\t");
			}
			System.out.println();
		}
		
		//find the character which has minimum number of elements
		int min=Integer.MAX_VALUE;
		int index = 0;
		for(int i=0; i<t.length;i++){
			if(map.get(t[i]).size()<min){
				min = map.get(t[i]).size();
				index = i;
			}
		}
		
		if(debug)
			System.out.println("Min: "+min+"\t character: "+t[index]);
		
		//if t[i] is not in s, return 
		if(min == 0) return "";
		
		
		//expand each character of t[index]
		//by finding the nearest character 
		String[] result = new String[min];
		for(int i=0; i<min;i++){
			int idx = map.get(t[index]).get(i);
			int index_min = idx;
			int index_max = idx;
			for(int j=0; j<t.length;j++){
				//skip t[index]
				if(j==index){
					continue;
				}
				else{
					
					//find the nearest t[j]
					int min_k = Integer.MAX_VALUE;
					int idx_k = -1;
					for(Integer k:map.get(t[j])){
						System.out.println(t[index]+"\t"+idx+"\t"+t[j]+"\t"+k);
						if(Math.abs(k-idx) < min_k){
							min_k = Math.abs(k-index);
							idx_k = k;
						}
					}
					
					//update index min and max
					index_min = Math.min(index_min, idx_k);
					index_max = Math.max(index_max, idx_k);
				}
			}
			result[i] = S.substring(index_min,index_max+1);
		}
		
		if(debug){
			System.out.print("Result: ");
			for(int i=0;i<result.length;i++){
				System.out.print(result[i]+"\t");
			}
		}
		
		int minResult = 0;
		for(int i=1;i<result.length;i++){
			if(result[i].length() < result[minResult].length()){
				minResult = i;
			}
		}
		
		return result[minResult];
	}
	public static void test(){
		String S = "ADOBECODEBANC";
		String T = "ABC";
		System.out.println(minWindow(S,T));
	}
	public static void main(String[] args){
		test();
	}
}
