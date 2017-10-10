package pkgCore;

import static org.junit.Assert.*;

import org.junit.Test;
import pkgException.DeckException;
import pkgEnum.eRank;
import pkgEnum.eSuit;

public class DeckTest {

	Deck a = new Deck();

	@Test
	public void TestEmptyDeck() {

	}

	@Test
	public void TestDrawSuit() {
		assertEquals(eSuit.CLUBS, a.Draw(eSuit.CLUBS).geteSuit());

	}

	@Test
	public void TestDrawRank() {
		assertEquals(eRank.FIVE, a.Draw(eRank.FIVE).geteRank());

	}

	@Test
	public void TestDeckRankCount() {
		assertEquals(4, a.Count(eRank.TEN));

	}

	@Test
	public void TestDeckSuitCount() {
		assertEquals(13, a.Count(eSuit.HEARTS));

	}
	@Test
	public void TestFindCard() {
		assertTrue(a.FindCard(new Card(eSuit.CLUBS, eRank.ACE)));
	}
	
	@Test
	public void TestFindCardF() {
		assertEquals(false, a.FindCard(a.Draw(eSuit.DIAMONDS)));
	}
	
	@Test(expected = DeckException.class)
	public void TestOverdraw() throws DeckException {

		Deck b = new Deck();

		for (int i = 0; i < 54; i++) {
			b.Draw();
		}
	}
}