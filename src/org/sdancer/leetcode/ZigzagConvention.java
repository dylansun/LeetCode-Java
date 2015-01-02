package org.sdancer.leetcode;

public class ZigzagConvention {
	/*
	
	 *    *    *     *
	 *  * *  * *   *
	 * *  * *  * *
	 *    *    *
	 
	 */
	private static int calColumn(String s, int nRows){
		int len = s.length();
		int column = 0;
		
		len = len - nRows;
		column = column + 1;
		
		int rep = (len)/(2*nRows - 2);
		int rest = (len)%(2*nRows - 2);
		
		column = column + rep*(nRows - 1) + ((rest >= (nRows - 1))?(nRows - 1):rest);
		return column;
	}
	
	public static String convert(String s, int nRows){
		int nColumns = calColumn(s, nRows);
		char[][]map = new char[nRows][nColumns];
		boolean down = true;
		int i=0;
		int j=0;
		for(int k=0; k<s.length();k++){
			if(down){
				map[i][j] = s.charAt(k);
				if(i == nRows - 1){
					down = false;i--;j++;
				}
				else{i++;}
			}
			else{
				map[i][j] = s.charAt(k);
				if(i == 0){
					down = true;i++;
				}
				else{
					i--;j++;
				}
			}
		}
		
		char[] result = new char[s.length()];
		int k =0;
		for( i = 0;  i< nRows ;i++){
			for(j=0; j< nColumns;j++){
				if(map[i][j] != '\0')
					result[k++] = map[i][j];
			}
		}
		return new String(result);
	}
	
	public static void printMatrix(char [][]matrix, int nRows, int nColumn){
		   for(int i=0; i< nRows;i++){
			   for(int j=0; j< nColumn; j++){
				   System.out.print(matrix[i][j]);
			   }
			   System.out.println();
		   }
		}
	
	public static void main(String[] args) {
		System.out.println(calColumn("PAYPALISHIRING",4));
		System.out.println(convert("PAYPALISHIRING",4));
		
		
	}
}
