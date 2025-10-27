
package refugeoly.actions;

import exceptions.NoMoneyException;
import refugeoly.Refugee;

public abstract class Action {
    
    
    public abstract void  act(Refugee refugee)throws NoMoneyException;

    
}
