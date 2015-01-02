package org.sdancer.algorithm;

public class LCS {
	 String first;
	 String second;
	 String constrained;
	 String lcs;
	 String clcs;
	 public LCS(String m, String n) {
	  this.first = m;
	  this.second = n;
	  this.constrained = "";
	  lcs = this.calculateLCS(m, n);
	  check();
	 }
	 public LCS(String m, String n, String constrained) {
	  this.first = m;
	  this.second = n;
	  this.constrained = constrained;
	  lcs = this.calculateLCS(m, n);
	  clcs = this.calculateCLCS(m, n, constrained);
	  check();
	 }
	 
	 private void check() {
		/* boolean e1 = first.matches("[a-zA-Z]*");
		 boolean e2 = second.matches("[a-zA-Z]*");
		 boolean e3 = constrained.matches("[a-zA-Z]*");
		 String errmsg_clcs = "Error in string " + ((!e1)?"1":"")+ ((!e2)?"2":"")+ ((!e1)?"3":"");
		 String errmsg_lcs = "Error in string " + ((!e1)?"1":"")+ ((!e2)?"2":"");
		 if(e1||e2||e3){
			 this.setClcs(errmsg_clcs);
			 this.setLcs(errmsg_lcs);
		 }*/
	  if (!first.matches("[a-zA-Z]*") && !second.matches("[a-zA-Z]*")
	    && !constrained.matches("[a-zA-Z]*")) {
	   this.setClcs("error in string 1,2,3");
	   this.setLcs("error in string 1,2");
	  } else if (first.matches("[a-zA-Z]*") && !second.matches("[a-zA-Z]*")
	    && !constrained.matches("[a-zA-Z]*")) {
	   this.setClcs("error in string 2,3");
	   this.setLcs("error in string 2");
	  } else if (!first.matches("[a-zA-Z]*") && second.matches("[a-zA-Z]*")
	    && !constrained.matches("[a-zA-Z]*")) {
	   this.setClcs("error in string 1,3");
	   this.setLcs("error in string 1");
	  } else if (first.matches("[a-zA-Z]*") && second.matches("[a-zA-Z]*")
	    && !constrained.matches("[a-zA-Z]*")) {
	   this.setClcs("error in string 3");
	  } else if (!first.matches("[a-zA-Z]*") && !second.matches("[a-zA-Z]*")
	    && constrained.matches("[a-zA-Z]*")) {
	   this.setClcs("error in string 1,2");
	   this.setLcs("error in string 1,2");
	  } else if (!first.matches("[a-zA-Z]*") && second.matches("[a-zA-Z]*")
	    && constrained.matches("[a-zA-Z]*")) {
	   this.setClcs("error in string 1");
	   this.setLcs("error in string 1");
	  } else if (first.matches("[a-zA-Z]*") && !second.matches("[a-zA-Z]*")
	    && constrained.matches("[a-zA-Z]*")) {
	   this.setClcs("error in string 2");
	   this.setLcs("error in string 2");
	  } else {
	   ;
	  }
	 }
	 
	 public String calculateLCS(String m, String n) {
	  String lcs_str = "";
	  if (m.length() == 0 || n.length() == 0)
	   return "";
	  int len_m = m.length();
	  int len_n = n.length();
	  int max_len = Math.max(m.length(), n.length());
	  int[] left = new int[max_len + 1];
	  int[] right = new int[max_len + 1];
	  for (int i = 0; i <= max_len; i++) {
	   left[i] = 0;
	   right[i] = 0;
	  }
	  for (int i = 1; i <= len_m; i++) {
	   for (int j = 1; j <= len_n; j++) {
	    if (m.charAt(i - 1) == (n.charAt(j - 1))) {
	     right[j] = left[j - 1] + 1;
	    } else {
	     if (right[j - 1] >= left[j])
	      right[j] = right[j - 1];
	     else
	      right[j] = left[j];
	    }
	   }
	   @SuppressWarnings("unused")
	   int[] tmp = new int[max_len];
	   tmp = left;
	   left = right;
	   right = left;
	  }
	  if (m.charAt(len_m - 1) == n.charAt(len_n - 1)) {
	   char tmp_char = m.charAt(len_m - 1);
	   m = m.substring(0, m.length() - 1);
	   n = n.substring(0, n.length() - 1);
	   lcs_str = this.calculateLCS(m, n) + tmp_char;
	  } else if (left[len_n] == right[len_n]
	    && left[len_n - 1] < right[len_n]) {
	   m = m.substring(0, m.length() - 1);
	   lcs_str = this.calculateLCS(m, n);
	  } else if (left[len_n] == right[len_n - 1]
	    && left[len_n - 1] >= right[len_n]) {
	   n = n.substring(0, n.length() - 1);
	   lcs_str = this.calculateLCS(m, n);
	  }
	  return lcs_str;
	 }
	 
