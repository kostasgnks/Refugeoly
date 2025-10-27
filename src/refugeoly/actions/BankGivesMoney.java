package refugeoly.actions;

import exceptions.NoMoneyException;
import refugeoly.GiverMoney;
import refugeoly.ReceiverEntity;
import refugeoly.Refugee;

public class BankGivesMoney extends Action {

    private int bankmoney;
    private static GiverMoney Bank = new GiverMoney();

    public BankGivesMoney(int bankmoney) {
        this.bankmoney = bankmoney;
    }

    public static GiverMoney getBank() {
        return Bank;
    }

    @Override
    public void act(Refugee refugee) throws NoMoneyException {
        // Bank.setMoney(Bank.getMoney()-bankmoney);
        //refugee.receiveMoney(bankmoney);
        Bank.giveMoney(bankmoney, refugee);

    }

}
