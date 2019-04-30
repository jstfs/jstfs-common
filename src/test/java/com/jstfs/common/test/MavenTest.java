package com.jstfs.common.test;

import org.junit.Test;

public class MavenTest {
	
	@Test
    public void testDivideTable() {
    	String custId = "1015071400232035";
    	Long tableNo = Long.valueOf(custId) % 128;
    	Long dbNo = tableNo /8 ;
    	Long instanceNo = dbNo % 4;
    	
    	System.out.println(instanceNo);
    	System.out.println(dbNo);
    	System.out.println(tableNo);
    }
}
