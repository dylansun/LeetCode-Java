package org.sdancer.leetcode;
import java.util.*;
public class TextJustification {
	public static ArrayList<String> fullJustify(String[] words, int L){
		ArrayList<String> result = new ArrayList<String>();
		int index = 0;
		while(index < words.length){
			//calculate how many words should be added
			int count = 1;
			int currlen = words[index].length();
			while(currlen <= L && index+count < words.length){
				currlen = currlen + words[index+count].length() + 1; // at least one space
				count = count + 1;
			}
			//"this is an example" has too many characters
			//count = 4
			
			//If the current length is great then than L
			// then it shows that we still have some left
			if(currlen > L){
				//combine the count -1 words
				String tmp = combine(words, index, index+count-2,L);
				result.add(tmp);
				index = index + count -1;
			}
			//This deals the case that non words is left
			//so we just concatenate the rest
			else{
				String tmp = combineLast(words, index , words.length -1, L);
				result.add(tmp);
				break;
			}
		}
		return result;
	}
	
	public static String combineLast(String[] words, int begin, int end, int L){
		StringBuffer sb = new StringBuffer();
		sb.append(words[begin]);
		for(int i= begin+1; i<=end;i++){
			sb.append(" ");
			sb.append(words[i]);
		}
		while(sb.length() < L){
			sb.append(" ");
		}
		
		return new String(sb);
	}
	
	public static String combine(String[] words, int begin, int end, int L){
		if(end == begin){
			String result = words[begin];
			int sp = L - words[begin].length();
			String spaces = "";
			for(int i=0;i < sp; i++){
				spaces = spaces+ " ";
			}
			return result + spaces;
		}
		
		int len = 0;
		int n = end - begin +1;
		for(int i = begin; i <= end; i++ ){
			len = len + words[i].length();
		}
		int n_sp = L - len ;
		int avg = n_sp / (n-1);
		int rm = n_sp % (n-1);
		String []sp = new String[n-1];
		for(int i=0; i< n-1; i++){
			
			StringBuffer sb = new StringBuffer();
			int tm = avg;
			while(tm > 0){
				sb.append(" ");
				tm --;
			}
			sp[i] = new String(sb);
		}
		
		for(int i=0 ; i<rm ;i ++){
			sp[i] = sp[i]+" ";
		}
		
		StringBuffer result = new StringBuffer(words[begin]);
		for(int i=1; i < n ;i++)
		{
			result.append(sp[i-1]);
			result.append(words[begin+i]);
		}
		return new String(result);
	}
	public static void main(String[] args){
		//String [] words = {"This", "is", "an", "example", "of", "text", "justification."};
		String [] words = {"What","must","be","shall","be."};
		int L = 12;
		//System.out.println(combine(words,0,2,16));
		//System.out.println(combine(words,3,5,16));
		//System.out.println(combine(words,6,6,16));
		System.out.println(fullJustify(words, L));
	}
}
