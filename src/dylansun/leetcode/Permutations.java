package dylansun.leetcode;
import java.util.*;
public class Permutations {
    public ArrayList<ArrayList<Integer>> permute(int n, int k) {
    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    	ArrayList<Integer> cur = new ArrayList<Integer>();
    	dopermute(n,k,res,cur);
    	return res;
    }
    
    private void dopermute(int n, int k, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> cur){
    	for(int i=1; i<=n; i++){
    		//if i in cur
    		if(in(i,cur)) continue;
    		
    		cur.add(i);
    		
    		//cur
    		if(cur.size() == k){
    			res.add(new ArrayList<Integer>(cur));
    		}
    		else{
    			dopermute(n,k,res,cur);
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
    	int k = 3;
    	Permutations c = new Permutations();
    	ArrayList<ArrayList<Integer>> res=c.permute(n, k);
    	for(ArrayList<Integer> x: res){
    		System.out.println(x);
    	}
    }
    
}
