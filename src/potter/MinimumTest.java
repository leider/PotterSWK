package potter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MinimumTest {
	@Test
	public void minimumEinerZahlIstDieZahl() throws Exception {
		assertEquals(2, Calc.minimum(2));
		assertEquals(0, Calc.minimum(0));
		assertEquals(-2, Calc.minimum(-2));
		assertEquals(Integer.MAX_VALUE, Calc.minimum(Integer.MAX_VALUE));
		assertEquals(Integer.MIN_VALUE, Calc.minimum(Integer.MIN_VALUE));
	}

	@Test
	public void minimumZweierZahlIstDieKleinereZahl() throws Exception {
		assertEquals(2, Calc.minimum(2, 5));
		assertEquals(-4, Calc.minimum(-4, 0));
		assertEquals(-7, Calc.minimum(-2, -7));
		assertEquals(-7, Calc.minimum(-7, -7));
	}

	@Test
	public void minimumVielerZahlenIstDieKleinsteZahl() throws Exception {
		assertEquals(2, Calc.minimum(5, 567, 2, 335566, 12, 3));
		assertEquals(-335566, Calc.minimum(777, -2, 5, 567, -335566, 0, 12, 3));
	}
}
