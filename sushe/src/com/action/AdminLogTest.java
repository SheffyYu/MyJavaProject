package com.action;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
/**
 *Class Name: AdminLogTest
 *Description: 
 * @author Sheffy
 * @throws Exception 
 * @date 2017年5月8日 {time}
 */
public class AdminLogTest {
	
	AdminLog aLog;

	@Before
	public void setUp() throws Exception {
		aLog = new AdminLog();
	}

	@Test
	public void testExecute() throws Exception {
        String expected = "SUCCESS";  
        
        String actual = aLog.execute();  
          
        assertEquals(expected,actual); 
		fail("Not yet implemented");
	}
}

/**
 *Tile: AdminLogTest
 *Description: 
 * @author Sheffy
 * @date 2017年5月8日 {time}
 *Problems:
 */