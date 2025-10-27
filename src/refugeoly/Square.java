package refugeoly;

import exceptions.NoMoneyException;
import refugeoly.actions.Action;
import java.util.ArrayList;

public class Square {

    private int number;
    private String text;
    private String description;
    private ArrayList<Action> actions;
    private Board board;

    public Square(int number, String text, String description, Board board) {
        this.number = number;
        this.text = text;
        this.description = description;
        this.board = board;
        actions = new ArrayList<>();
    }

    public Square(int number, String text, String description, Action action, Board board) {
        this(number, text, description, board);
        actions = new ArrayList<>();
        this.actions.add(action);

    }

    public void doActions(Refugee refugee) throws NoMoneyException {
        for (int i = 0; i < actions.size(); i++) {
            actions.get(i).act(refugee);
        }
    }

    public void addAction(Action action) {
        actions.add(action);
    }

    public int getNumber() {
        return number;
    }

    public String getText() {
        return text;
    }

    public String getDescription() {
        return description;
    }

    public String toString() {

        return number + " " + text + " " + description;
    }
}
