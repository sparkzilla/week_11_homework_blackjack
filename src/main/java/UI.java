import java.util.Scanner;

public class UI {

    public void welcome(){
        System.out.println("Welcome to the game.");
    }

    public String getPlayerName(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\n Please enter your name: ");
        String name = sc.nextLine();
        return name;
    }

    public SuitType showCard(Card card){
        return card.getSuit();
    }

    public Boolean twist(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\n Twist(T) or Stick(S)");
        String twistInput = sc.nextLine();
        if (twistInput.equals("T")){
            return true;
        } else {
            return false;
        }
    }
}
