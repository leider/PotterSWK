package potter;

import static org.junit.Assert.assertEquals;
import static potter.Buch.buch1;
import static potter.Buch.buch2;
import static potter.Buch.buch3;

import org.junit.Test;

public class BookCountTest {

	@Test
	public void keinBuchHatKeineTripel() {
		assertEquals(0, new BookCount().popTuples(3));
	}

	@Test
	public void einBuchHatKeineTripel() {
		assertEquals(0, new BookCount(buch1).popTuples(3));
	}

	@Test
	public void zweiVerschiedeneBücherHabenKeineTripel() {
		assertEquals(0, new BookCount(buch1, buch2).popTuples(3));
	}

	@Test
	public void zweiGleicheBücherHabenKeineTripel() {
		assertEquals(0, new BookCount(buch1, buch1).popTuples(3));
	}

	@Test
	public void dreiVerschiedeneBuecherHabenEinTripel() {
		assertEquals(1, new BookCount(buch1, buch2, buch3).popTuples(3));
	}

	@Test
	public void zweiMalDreiVerschiedeneBuecherHabenZweiTripel() {
		assertEquals(2, new BookCount(buch1, buch2, buch3, buch1, buch2, buch3).popTuples(3));
	}

	@Test
	public void VieleVerschiedeneBuecherHabenMehrereTripel() {
		BookCount bookCount = new BookCount(buch1, buch2, buch3, buch3, buch3, buch1, buch2, buch3, buch1, buch2, buch2, buch3);
		assertEquals(3, bookCount.popTuples(3));
		assertEquals(0, bookCount.popTuples(3));
		assertEquals(1, bookCount.popTuples(2));
		assertEquals(0, bookCount.popTuples(2));
		assertEquals(1, bookCount.popTuples(1));
		assertEquals(0, bookCount.popTuples(1));
	}

}
