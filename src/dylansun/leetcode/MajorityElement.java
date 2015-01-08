package dylansun.leetcode;

import java.util.Arrays;

public class MajorityElement {
    public int majorityElement(int[] num) {
    	Arrays.sort(num);
    	return num[num.length / 2];
    }
}
