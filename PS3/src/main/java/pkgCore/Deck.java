package pkgCore;

import java.util.ArrayList;

import java.util.Collections;
import java.util.stream.Collectors;

import pkgEnum.eRank;
import pkgEnum.eSuit;
import pkgException.DeckException;


public class Deck {

	private ArrayList<Card> cardsInDeck = new ArrayList<Card>();

	public Deck() {
		for (eSuit eSuit : eSuit.values()) {
			for (eRank eRank : eRank.values()) {
				cardsInDeck.add(new Card(eSuit, eRank));
			}
		}
		Collections.shuffle(cardsInDeck);
	}


	public Card Draw() throws DeckException { 
		if (cardsInDeck.size() == 0)
		{
			throw new DeckException(this);
		}
		return cardsInDeck.remove(0);
	}
	

	public Card Draw(eSuit eSuit) 
	{
		for (Card c: this.cardsInDeck)
		{
			if (c.geteSuit() == eSuit) {
				cardsInDeck.remove(c);
				return c;
			}
		}
		
		return null;
	}

	public Card Draw(eRank eRank) 
	{
		for (Card c: this.cardsInDeck)
		{
			if (c.geteRank() == eRank) {
				cardsInDeck.remove(c);
				return c;
			}
		}
		
		return null;
	}
	
	public int Count(eSuit eSuit)
	{
		ArrayList<Card> cardsInSuit = cardsInDeck.stream().filter(s -> s.geteSuit() == eSuit).
				collect(Collectors.toCollection(ArrayList::new));
		return cardsInSuit.size();
		
	}
	
	public int Count(eRank eRank)
	{
		ArrayList<Card> cardsInRank = cardsInDeck.stream().filter(s -> s.geteRank() == eRank).
				collect(Collectors.toCollection(ArrayList::new));
		return cardsInRank.size();
	}
	
	public boolean FindCard(Card c)
	{
		for (Card card: cardsInDeck)
		{
			if (card.geteRank() == c.geteRank() && card.geteSuit() == c.geteSuit())
				return true;
		}
		return false;
	}

}
