package refugeoly;

import refugeoly.actions.Action;

public class LooseAction extends Action {

    @Override
    public void act(Refugee refugee) {
        refugee.setLoose(true);
    }
}
