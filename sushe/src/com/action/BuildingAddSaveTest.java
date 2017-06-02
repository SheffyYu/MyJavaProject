/**
 *Tile: BuildingAddSaveTest
 *Description: 
 * @author Sheffy
 * @date 2017年5月8日 {time}
 *Problems:
 */
package com.action;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 *Class Name: BuildingAddSaveTest
 *Description: 
 * @author Sheffy
 * @date 2017年5月8日 {time}
 */
public class BuildingAddSaveTest {
	
	BuildingAddSave bs;

	@Before
	public void setUp() throws Exception {
		bs = new BuildingAddSave(); 
	}

	@Test
	public void testExecute() throws Exception {
        String expected = null;  
        
        String actual = bs.execute();  
          
        assertEquals(expected,actual); 
		fail("Not yet implemented");
	}
}
