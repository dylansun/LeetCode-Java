package dylansun.leetcode;

public class AddBinary {
	public String addBinary(String a, String b) {
		
		int m = a.length();
		int n = b.length();
		if(m >= n)
			return doAddBinary(a, b);
		else{
			return doAddBinary(b,a);
		}
    }
	private String doAddBinary(String l, String s){
		StringBuffer sb = new StringBuffer();
		int carry = 0;
		int m = l.length();
		int n = s.length();
		for(int i=0; i<m; i++){
			char lc = l.charAt(m-1-i);
			char sc = (i > n-1)? '0':s.charAt(n-1-i);
			int sum = lc - '0'  + sc - '0' + carry;
			if(sum == 2){
				sb.append("0");
				carry = 1;
			}
			else if(sum == 1){
				sb.append("1");
				carry = 0;
			}
			else if(sum == 3){
				sb.append("1");
				carry = 1;
			}
			else if(sum == 0){
				sb.append("0");
				carry = 0;
			}
			else{
				System.out.println("something wrong!");
			}
		}
		if(carry == 1){
			sb.append("1");
		}
		return sb.reverse().toString();
	}
	
	public static void main(String[] args){
		String a = "111111";
		String b = "1111111";
		AddBinary ab = new AddBinary();
		System.out.println(ab.addBinary(a, b));
	}
}
