import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class CaculatorTest {

	private static Caculator calculator=new Caculator();
	
	@Before
	public void setUp() throws Exception {
		calculator.clear();
	}
public void tearDown()throws Exception{

}
	@Test
	public void testAdd() {
		calculator.add(2);
		calculator.add(3);
		assertEquals(5,calculator.getResult());
	//	fail("Not yet implemented");
	}

}
