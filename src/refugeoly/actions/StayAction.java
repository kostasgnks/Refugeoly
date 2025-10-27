package refugeoly.actions;

import refugeoly.Refugee;

public class StayAction extends Action {

    @Override
    public void act(Refugee refugee) {
        refugee.setDontmove(true);
    }
}
