package org.sdancer.leetcode;

import java.util.*;

public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
	    List<List<Integer>> ret = new LinkedList<List<Integer>>();
	    Arrays.sort(candidates); // sort the candidates
	    // collect possible candidates from small to large to eliminate duplicates,
	    recurse(new ArrayList<Integer>(), target, candidates, 0, ret);
	    return ret;
	}

	// the index here means we are allowed to choose candidates from that index
	private void recurse(List<Integer> list, int target, int[] candidates, int index, List<List<Integer>> ret) {
	    if (target == 0) {
	        ret.add(list);
	        return;
	    }
	    for (int i = index; i < candidates.length; i++) {
	        int newTarget = target - candidates[i];
	        if (newTarget >= 0) {
	            List<Integer> copy = new ArrayList<Integer>(list);
	            copy.add(candidates[i]);
	            recurse(copy, newTarget, candidates, i, ret);
	        }
	    }
	} 
}
