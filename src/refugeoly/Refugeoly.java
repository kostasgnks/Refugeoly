package refugeoly;

import exceptions.NoMoneyException;
import java.util.Scanner;

public class Refugeoly {

    public static void main(String[] args) throws NoMoneyException {

        System.out.println("How many players are going to play the game ? ");
        Scanner scanner1 = new Scanner(System.in);
        Game game = new Game();
        int size = scanner1.nextInt();
        for (int i = 0; i < size; i++) {
            System.out.println("Give player " + (i + 1) + " a name");
            game.addPlayer(scanner1.next());
        }
        game.start();

    }

}
