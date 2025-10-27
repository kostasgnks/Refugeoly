package refugeoly;

import exceptions.NoMoneyException;
import interfaces.MoneyGiver;
import interfaces.MoneyReceiver;

public class GiverMoney implements MoneyGiver {

    private String name;
    private int money = 10000;

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public void giveMoney(int money, MoneyReceiver receiver) throws NoMoneyException {
        if (money >= this.money) {
            throw new NoMoneyException();
        }
        this.money = this.money - money;
        receiver.receiveMoney(money);
        System.out.println("test giving $");
    }
}
