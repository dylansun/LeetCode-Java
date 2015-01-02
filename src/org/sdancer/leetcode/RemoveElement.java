package org.sdancer.leetcode;

public class RemoveElement {
	public int removeElement(int[] A, int elem){
		int len = A.length;
		int found = 0;
		for(int i=0; i+found< len ;i++){
			while((i+found) < len && A[i+found] == elem){
				found++;
			}
			if(i+found < len)
				A[i] = A[i+found];
		}
		
		if(found !=0){
			A[len-found] = '\0';
		}
		
		return len - found;
	}
}
