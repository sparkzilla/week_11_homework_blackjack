import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DeckTest {

    Deck deck;
    Card card1;

    @Before
    public void before(){
        deck = new Deck(){};
        card1 = new Card(SuitType.SPADES, RankType.ACE);
    }

    @Test
    public void deckStartsEmpty(){
        assertEquals(0, deck.getDeckSize());
    }

    @Test
    public void addCardToDeck() {
        deck.addCardToDeck(card1);
        assertEquals(1, deck.getDeckSize());
    }

    @Test
    public void canPopulateDeck(){
        deck.populateDeck();
        assertEquals(52, deck.getDeckSize());
    }

    @Test
    public void isShuffled(){
        deck.populateDeck();
        deck.shuffle();
        System.out.println(deck);
    }

    @Test
    public void cardRemovedFromDeck(){
        deck.populateDeck();
        deck.dealCard();
        assertEquals(51, deck.getDeckSize());
    }
}
