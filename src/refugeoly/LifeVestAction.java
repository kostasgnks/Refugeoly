
package refugeoly;

import refugeoly.actions.Action;


public class LifeVestAction extends Action {
    @Override
     public void act(Refugee refugee){
        refugee.setLifevest(true);
     }
}
