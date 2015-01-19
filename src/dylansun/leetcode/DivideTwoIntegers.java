package dylansun.leetcode;

public class DivideTwoIntegers {
	
	public int divide(int dividend, int divisor){
		long dividend_l = (long) dividend;
		long divisor_l = (long) divisor;
		int sign = (dividend > 0 && divisor > 0)
				|| (dividend < 0 && divisor < 0) ? 1 : -1;
		dividend_l = Math.abs(dividend_l);
		divisor_l = Math.abs(divisor_l);
		if (dividend_l < divisor_l) {
			return 0;
		}
		long div_base = divisor_l;
		long base = 1;
		while ((div_base << 1) <= dividend_l) {
			base <<= 1;
			div_base <<= 1;
		}
		long value = 0;
		while (dividend_l > 0 && div_base >= divisor_l) {
			if (dividend_l >= div_base) {
				value += base;
				dividend_l -= div_base;
			}
			base >>= 1;
			div_base >>= 1;
		}

		if (sign > 0) {
			return (int) Math.min(value, Integer.MAX_VALUE);
		} else {
			return (int) -value;
		}
	}
	
    public int divide_naive(int dividend, int divisor) {
        int flag = 1;
        if(dividend < 0 ){
        	flag *= -1;
        }
        if(divisor < 0){
        	flag *= -1;
        }
    	if(divisor == 0)
        	return flag * Integer.MAX_VALUE;
    	int result = 0;
    	int x = Math.abs(dividend);
    	int y = Math.abs(divisor);
    	while(x > y){
    		result ++;
    		x = x - y;
    	}
    	return flag * result;
    }
}
