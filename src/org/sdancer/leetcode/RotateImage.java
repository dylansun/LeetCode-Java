package org.sdancer.leetcode;
import java.util.*;
public class RotateImage {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
    	
    	ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(S==null||S.length == 0)
            return res;
        Arrays.sort(S);
        int size = (int)Math.pow(2, S.length);
        for(int i=0; i<size;i++){
        	res.add(new ArrayList<Integer>());
        }
        for(int i=0; i<S.length ;i++){
        	for(int j=0; j<size;j++){
        		if(((j>>i) & 1)==1){
        			res.get(j).add(S[i]);
        		}
        	}
        }
        return res;
    }
}
