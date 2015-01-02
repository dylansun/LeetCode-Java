package org.sdancer.leetcode;

public class LargestRectangleInHist {
	public static int largestRectangleArea(int[] height){
		if(height==null||height.length==0) return 0;
		int len = height.length;
		
		return maxAreaBiPartition(0,len-1,height);
	}
	public static int maxAreaBiPartition(int start, int end, int[]height){
		if(start > end) return 0;
		if(start==end){
			return height[start];
		}
		if(start==end-1){
			return Math.min(height[start], height[end]) *2;
		}
		int mid = start+(end -start +1)/2;
		int max_mid = cal(mid,height);
		System.out.println("Mid index:"+mid+"\t value:"+max_mid);
		int left = maxAreaBiPartition(start,mid-1,height);
		int right =maxAreaBiPartition(mid+1,end,height);
		return Math.max(max_mid,Math.max(left, right));
	}
	public static int cal(int index, int[] height){
		
		int n = height[index];
		int max = 0;
		for(int i=n; i>=1;i--){
			int s=i*(countLeft(index,i,height) + 1 + countRight(index,i,height));
			if(s > max)
				max = s;
		}
		System.out.println("Function cal() index: "+index);
		System.out.println("Result:"+max);
		return max;
	}
	
	public static int countLeft(int index, int threshold, int[]height){
		int count = 0;
		for(int i=index-1; i>=0; i--){
			if(height[i] >= threshold)
				count++;
			else{
				break;
			}
		}
		return count;
	}
	
	public static int countRight(int index, int threshold, int[]height){
		int count = 0;
		for(int i=index+1; i<height.length; i++){
			if(height[i] >= threshold)
				count++;
			else
				break;
		}
		return count;
	}
	public static void main(String[] args){
		int[] height = {0,1,0,2,0,3,0};
		System.out.println(largestRectangleArea(height));
		//System.out.println(cal(3,height));
	}
}
