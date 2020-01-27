package lab5;

import balloon4.Balloon;
/*ballon1: radius isn't set to 0 if the blow is over the max value
balloon2: test3 - increases the radius of the balloon after being popped
balloon3: testBlow7 doesn't pop balloon if the total blow value goes over max
balloon4: testDeflate1 deflated balloon doesn't change to is popped
*/
import org.junit.Test;
import static org.junit.Assert.*;

public class BalloonTests {
	private final int MAX_RADIUS = 10;
	
	@Test
	public void testInital() {
		Balloon b = new Balloon(MAX_RADIUS);
		String msg = "A newly constructed Balloon should have radius zero.";
		assertEquals(msg, 0, b.getRadius());
	}
	
	@Test
	public void testInital1() {
		Balloon b = new Balloon(MAX_RADIUS);
		String msg = "A newly constructed Balloon should not be popped.";
		assertFalse(msg, b.isPopped());
	}
	
	@Test
	public void testBlow() {
		Balloon b = new Balloon(MAX_RADIUS);
		String msg = "After calling blow(5) on a Balloon with maximum radius 10, the radius should be 5.";
		b.blow(5);
		assertEquals(msg, 5, b.getRadius());
	}
	
	@Test
	public void testBlow1() {
		Balloon b = new Balloon(MAX_RADIUS);
		String msg = "After calling blow(20) on a Balloon with maximum radius 10, the raidus should be 0";
		b.blow(20);
		assertEquals(msg, 0, b.getRadius());	
	}
	
	@Test
	public void testBlow2() {
		Balloon b = new Balloon(MAX_RADIUS);
		String msg = "After calling blow(20) on a Balloon with maximum radius 10, isPopped should be true.";
		b.blow(20);
		assertTrue(msg, b.isPopped());
	}

	
	@Test
	public void testBlow3() {
		Balloon b = new Balloon(MAX_RADIUS);
		String msg = "After calling blow(15) on a Balloon with maximum radius 10 that is already popped, should do nothing to the radius";
		int beforeRadius = b.getRadius();
		b.pop();
		b.blow(15);
		assertEquals(msg, beforeRadius, b.getRadius());
	}
	
	@Test
	public void testBlow4() {
		Balloon b = new Balloon(MAX_RADIUS);
		String msg = "After calling blow(-3), should do nothing to the radius.";
		int beforeRadius = b.getRadius();
		b.blow(-3);
		assertEquals(msg, beforeRadius, b.getRadius());
	}
	
	@Test
	public void testBlow5() {
		Balloon b = new Balloon(MAX_RADIUS);
		String msg = "After calling blow(4) followed by blow(8) with a max radius of 10, isPopped is true.";
		b.blow(4);
		b.blow(8);
		assertTrue(msg, b.isPopped());
	}
	
	@Test
	public void testBlow6() {
		Balloon b = new Balloon(MAX_RADIUS);
		String msg = "After calling blow(4) followed by blow(8) with a max radius of 10, radius is 0.";
		b.blow(4);
		b.blow(8);
		assertEquals(msg, 0, b.getRadius());
	}
	
	@Test
	public void testDeflate() {
		Balloon b = new Balloon(MAX_RADIUS);
		String msg = "A deflated balloon should have radius 0";
		b.deflate();
		assertEquals(msg, 0, b.getRadius());
	}
	
	@Test
	public void testDeflate1() {
		Balloon b = new Balloon(MAX_RADIUS);
		String msg = "A deflated balloon should return popped as false.";
		b.deflate();
		assertFalse(msg, b.isPopped());
	}
	
	@Test
	public void testPop() {
		Balloon b = new Balloon(MAX_RADIUS);
		String msg = "A popped balloon should have radius zero.";
		b.pop();
		assertEquals(msg, 0, b.getRadius());
	}
	
	@Test 
	public void testPop1() {
		Balloon b = new Balloon(MAX_RADIUS);
		String msg = "A popped ballon should return isPopped is true.";
		b.pop();
		assertTrue(msg, b.isPopped());
	}
	

	@Test
	public void testDeflate3() {
		Balloon b = new Balloon(-5);
		String msg = "Max radius entered is -5, a call to blow(1) should return isPopped true";
		b.blow(1);
		assertTrue(msg, b.isPopped());
	}
	
	@Test
	public void testPop2() {
		Balloon b = new Balloon(-5);
		String msg = "Max radius entered is -5, a call to blow(1) should return radius = 0";
		b.blow(1);
		assertEquals(msg, 0, b.getRadius());
		
	}
	
	@Test 
	public void test1() {
		Balloon b = new Balloon(10);
		String msg = "Popped balloon followed by a call of blow(5) should return radius 0";
		b.blow(10);
		assertEquals(msg, 10, b.getRadius());
	}
	
	@Test 
	public void test2() {
		Balloon b = new Balloon(10);
		String msg = "Popped balloon followed by a call of blow(5) should return radius 0";
		b.deflate();
		b.pop();
		b.deflate();
		b.blow(4);
		assertTrue(msg, b.isPopped());
	}
	
	@Test 
	public void test3() {
		Balloon b = new Balloon(10);
		String msg = "Popped balloon followed by a call of blow(5) should return radius 0";
		b.deflate();
		b.pop();
		b.deflate();
		b.blow(4);
		assertEquals(msg, 0, b.getRadius());
	}
}
