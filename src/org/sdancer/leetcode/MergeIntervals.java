package org.sdancer.leetcode;
import java.util.*;

public class MergeIntervals {

	public static ArrayList<Interval> merge(ArrayList<Interval> intervals){
		if(intervals == null) return null;
		if(intervals.size() == 0 || intervals.size() ==1) return intervals;
		ArrayList<Interval> ret = new ArrayList<Interval>();
		
		Comparator<Interval> comparator = new Comparator<Interval>(){
			@Override
			public int compare(Interval a, Interval b) {
				if(a.start < b.start) return -1;
				if(a.start == b.start){
					if(a.end < b.end) return -1;
					else if(a.end == b.end) return 0;
					else
						return 1;
				}
				return 1;
			}
		};
		
		Collections.sort(intervals, comparator);
		int astart = intervals.get(0).start;
		int aend = intervals.get(0).end;
		int i=1;
		while(i<intervals.size()){
			int bstart = intervals.get(i).start;
			int bend = intervals.get(i).end;
			if(aend < bstart){
				ret.add(new Interval(astart,aend));
				astart = bstart;
				aend = bend;
			}
			else if(aend == bstart){
				aend = bstart;
			}
			else if(aend < bend){
				aend = bend;
			}
			i++;
		}
		ret.add(new Interval(astart,aend));
		return ret;
	}

	
	public  static class Interval{
		int start;
		int end;
		Interval(){
			start =0;
			end =0;
		}
		Interval(int s, int e){
			this.start = s;
			this.end = e;
		}
	}
	public static void test(){
		ArrayList<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(1,3));
		intervals.add(new Interval(2,6));
		intervals.add(new Interval(8,10));
		intervals.add(new Interval(15,18));
		intervals = merge(intervals);
		for(Interval interval:intervals){
			System.out.println(interval.start+"\t"+interval.end);
		}
	}
	public static void main(String[] args){
		test();
	}
}
