package dylansun.leetcode;

public class ContainerWithMostWater {
	public int maxArea(int[] height){
		
		return calculate(height);
	}
	private int calculate(int[] height){
		int res =0;
		int left =0;
		int right = height.length -1;
		while(left < right){
			//calculate the current region size
			int tmp = Math.min(height[left], height[right])*Math.abs(left - right);
			if(tmp > res){
				res = tmp;
			}
			int left_mark = left;
			int right_mark = right;
			//update left and right
			if(height[left] <= height[right]){
				while(height[left] <= height[left_mark] && left < right){
					left ++;
				}
			}
			else{
				while(height[right] <= height[right_mark] && left < right){
					right --;
				}
			}
			
		}
		return res;
	}
	
	@SuppressWarnings("unused")
	private int brute_force(int[] height){
		int res = 0;
		for(int i=0; i<height.length;i++){
			for(int j=i+1; j<height.length;j++){
				int tmp = Math.min(height[i], height[j]) * Math.abs(i-j);
				if(tmp > res){
					res = tmp;
				}
			}
		}
		return res;
	}
}
