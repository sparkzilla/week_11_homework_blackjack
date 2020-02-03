import java.util.ArrayList;

public class Player {

    private String name;
    private ArrayList<Card> hand;
    private int handValue;

    public Player() {
        this.name = "";
        this.hand = new ArrayList<>();
        this.handValue = 0;
    }

    public void addPlayerName(String playerName){
        this.name = playerName;
    }

    public String getPlayerName() {
        return this.name;
    }

    public int getHandSize() {
        return this.hand.size();
    }

    public Card addCardFromDeckToHand(Deck deck) {
        Card dealtCard = deck.dealCard();
        this.handValue += dealtCard.getValue();
        System.out.println(dealtCard.getRank() + " of " + dealtCard.getSuit());
        return dealtCard;
    }

//    public String displayHand(){
//        for (Card card : this.hand) {
//            SuitType suit = card.getSuit();
//                    String returnSuit = suit.toString();
//        }
//        return returnSuit;
//    }


    public int getHandValue() {
           return this.handValue;
    }

    public boolean isBust() {
        if (this.handValue <= 21) {
            return false;
        } else {
            return true;
        }
    }

    public boolean mustPlay(){
        if (this.handValue < 16) {
            return true;
        } else {
            return false;
        }
    }
}

