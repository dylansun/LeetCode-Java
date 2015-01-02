package org.sdancer.util;
/**
 * @author Lili Sun
 * @author lili.sun.zju@gmail.com
 * This class handles range minimum query problem.
 * We implement it by using segment tree.
 * Pre-processing time is O(n) and time for range minimum query is
 * O(log n). The extra space required is O(n);
 * 
 * Representation of segment trees
 * 1. leaf nodes are the elements of the input array
 * 2. each internal node represents minimum of all leaves under it
 */
public class RangeMinQuery {
	int[] nums;
	RangeMinQuery(int[] nums){
		this.nums=nums;
	}
	
	/**
	 * Return the minimum from the start to end;
	 * @param start
	 * @param end
	 * @return
	 */
	public int rangeMinQuery(int start,int end){
		return 0;
	}
	
	/**
	 * A utility function to get the middle index from start to end
	 * @param start
	 * @param end
	 * @return
	 */
	@SuppressWarnings("unused")
	private int getMidIndex(int start, int end){
		return start + (end - start)/2;
	}
	
	class STNode{
		int start;
		int end;
		int val;
		STNode left;
		STNode right;
		STNode(){
			
		}
	}
}
