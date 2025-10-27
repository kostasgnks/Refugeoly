package refugeoly;

import exceptions.NoMoneyException;
import refugeoly.actions.Action;
import refugeoly.actions.RollDiceAction;

public class RollDiceAgainAction extends Action {

    @Override
    public void act(Refugee refugee) throws NoMoneyException {
        System.out.println("You landed on square: " + refugee.getSquare().getNumber() + " " + refugee.getSquare().getText() + refugee.getSquare().getDescription());
        System.out.println("You roll again the die: ");
        RollDiceAction roll2 = new RollDiceAction();
        roll2.act(refugee);

    }
}
