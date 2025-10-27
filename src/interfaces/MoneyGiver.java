
package interfaces;

import exceptions.NoMoneyException;


public interface MoneyGiver {
    void giveMoney(int money, MoneyReceiver receiver) throws NoMoneyException;
}
