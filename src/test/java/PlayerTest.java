import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    Player player;
    Deck deck;

    @Before
    public void before() {
        player = new Player();
        deck = new Deck();
        deck.populateDeck();
    }

    @Test
    public void canGetPlayerName() {
        assertEquals("", this.player.getPlayerName());
    }

    @Test
    public void canAddPlayerName(){
        this.player.addPlayerName("Alan");
        assertEquals("Alan", this.player.getPlayerName());
    }

    @Test
    public void getInitialSizeOfHand() {
        assertEquals(0, this.player.getHandSize());
    }

    @Test
    public void hasCardBeenAddedToHand() {
        player.addCardFromDeckToHand(deck);
        assertEquals(1, player.getHandSize());
        assertEquals(51, deck.getDeckSize());
    }

    @Test
    public void twoCardsAddedToHand(){
        player.addCardFromDeckToHand(deck);
        player.addCardFromDeckToHand(deck);
        assertEquals(2, player.getHandSize());
        assertEquals(50, deck.getDeckSize());
    }

    @Test
    public void findValueOfHand() {
        player.addCardFromDeckToHand(deck);
        player.addCardFromDeckToHand(deck);
        player.addCardFromDeckToHand(deck);
        assertEquals(6, player.getHandValue());
    }

    @Test
    public void isThePlayerBustFalse(){
        player.addCardFromDeckToHand(deck);  //1
        player.addCardFromDeckToHand(deck);  //3
        player.addCardFromDeckToHand(deck);  //6
        player.addCardFromDeckToHand(deck);  //10
        player.addCardFromDeckToHand(deck);  //15
        player.addCardFromDeckToHand(deck);  //21
        player.getHandValue();
        assertEquals(false, player.isBust());
    }

    @Test
    public void isThePlayerBustTrue(){
        player.addCardFromDeckToHand(deck);  //1
        player.addCardFromDeckToHand(deck);  //3
        player.addCardFromDeckToHand(deck);  //6
        player.addCardFromDeckToHand(deck);  //10
        player.addCardFromDeckToHand(deck);  //15
        player.addCardFromDeckToHand(deck);  //21
        player.addCardFromDeckToHand(deck);  //28
        player.getHandValue();
        assertEquals(true, player.isBust());

    }
}