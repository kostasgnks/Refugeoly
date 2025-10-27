package refugeoly.actions;

import exceptions.NoMoneyException;
import java.util.Random;
import refugeoly.Refugee;

public class RollDiceAction extends Action {

    private Random random;

    public RollDiceAction() {
        random = new Random();
    }

    public int roll() {
        int zari = random.nextInt(6) + 1;
        System.out.println(zari);
        return zari;
    }

    @Override
    public void act(Refugee refugee) throws NoMoneyException {
        int diceroll = roll();
        int currentposition = refugee.getSquare().getNumber();
        int finalposition = currentposition + diceroll;
        if (finalposition > 39) {
            int bounce = finalposition - 39;
            finalposition = 39 - bounce;
        }
        refugee.moveTo(finalposition, true);
    }
}
