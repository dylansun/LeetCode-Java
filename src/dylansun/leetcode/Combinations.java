package dylansun.leetcode;
import java.util.*;
public class Combinations {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    	ArrayList<Integer> cur = new ArrayList<Integer>();
    	docombine(n,k,res,cur);
    	return res;
    }
    
    private void docombine(int n, int k, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> cur){
    	int i =1;
    	if(cur.size() > 0){
    		i = cur.get(cur.size() - 1) + 1;
    	}
    	for(; i<=n; i++){
    		//if i in cur
    		if(in(i,cur)) continue;
    		
    		cur.add(i);
    		
    		//cur
    		if(cur.size() == k){
    			res.add(new ArrayList<Integer>(cur));
    		}
    		else{
    			docombine(n,k,res,cur);
    		}
    		
    		cur.remove(cur.size()-1);
    	}
    }
    
    private boolean in(int i, ArrayList<Integer> cur){
    	for(Integer x:cur){
    		if(i == x){
    			return true;
    		}
    	}
    	return false;
    }
    
    public static void main(String[] args){
    	int n = 4;
    	int k = 2;
    	Combinations c = new Combinations();
    	ArrayList<ArrayList<Integer>> res=c.combine(n, k);
    	for(ArrayList<Integer> x: res){
    		System.out.println(x);
    	}
    }
    
}
