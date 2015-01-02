package org.sdancer.leetcode;
import java.util.*;
/**
 * Solution to insert interval
 * links https://oj.leetcode.com/problems/insert-interval/
 * @author Lili Sun
 *
 */
public class InsertInterval {
    public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> ret = new ArrayList<Interval>();
        int i=0;
        for(i=0; i<intervals.size();i++){
        	if(newInterval.start > intervals.get(i).end){
        		ret.add(intervals.get(i));
        	}
        	else if(newInterval.end < intervals.get(i).start){
        		ret.add( newInterval);
        		newInterval = intervals.get(i);
        	}
        	//Overlap, then the new Interval merge interval[i]
        	else{
        		newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
        		newInterval.end = Math.max(newInterval.end,intervals.get(i).end);
        	}
        }
        ret.add(newInterval);
        return ret;
    }
    

     public static class Interval {
    	 int start;
    	 int end;
    	 Interval() { start = 0; end = 0; }
    	 Interval(int s, int e) { start = s; end = e; }
     }
     
}
