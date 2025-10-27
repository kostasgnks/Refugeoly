package refugeoly;

import exceptions.NoMoneyException;
import refugeoly.actions.Action;
import refugeoly.actions.RollDiceAction;

public class RollDiceBackAction extends Action {

    @Override
    public void act(Refugee refugee) throws NoMoneyException {
        System.out.println("You landed on square: " + refugee.getSquare().getNumber() + " " + refugee.getSquare().getText() + refugee.getSquare().getDescription());
        System.out.println("You roll again the die and you go backwards: ");
        RollDiceAction roll3 = new RollDiceAction();
        int diceroll = roll3.roll();
        int currentposition = refugee.getSquare().getNumber();
        int finalposition = currentposition - diceroll;
        refugee.moveTo(finalposition, true);

    }
}
