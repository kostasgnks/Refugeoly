package refugeoly.actions;

import exceptions.NoMoneyException;
import refugeoly.GiverMoney;
import refugeoly.ReceiverEntity;
import refugeoly.Refugee;

public class PayMoneyAction extends Action {

    private int moneytopay;
    private static ReceiverEntity MafiaBank = new ReceiverEntity();
    private boolean isMafia;

    public PayMoneyAction(int moneytopay, boolean isMafia) {
        this.moneytopay = moneytopay;
        this.isMafia = isMafia;
    }

    public static ReceiverEntity getMafiaBank() {
        return MafiaBank;
    }

    @Override
    public void act(Refugee refugee) throws NoMoneyException {
        if (isMafia == true) {
            refugee.giveMoney(moneytopay, MafiaBank);
        } else if (isMafia == false) {
            refugee.receiveMoney(-moneytopay);
        }

    }
}
