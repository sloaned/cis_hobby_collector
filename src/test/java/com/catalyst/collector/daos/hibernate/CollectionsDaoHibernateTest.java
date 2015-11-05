ackage com.catalyst.collector.daos.hibernate;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

import com.catalyst.collector.daos.CollectionsDao;
import com.catalyst.collector.entities.Color;

public class CollectionsDaoHibernateTest {
	CollectionsDao dao;
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void happyPathAddColorTest(){
		Color c = new Color("azul");
		assertEquals(true,dao.addColor(c));
	}
	@Test
	public void sadPathAddColorTest_noColor(){
		Color c = new Color();
		assertNotEquals(true,dao.addColor(c));
	}
	@Test
	public void sadPathAddColorTest_over255Char(){
		Color c = new Color();
		String s = new String();
		for(int i = 0; i<130; i++){
			s = Integer.toString(i);
		}
		c.setColor(s);
		assertNotEquals(true,dao.addColor(c));
	}
	@Test
	public void happyPathRemoveColorTest(){
		List<Color> colors = dao.getColorList();
		int id = colors.get(0).getId();
		assertEquals(true,dao.removeColor(id));
	}
	@Test
	public void sadPathRemoveColorTest(){
		List<Color> colors = dao.getColorList();
		Set<Integer> set = new HashSet<Integer>();
		for(Color c: colors){
			set.add(c.getId());
		}
		for(int i=0; i<100; i++){
			if(!set.contains(i)){
				assertEquals(true,dao.removeColor(i));
			}
		}
	}
	@Test
	public void happyPathGetColorTest(){
		List<Color> colors = dao.getColorList();
		int id = colors.get(0).getId();
		Color c = new Color();
		assertEquals(c.getClass().getName(),dao.getColor(id).getClass().getName());
	}
	@Test
	public void sadPathGetColorTest(){
		List<Color> colors = dao.getColorList();
		Set<Integer> set = new HashSet<Integer>();
		for(Color c: colors){
			set.add(c.getId());
		}
		for(int i=0; i<100; i++){
			if(!set.contains(i)){
				Color c = new Color();
				assertNotEquals(c.getClass().getName(),dao.getColor(i).getClass().getName());
			}
		}
	}
	@Test
	public void happyPathUpdateColorTest(){
		Color c = new Color("azul");
		assertEquals(true,dao.addColor(c));
	}
	@Test
	public void sadPathUpdateColorTest_noColor(){
		Color c = new Color();
		assertNotEquals(true,dao.addColor(c));
	}
	@Test
	public void sadPathUpdateColorTest_over255Char(){
		Color c = new Color();
		String s = new String();
		for(int i = 0; i<130; i++){
			s = Integer.toString(i);
		}
		c.setColor(s);
		assertNotEquals(true,dao.addColor(c));
	}
	@Test
	public void happyPathGetColorListTest(){
		List<Color> colorList = new ArrayList<Color>();
		assertEquals(colorList.getClass().getName(),dao.getColorList().getClass().getName());
	}
}
