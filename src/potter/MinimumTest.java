package potter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MinimumTest {
	@Test
	public void minimumEinerZahlIstDieZahl() throws Exception {
		assertEquals(2, minimum(2));
		assertEquals(0, minimum(0));
		assertEquals(-2, minimum(-2));
		assertEquals(Integer.MAX_VALUE, minimum(Integer.MAX_VALUE));
		assertEquals(Integer.MIN_VALUE, minimum(Integer.MIN_VALUE));
	}

	@Test
	public void minimumZweierZahlIstDieKleinereZahl() throws Exception {
		assertEquals(2, minimum(2, 5));
		assertEquals(-4, minimum(-4, 0));
		assertEquals(-7, minimum(-2, -7));
		assertEquals(-7, minimum(-7, -7));
	}

	@Test
	public void minimumVielerZahlenIstDieKleinsteZahl() throws Exception {
		assertEquals(2, minimum(5, 567, 2, 335566, 12, 3));
		assertEquals(-335566, minimum(777, -2, 5, 567, -335566, 0, 12, 3));
	}

	public static int minimum(Integer... zahl) {
		int minimum = zahl[0];
		for (int pivot : zahl) {
			if (pivot < minimum)
				minimum = pivot;
		}
		return minimum;
	}
}
