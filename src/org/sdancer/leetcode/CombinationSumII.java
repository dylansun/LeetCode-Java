package org.sdancer.leetcode;
import java.util.*;

public class CombinationSumII {
	public static ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
	    Arrays.sort(num); 
	    return combinationSum(num,target,0);
	}
	 public static ArrayList<ArrayList<Integer>> combinationSum(int[] num, int target, int index){
	    ArrayList<ArrayList<Integer>> result=new ArrayList<>();
	    if(target<=0) return result; //all the numbers all positive..no need to check left has 0 or negitive number
	    int previouscheck=Integer.MIN_VALUE;
	    for(int i=index;i<num.length;i++){
	        if(previouscheck==num[i]) continue; // if the same value num[i] has been checked before..skip it
	        previouscheck=num[i];
	        if(num[i]>target) break; // all left are bigger than target..
	        if(num[i]==target){
	        	ArrayList<Integer> cur=new ArrayList<Integer>();
	            cur.add(num[i]);
	            result.add(cur);
	            return result;
	        }
	        ArrayList<ArrayList<Integer>> lastreturn=combinationSum(num,target-num[i],i+1);
	        if(!lastreturn.isEmpty()){
	            for(ArrayList<Integer> cur:lastreturn){
	                cur.add(0,num[i]);
	                result.add(cur);
	            }
	        }
	    }
	    return result;
	}
	 
	public static ArrayList<ArrayList<Integer>> combinationSum2_old(int [] num, int target){
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		if(num==null || num.length == 0	) return res;
		ArrayList<Integer> path = new ArrayList<>();
		Arrays.sort(num);
		for(int x:num){
			path.add(x);
		}
		combine(path, target,res);
		return res;
	}
	public static void  combine(ArrayList<Integer> list, int target, ArrayList<ArrayList<Integer>> res){
		int start = list.get(0);
		int sum = start;
		ArrayList<Integer> path = new ArrayList<>();
		path.add(0);
		//special case when meet target
		//just add it to result and stop
		if(sum == target)
		{
		    res.add(getPath(list,path));
		    return ;
		}
		for(int i=1;i<list.size();){
			sum += list.get(i);
			path.add(i);
			if(sum >= target){
				if(sum == target){
					res.add(getPath(list, path));
				}
				//update sum and remove last 2 element
				
				int last =  path.get(path.size()-1);
				path.remove(path.get(path.size()-1));
				int index = path.get(path.size()-1);
				path.remove(path.get(path.size()-1));
				sum = sum - list.get(last) - list.get(index);
				i = index + 1;
				
				if(path.size() == 0){
					//remove duplicates
					while(list.size()>0 && list.get(0) == start){
						list.remove(list.get(0));
					}
					if(list.size() >0 && list.get(0) <= target){
						combine(list,target,res);
						return ;
					}
				}
			}
			else{
				i = i+1;
			}
		}
	}
	
	public static ArrayList<Integer> getPath(ArrayList<Integer> list, ArrayList<Integer> path){
		ArrayList<Integer> res = new ArrayList<>();
		for(Integer x: path){
			res.add(list.get(x));
		}
		return res;
	}
	
	public static void main(String[] args){
		int [] num = {5,2,1,1,4,2,1};
		ArrayList<ArrayList<Integer>> res = combinationSum2(num, 4);
		for(ArrayList<Integer> x:res){
			for(Integer y:x){
				System.out.print(y+"\t");
			}
			System.out.println();
		}
	}
}