	 private String calculateCLCS(String a, String b, String c) {
	  String clcs_str = "";
	  int n = a.length();
	  int m = b.length();
	  int r = c.length();
	  int[][][] L = new int[n + 1][m + 1][r + 1];
	  
	  for (int i = 0; i < n + 1; i++)
	   L[i][0][0] = 0;
	  for (int j = 0; j < m + 1; j++)
	   L[0][j][0] = 0;
	  for (int j = 0; j < m + 1; j++)
	   for (int k = 1; k < r + 1; k++)
	    L[0][j][k] = Integer.MIN_VALUE;
	  for (int i = 0; i < n + 1; i++)
	   for (int k = 1; k < r + 1; k++)
	    L[i][0][k] = Integer.MIN_VALUE;
	  for (int i = 1; i < n + 1; i++)
	   for (int j = 1; j < m + 1; j++) {
	    L[i][j][0] = this.calculateLCS(a.substring(0, i),
	      b.substring(0, j)).length();
	   }
	  
	  for (int i = 1; i < n + 1; i++)
	   for (int j = 1; j < m + 1; j++)
	    for (int k = 1; k < r + 1; k++) {
	     if (a.charAt(i - 1) == b.charAt(j - 1)
	       && a.charAt(i - 1) == c.charAt(k - 1))
	      L[i][j][k] = L[i - 1][j - 1][k - 1] + 1;
	     else if (a.charAt(i - 1) == b.charAt(j - 1)
	       && a.charAt(i - 1) != c.charAt(k - 1))
	      L[i][j][k] = L[i - 1][j - 1][k] + 1;
	     else if (a.charAt(i - 1) != b.charAt(j - 1))
	      L[i][j][k] = Math.max(L[i][j - 1][k], L[i - 1][j][k]);
	     else
	      ;
	    }
	  for (int i = 0; i < n + 1; i++)
	   for (int j = 0; j < m + 1; j++) {
	    for (int k = 0; k < r + 1; k++) {
	     System.out.print("L[" + i + "][" + j + "][" + k + "]"
	       + L[i][j][k]);
	    }
	    System.out.println();
	   }
	  if (L[n][m][r] < 0)
	   clcs_str = "";
	  else {
	   int k = r;
	   int i = n;
	   int j = m;
	   while (i > 0 && j > 0) {
	    if (k > 0 && a.charAt(i - 1) == b.charAt(j - 1)
	      && a.charAt(i - 1) == c.charAt(k - 1)
	      && L[i][j][k] == L[i - 1][j - 1][k - 1] + 1) {
	     clcs_str = a.charAt(i - 1) + clcs_str;
	     i--;
	     j--;
	     k--;
	    } else if (a.charAt(i - 1) == b.charAt(j - 1)
	      && L[i][j][k] == L[i - 1][j - 1][k] + 1) {
	     clcs_str = a.charAt(i - 1) + clcs_str;
	     i--;
	     j--;
	    } else if (a.charAt(i - 1) != b.charAt(j - 1)
	      && L[i][j][k] == L[i - 1][j][k]) {
	     i--;
	    } else if (a.charAt(i - 1) != b.charAt(j - 1)
	      && L[i][j][k] == L[i][j - 1][k]) {
	     j--;
	    }
	   }
	  }
	  return clcs_str;
	 }
	 public int getLCSLength() {
	  return lcs.length();
	 }
	 public String getLCS() {
	  return lcs;
	 }
	 public String getCLCS() {
	  return clcs;
	 }
	 public int getCLCSLength() {
	  return clcs.length();
	 }
	 public String getConstrained() {
	  return constrained;
	 }
	 public void setConstrained(String constrained) {
	  this.constrained = constrained;
	 }
	 public void setLcs(String lcs) {
	  this.lcs = lcs;
	 }
	 public void setClcs(String clcs) {
	  this.clcs = clcs;
	 }
	}