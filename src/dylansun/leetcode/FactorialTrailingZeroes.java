package dylansun.leetcode;

public class FactorialTrailingZeroes {
	
	public int trailingZeroes(int n){
		int count = 0;
		while(n > 0){
			count += n / 5;
			n = n / 5;
		}
		return count;
	}
    public int trailingZeroes_naive(int n) {
    	int count = 0;
    	for(int i = 1; i<=n ; i++){
    		int tmp = i;
    		while(tmp % 5 == 0){
    			count ++;
    			tmp = tmp / 5;
    		}
    	}
    	return count;
    }
    public static void main(String[] args){
    	FactorialTrailingZeroes s = new FactorialTrailingZeroes();
    	for(int i=1; i<= 100; i++){
    		System.out.println(i+" "+s.trailingZeroes(i));
    	}
    }
}
