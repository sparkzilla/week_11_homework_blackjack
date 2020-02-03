import java.util.ArrayList;

public class Game {

    private Game game;
    private Player player;
    private Player dealer;
    private Deck deck;

    public Game() {
        deck = new Deck();
        player = new Player();
        dealer = new Player();
    }

    public void gameLoop() {
        UI ui = new UI();
        ui.welcome();
        String name = ui.getPlayerName();
        player.addPlayerName(name);
        deck.populateDeck();
        deck.shuffle();

        System.out.println("Dealer's Cards");
        dealer.addCardFromDeckToHand(deck);
        System.out.println("The Dealers's total is " + dealer.getHandValue() + "\n");

        System.out.println(name + "'s Cards");
        player.addCardFromDeckToHand(deck);
        player.addCardFromDeckToHand(deck);
        System.out.println("The Player's total is " + player.getHandValue() + "\n");

        while (ui.twist()) {
            player.addCardFromDeckToHand(deck);
            System.out.println("The Player's total is " + player.getHandValue());
            if(player.isBust()){
                System.out.println("You are bust! Dealer Wins");
            }
        }
        System.out.println("Player sticks. Dealer plays...");

                while (dealer.mustPlay()) {
                    dealer.addCardFromDeckToHand(deck);
                    System.out.println("The Dealer's total is " + dealer.getHandValue());
                }
                if (dealer.isBust()) {
                    System.out.println("The Dealer is bust!. Player Wins");
                }else{
                    if (dealer.getHandValue() > player.getHandValue() ){
                        System.out.println("Dealer wins!");
                    }
                }


        }

        }



