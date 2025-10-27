package refugeoly;

import exceptions.NoMoneyException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import refugeoly.actions.BankGivesMoney;
import refugeoly.actions.PayMoneyAction;
import refugeoly.actions.RollDiceAction;

public class Game {

    private ArrayList<Refugee> players;
    private Board board;
    private RollDiceAction dice;
    private static ReceiverEntity mafia = PayMoneyAction.getMafiaBank();
    private static GiverMoney bank = BankGivesMoney.getBank();
    private String winplayer = "kanenas";
    private int[] dead;
    private int[]broke;
    String[] colors = {"\u001B[31m", "\u001B[32m", "\u001B[35m", "\u001B[34m"};

    public Game() {
        board = new Board();
        players = new ArrayList<>();
        dice = new RollDiceAction();
    }

    public void addPlayer(String onoma) {
        players.add(new Refugee(onoma, this.board, board.getSquare(0)));
    }

    public void start() {

        dead = new int[players.size()];
        broke=new int[players.size()];
        for (int i = 0; i < players.size(); i++) {
            dead[i] = 1;
            broke[i]=1;
        }

        while (true) {

            for (int i = 0; i < players.size(); i++) {
                System.out.println("==============================================================================================");

                if (dead[i] == 0) {
                    System.out.print(colors[i % colors.length]);
                    System.out.println("Player " + players.get(i).getOnoma() + " is dead");
                    System.out.print("\u001B[0m");
                    if (allplayersdead()) {
                        System.out.println("Everyone is dead. Game is over");
                        return;
                    }
                    continue;
                }
                if(broke[i]==0){
                    System.out.print(colors[i % colors.length]);
                    System.out.println("Player " + players.get(i).getOnoma() + " is broke");
                    System.out.print("\u001B[0m");
                    if (allplayersbroke()) {
                        System.out.println("Everyone is broke. Game is over");
                        return;
                    }
                    continue;
                }
                System.out.print(colors[i % colors.length]);
                System.out.println("Player " + players.get(i).getOnoma());
                if (players.get(i).getDontmove()) {
                    players.get(i).setDontmove(false);
                    System.out.println("Player " + players.get(i).getOnoma() + " will not play the next round");
                    continue;
                }

                System.out.print("\u001B[0m");
                System.out.println("Press Ender to roll the dice: ");
                Scanner zari = new Scanner(System.in);
                zari.nextLine();
                System.out.println("The die rolled: ");
                try {
                    dice.act(players.get(i));
                } catch (NoMoneyException ex) {
                    System.out.print(colors[i % colors.length]);
                    System.out.println("Player " + players.get(i).getOnoma() + " lost all his money and he is out off the game");
                    System.out.print("\u001B[0m");
                    broke[i]=0;
                    continue;
                }
                System.out.println("You went to box: " + players.get(i).getSquare().getNumber() + " " + players.get(i).getSquare().getText() + players.get(i).getSquare().getDescription());
                if (players.get(i).getWin()) {
                    players.get(i).setWin(false);
                    winplayer = players.get(i).getOnoma();
                    System.out.println("---------------------------------");
                    System.out.print(colors[i % colors.length]);
                    System.out.println("Player " + winplayer + " won");
                    System.out.print("\u001B[0m");
                    return;
                }
                if (players.get(i).getLifevest()) {
                    this.dead[i] = dead[i] + 1;
                }

                if (players.get(i).getLoose()) {
                    this.dead[i] = dead[i] - 1;
                    players.get(i).setLoose(false);
                    if (dead[i] > 0) {
                        System.out.println("The player had a life vest and didnt drown");
                    } else {
                        System.out.print(colors[i % colors.length]);
                        System.out.println("Player " + players.get(i).getOnoma() + " is dead");
                        System.out.print("\u001B[0m");
                        continue;
                    }

                }
                System.out.println("Your money are: " + players.get(i).getMoney() + " $");
                System.out.println("Ngo Bank has : " + bank.getMoney() + " $");
                System.out.println("Mafia Bank has : " + mafia.getMoney() + "$");

            }
        }

    }

    public boolean allplayersdead() {
        for (int i = 0; i < players.size(); i++) {
            if (dead[i] > 0) {
                return false;
            }
        }
        return true;
    }
    public boolean allplayersbroke(){
        for (int i = 0; i < players.size(); i++) {
            if (broke[i] > 0) {
                return false;
            }
        }
        return true;
    }
}
