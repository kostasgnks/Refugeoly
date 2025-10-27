package refugeoly.actions;

import exceptions.NoMoneyException;
import refugeoly.Refugee;
import refugeoly.Square;

public class GoToAction extends Action {

    private int tile;

    public GoToAction(int tile) {
        this.tile = tile;

    }

    @Override
    public void act(Refugee refugee) throws NoMoneyException {
        System.out.println("You landed on: " + refugee.getSquare().getNumber() + " " + refugee.getSquare().getText() + refugee.getSquare().getDescription());
        System.out.println("This square teleport you to: ");
        refugee.moveTo(refugee.getBoard().getSquare(tile).getNumber(), false);

    }
}
