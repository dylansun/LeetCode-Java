package org.sdancer.leetcode;
//I miss understood the problem zigzag convention.- -|||
//
public class MyConvetion {
	static boolean debug = true;
	private static int calColumn(String s, int nRows){
		 //Calculate the length of the matrix;
		   int len = s.length();
		   int n = 0;
		   //nRows is odd
		   if((nRows % 2) == 1 ){
			   int i= 1;
			   while(true)
			   {
				   int odd_sum = (nRows+1)/2 * (i+1)/2;
				   int even_sum = (nRows-1)/2 * i;
				   int size = odd_sum + even_sum;
				   if( size >= len){
					   break;
				   }
				   i = i+2;
			   }
			   n = i;
			   if(debug){
				   System.out.println(n);
			   }
		   }
		   //nRows is even
		   else{
			   int i= 1;
			   while(true)
			   {
				   int odd_sum = (nRows)/2 * (i+1)/2;
				   int even_sum = (nRows)/2 * i;
				   int size = odd_sum + even_sum;
				   if( size >= len){
					   break;
				   }
				   i = i+2;
			   }
			   n = i;
			   if(debug){
				   System.out.println(n);
			   }
		   }
		   return n;
	}
	public static String convert(String s, int nRows) {
	   int n= calColumn(s, nRows);
	   char[][]matrix = new char[nRows][n];
	   //Fit the matrix
   
	   for(int j=0, k=0; j<n;j++){
		   for(int i=0; i< nRows; i++){
			   //odd column
			   if((j+1)%2 == 1){
				   matrix[i][j] = (k<s.length())? s.charAt(k++):' ';
			   }
			   //even column 
			   else{
				   //odd row
				   if((i+1)%2 == 1){
					   matrix[i][j] = ' ';
				   }
				   else
					   matrix[i][j] = (k<s.length())?s.charAt(k++):' ';
			   }
		   }
	   }
	   if(debug)
	   printMatrix(matrix,nRows,n);
	   
	   String result = "";
	   
	   for(int i = 0; i < nRows ; i++){
		   for(int j=0; j < n; j++){
			   if(matrix[i][j] != ' '){
					   result = result + matrix[i][j];
				   }
			   }
		   }
	   
	   return result;
    }
	public static void printMatrix(char [][]matrix, int nRows, int nColumn){
	   for(int i=0; i< nRows;i++){
		   for(int j=0; j< nColumn; j++){
			   System.out.print(matrix[i][j]);
		   }
		   System.out.println();
	   }
	}
	public static void main(String[] args){
		String out = convert("ABC",2);
		System.out.println(out);
	}
}
