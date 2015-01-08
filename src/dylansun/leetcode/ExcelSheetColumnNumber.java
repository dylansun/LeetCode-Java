package dylansun.leetcode;

public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int dic_size = 26;
        char[] sch = s.toCharArray();
        int n = s.length();
        int res = 0;
        for(int i=0; i<n;i++){
        	res += (sch[n-1-i] - 'A' + 1) * Math.pow(dic_size,i);
        }
        return res;
    }
    public static void main(String[] args){
    	ExcelSheetColumnNumber s = new ExcelSheetColumnNumber();
    	System.out.println(s.titleToNumber("AB"));
    }
}
