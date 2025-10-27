package refugeoly;

import interfaces.MoneyGiver;
import interfaces.MoneyReceiver;

public class ReceiverEntity implements MoneyReceiver {

    private String name;
    private int money = 0;

    public int getMoney() {
        return money;
    }

    @Override
    public void receiveMoney(int money) {
        this.money = this.money + money;
    }
}
