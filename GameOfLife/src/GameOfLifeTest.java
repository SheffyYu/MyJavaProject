import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

//import GameOfLifeFrame.GPanel;


public class GameOfLifeTest {
	private static Game game = new Game();
	@Before
	public void setUp() throws Exception {
		game.InitGameMap();
	}
	
	@Test
	//测试单元格遍历周围活细胞数的函数
	public void testGetNeighborCount() {
		assertEquals(4,game.GetNeighborCount(3,3));
	}
	
	@Test
	//测试下一代GameMap
	public void testInitNewMap(){
		
	}

	@Test
	//测试更新地图函数
	public void testUpdateGameMap(){
		
	}
}
