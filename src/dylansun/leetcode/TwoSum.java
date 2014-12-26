package dylansun.leetcode;
import java.util.*;
public class TwoSum {
	/**
	 * Brute Force: TLE
	 * @param 
	 * @param target
	 * @return
	 */
    public int[] twoSum_1(int[] numbers, int target) {
		int [] res = new int[2];
        for(int i=0; i < numbers.length;i++){
        	for(int j=i+1; j< numbers.length; j++){
        		if(numbers[i] + numbers[j] == target){
        			res[0] = i;
        			res[1] = j;
        			return res;
        		}
        	}
        }
		return res;
    }
    
    public int[] twoSum(int[] numbers, int target){
    	int[] res = new int[2];
    	HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
    	for(int i=0; i<numbers.length;i++){
    		if(map.containsKey(target - numbers[i])){
    			res[0] = map.get(target-numbers[i]);
    			res[1] = i+1;
    			return res;
    		}else{
    			map.put(numbers[i], i+1);
    		}
    	}
    	return res;
    }
    
    public static void main(String [] args){
    	TwoSum s = new TwoSum();
    	int[] numbers = {3,2,4};
    	int target = 6;
    	int [] res = s.twoSum(numbers, target);
    	for(int x:res){
    		System.out.println(x+"\t");
    	}
    }
}
