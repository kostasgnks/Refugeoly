package refugeoly;

import refugeoly.actions.Action;


public class Win extends Action {
    
    
     @Override
     public void act(Refugee refugee){
        refugee.setWin(true);
    }
}
