package org.sdancer.algorithm;

import static org.junit.Assert.*;

import org.junit.Test;

public class LCSTest {

	@Test
	 public void test(){
	  
	  LCS lcs1 = new LCS("ATCCGACAACT","ATCGCATCTT");
	  assertEquals("lcs1_1",lcs1.getLCSLength(), 8);
	  assertEquals("lcs1_2",lcs1.getLCS(), "ATCGCACT");
	  
	  LCS lcs2 = new LCS("GAAAATTTTC","TAAATG");
	  assertEquals("lcs2_1",lcs2.getLCSLength(), 4);
	  assertEquals("lcs2_2",lcs2.getLCS(), "AAAT");
	  
	  LCS lcs3 = new LCS("TAGTAGTAGTAGTAGTAG","CATCATCATCATCA");
	  assertEquals("lcs3_1",lcs3.getLCSLength(), 9);
	  assertEquals("lcs3_2",lcs3.getLCS(), "ATATATATA");
	  LCS lcs4 = new LCS("TAGTAGTAG1oTAGTAGTAG","CATCATCATCATCA");
	  assertEquals("lcs4_1",lcs4.getLCS(), "error in string 1");
	  
	  LCS lcs5 = new LCS("AS&KASLDF*","ADSF");
	  assertEquals("lcs5_1",lcs5.getLCS(), "error in string 1");
	  
	  LCS lcs6 = new LCS("","");
	  assertEquals("lcs6_1",lcs6.getLCS(), "");
	  assertEquals("lcs6_2",lcs6.getLCSLength(), 0);
	  
	  LCS lcs7 = new LCS("A","");
	  assertEquals("lcs7_1",lcs7.getLCS(), "");
	  assertEquals("lcs7_2",lcs7.getLCSLength(), 0);
	  
	  LCS lcs8 = new LCS("","A");
	  assertEquals("lcs8_1",lcs8.getLCS(), "");
	  assertEquals("lcs8_2",lcs8.getLCSLength(), 0);
	  
	  LCS lcs9 = new LCS("A","B");
	  assertEquals("lcs9_1",lcs9.getLCS(), "");
	  assertEquals("lcs9_2",lcs9.getLCSLength(), 0);
	  
	  
	  
	  LCS clcs1 = new LCS("A","A","A");
	  assertEquals("clcs1_1",clcs1.getCLCSLength(),1);
	  assertEquals("clcs1_2",clcs1.getCLCS(),"A");
	  
	  LCS clcs2 = new LCS("A","B","A");
	  assertEquals("clcs2_1",clcs2.getCLCSLength(),0);
	  assertEquals("clcs2_2",clcs2.getCLCS(),"");
	  
	  LCS clcs3 = new LCS("ATCCGACAACT","ATCGCATCTT","");
	  assertEquals("clcs3_1",clcs3.getCLCSLength(),8);
	  assertEquals("clcs3_2",clcs3.getCLCS(),"ATCGCACT");
	  
	  LCS clcs4 = new LCS("","A","A");
	  assertEquals("clcs4_1",clcs4.getCLCSLength(),0);
	  assertEquals("clcs4_2",clcs4.getCLCS(),"");
	  
	  LCS clcs5 = new LCS("A","","A");
	  assertEquals("clcs5_1",clcs5.getCLCSLength(),0);
	  assertEquals("clcs5_2",clcs5.getCLCS(),"");
	  
	  LCS clcs6 = new LCS("","","");
	  assertEquals("clcs6_1",clcs6.getCLCSLength(),0);
	  assertEquals("clcs6_2",clcs6.getCLCS(),"");
	  
	  LCS clcs7 = new LCS("ABCDE","ACDBE","B");
	  assertEquals("clcs7_1",clcs7.getCLCSLength(),3);
	  assertEquals("clcs7_2",clcs7.getCLCS(),"ABE");
	  
	  
	  LCS clcs8 = new LCS("ABCDE","ACDBE","BD");
	  assertEquals("clcs8_2",clcs8.getCLCS(),"");
	  assertEquals("clcs8_1",clcs8.getCLCSLength(),0);
	  
	  LCS clcs9 = new LCS("ABCDEFGHI","ACEFGHBDI","B");
	  assertEquals("clcs9_1",clcs9.getCLCSLength(),4);
	  assertEquals("clcs9_2",clcs9.getCLCS(),"ABDI");
	  
	  LCS clcs10 = new LCS("SDGJAGJSDJSSSS","SAGSAGASDJJJJJJ","SJ");
	  assertEquals("clcs10_1",clcs10.getCLCSLength(),7);
	  assertEquals("clcs10_2",clcs10.getCLCS(),"SGAGSDJ");
	  
	 }

}
