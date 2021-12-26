package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import exam.sinbad.Adventure;
import exam.sinbad.sky.Ankaa;
import exam.sinbad.sky.HeightRange;

public class AdventureTest {

    @Before
    public void before(){
        Adventure.clearStoredDiamonds();
    }

    @Test	
	public void testConstructor1() { 
		Adventure adv = new Adventure();
		assertEquals(1, adv.getBirdCount());		
		assertEquals(0, adv.getCollectedDiamonds());		
		assertEquals(0, Adventure.getStoredDiamonds());		
	}

    
	@Test	
	public void testConstructor2_0() { 
		Adventure adv = new Adventure(new Ankaa[] {});
		assertEquals(0, adv.getBirdCount());		
		assertEquals(0, adv.getCollectedDiamonds());		
		assertEquals(0, Adventure.getStoredDiamonds());		
	}
	
	@Test	
	public void testConstructor2_2() { 
		Adventure adv = new Adventure(new Ankaa("x", 1), new Ankaa("y", 2));
		assertEquals(2, adv.getBirdCount());		
		assertEquals(0, adv.getCollectedDiamonds());		
		assertEquals(0, Adventure.getStoredDiamonds());		
	}
	
	@Test	
	public void testHeightRange() { 
		assertEquals(HeightRange.LOW, HeightRange.getHeightRange(0));		
		assertEquals(HeightRange.LOW, HeightRange.getHeightRange(299));		
		assertEquals(HeightRange.LOW, HeightRange.getHeightRange(300));		
		assertEquals(HeightRange.MEDIUM, HeightRange.getHeightRange(301));		
		assertEquals(HeightRange.MEDIUM, HeightRange.getHeightRange(600));		
		assertEquals(HeightRange.HIGH, HeightRange.getHeightRange(601));		
		assertEquals(HeightRange.HIGH, HeightRange.getHeightRange(900));		
		assertEquals(HeightRange.BEYOND, HeightRange.getHeightRange(901));		
	}
	
	@Test	
	public void testAnkaa() { 
		assertEquals("ThisIsMyName[flying HIGH at 765 meters]",
				     new Ankaa("ThisIsMyName", 765).toString());		
		assertEquals("OneDoesNotSimplyFlyOutOfDiamondIsland[flying BEYOND at 100000 meters]",
				     new Ankaa("OneDoesNotSimplyFlyOutOfDiamondIsland", 100000).toString());		
	}
	
	@Test	
	public void testAnkaaEq() { 
		assertEquals(new Ankaa("ThisIsMyName", 765), 
					new Ankaa("ThisIsMyName", 765));

		assertEquals(new Ankaa("ThisIsMyName", 765), 
					new Ankaa("ThisIsMyName", 800));
		
		assertNotEquals(new Ankaa("ThisIsMyName", 765), 
					new Ankaa("OneDoesNotSimplyFlyOutOfDiamondIsland", 765));
	}

	@Test 
	public void testCallAnkaaLow(){
		Adventure adv = new Adventure();
		assertEquals(1, adv.getDay());
		boolean result = adv.callBird(0);
		assertFalse(result);
		assertEquals(1, adv.getDay());

	}

	@Test 
	public void testCallAnkaaBeyond(){
		Adventure adv = new Adventure();
		assertEquals(1, adv.getDay());
		boolean result = adv.callBird(1000);
		assertFalse(result);
		assertEquals(1, adv.getDay());

	}

	@Test
	public void testCallAnkaaHigh(){
		Adventure adv = new Adventure();
		assertEquals(1, adv.getDay());
		adv.collectDiamons(10);
		assertEquals(10, adv.getCollectedDiamonds());

		boolean result = adv.callBird(800);
		assertTrue(result);

		assertEquals(10, Adventure.getStoredDiamonds());
		assertEquals(2,adv.getDay());

		adv.collectDiamons(20);
		assertEquals(20, adv.getCollectedDiamonds());

		boolean result2 = adv.callBird(800);
		assertTrue(result2);

		assertEquals(30, Adventure.getStoredDiamonds());
		assertEquals(3, adv.getDay());

		adv.collectDiamons(30);
		assertEquals(30, adv.getCollectedDiamonds());

		boolean result3 = adv.callBird(800);
		assertTrue(result3);

		assertEquals(60, Adventure.getStoredDiamonds());

	
	}
    
}
