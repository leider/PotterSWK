package potter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PotterTest {

	@Test
	public void keinBuchKostetNix() {
		assertEquals(0, preisVon(), 0.0);
	}

	@Test
	public void einBuchKostetAcht() {
		assertEquals(8, preisVon(Buch.buch1), 0.0);
	}

	@Test
	public void zweiVerschiedeneBücherKosten1520() {
		assertEquals(15.20, preisVon(Buch.buch1, Buch.buch2), 0.0);
	}

	@Test
	public void zweiGleicheBücherKosten16() {
		assertEquals(16, preisVon(Buch.buch1, Buch.buch1), 0.0);
	}

	@Test
	public void zweiGleicheUndEinAnderesBuchKosten2320() {
		assertEquals(23.20, preisVon(Buch.buch1, Buch.buch1, Buch.buch2), 0.0);
	}

	@Test
	public void dreiVerschiedeneBuecherKosten2160() throws Exception {
		assertEquals(21.60, preisVon(Buch.buch1, Buch.buch2, Buch.buch3), 0.0);
	}

	@Test
	public void dreiVerschiedeneBuecherKosten1520() throws Exception {
		assertEquals(15.20, preisVon(Buch.buch1, Buch.buch3), 0.0);
	}

	@Test
	public void dreiUndFünfBücherKostenEiniges() {
		assertEquals(3 * 15.20 + 16, preisVon(Buch.buch2, Buch.buch1, Buch.buch2, Buch.buch1, Buch.buch2, Buch.buch1, Buch.buch2, Buch.buch2), 0.0);
	}

	@Test
	public void vieleBücherKostenEiniges() {
		assertEquals(2 * 4 * 8 * 0.8, preisVon(Buch.buch1, Buch.buch2, Buch.buch3, Buch.buch4, Buch.buch5, Buch.buch1, Buch.buch2, Buch.buch3), 0.0);
	}

	private double preisVon(Buch... bücher) {
		BookCount bookCount = new BookCount(bücher);

		int anzahlQuintupel = bookCount.popTuples(5);
		int anzahlQuadrupel = bookCount.popTuples(4);
		int anzahlTripel = bookCount.popTuples(3);
		int anzahlPaare = bookCount.popTuples(2);
		int anzahlEinzelne = bookCount.popTuples(1);

		int neueVierer = Calc.minimum(anzahlQuintupel, anzahlTripel);

		anzahlQuintupel -= neueVierer;
		anzahlQuadrupel += 2 * neueVierer;
		anzahlTripel -= neueVierer;

		double betrag = 0.0;
		betrag += anzahlQuintupel * 5 * 8 * 0.75;
		betrag += anzahlQuadrupel * 4 * 8 * 0.8;
		betrag += anzahlTripel * 3 * 8 * 0.9;
		betrag += anzahlPaare * 2 * 8 * 0.95;
		betrag += anzahlEinzelne * 1 * 8 * 1;

		return betrag;
	}

}
