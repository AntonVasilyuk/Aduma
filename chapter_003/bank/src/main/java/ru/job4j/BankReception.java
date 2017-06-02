package ru.job4j;

import java.util.*;
/**
 * Testing Task 3.4.2
 * Create collection Map for bank
 *
 * @author Anton Vasilyuk
 * @version 1.0
 * @since 0.1
 */
public class BankReception {

    /**
     * .
     * datebase bank
     */
    private Map<User, List<Account>> bank = new LinkedHashMap<>();

    /**
     * .
     * Add user to datebase
     *
     * @param user
     */
    public void addUser(User user) {
        List<Account> account = new ArrayList<>();
        this.bank.put(user, account);
    }

    /**
     * .
     * Remove user from datebase
     *
     * @param user
     */
    public void deleteUser(User user) {
        this.bank.remove(user);
    }

    /**
     * .
     * Add account to bank account user
     *
     * @param user
     * @param account
     */
    public void addAccountToUser(User user, Account account) {
        List<Account> list = this.bank.get(user);
        list.add(account);
        this.bank.put(user, list);
    }

    /**
     * .
     * Delete account from bank account user
     *
     * @param user
     * @param account
     */
    public void deleteAccountFromUser(User user, Account account) {
        List<Account> list = this.bank.get(user);
        int position = list.indexOf(account);
        list.remove(position);
        this.bank.put(user, list);
    }

    /**.
     * Getter for user account
     * @param user
     * @return
     */
    public List<Account> getUserAccounts(User user) {
        return this.bank.get(user);
    }

    public boolean transferMoney (User srcUser, Account srcAccount, User dstUser, Account dstAccount, double amount) {

        List<Account> listOne = this.bank.get(srcUser);
        List<Account> listSecond = this.bank.get(dstUser);

        Account accountOne = listOne.get(listOne.indexOf(srcAccount));
        Account accountSecond = listSecond.get(listSecond.indexOf(dstAccount));

        double valueOne = accountOne.getValue();
        double valueTwo = accountSecond.getValue();

        if ((valueOne - amount) < 0) {return false;}
        accountSecond.setValue(valueTwo + amount);
        listSecond.set(listSecond.indexOf(dstAccount), accountSecond);
        this.bank.put(dstUser, listSecond);
        accountOne.setValue(valueOne - amount);
        listOne.set(listOne.indexOf(srcAccount), accountOne);
        this.bank.put(srcUser, listOne);

        return true;
     }

     public Map<User, List<Account>> getBankBase() {
        return this.bank;
     }
}
