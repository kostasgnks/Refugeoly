package refugeoly;

import exceptions.NoMoneyException;
import interfaces.MoneyGiver;
import interfaces.MoneyReceiver;

public class Refugee implements MoneyGiver, MoneyReceiver {

    private String name;
    private int money = 10000;
    private Board board;
    private Square square;
    private boolean dontmove;
    private boolean win;
    private boolean loose;
    private boolean lifevest;


    public Refugee(String name, Board board, Square square) {
        this.name = name;
        this.board = board;
        this.square = square;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void moveTo(int finalposition, boolean runactions) throws NoMoneyException {
        this.square = board.getSquare(finalposition);
        if (runactions) {
            square.doActions(this);
        }
    }

    public Square getSquare() {
        return square;
    }

    public void setSquare(Square square) {
        this.square = square;
    }

    public Board getBoard() {
        return board;
    }

    public String getOnoma() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public boolean getDontmove() {
        return dontmove;
    }

    public void setDontmove(boolean dontmove) {
        this.dontmove = dontmove;
    }

    public boolean getWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    public boolean getLoose() {
        return loose;
    }

    public void setLoose(boolean loose) {
        this.loose = loose;
    }

    public boolean getLifevest() {
        return lifevest;
    }

    public void setLifevest(boolean lifevest) {
        this.lifevest = lifevest;
    }

    @Override
    public void giveMoney(int money, MoneyReceiver receiver) throws NoMoneyException {
        if (money >= this.money) {
            throw new NoMoneyException();
        }
        this.money = this.money - money;
        receiver.receiveMoney(money);

    }

    @Override
    public void receiveMoney(int money) {
        this.money = this.money + money;

    }

}
