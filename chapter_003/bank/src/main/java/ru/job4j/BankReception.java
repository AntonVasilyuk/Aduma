package ru.job4j;

import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.ArrayList;
import java.util.Optional;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

/**.
 * Testing Task 3.4.2
 * Create collection Map for bank
 *
 * @author Anton Vasilyuk
 * @version 1.0
 * @since 0.1
 */
public class BankReception {

    /**.
     * Datebase bank
     */
    private Map<User, List<Account>> bank = new LinkedHashMap<>();

    /**.
     * Add user to datebase.
     * @param user for adding.
     */
    public void addUser(User user) {
        List<Account> account = new ArrayList<>();
        this.bank.put(user, account);
    }

    /**.
     * Getter for user by passport
     * @param passport is passport for searching user
     * @return user by passport
     */
    public User getUser(int passport) {
        Optional<User> user = bank.keySet().stream().filter(x -> x.getPassport() == passport).findFirst();
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new NoSuchElementException("No this data...");
        }
    }

    /**.
     * Remove user from datebase.
     * @param passport data for deleting
     */
    public void deleteUser(int passport) {
        bank.remove(getUser(passport));
    }

    /**.
     * Add account to bank account user.
     * @param passport data for adding account
     * @param account for adding account
     */
    public void addAccountToUser(int passport, Account account) {
        List<Account> list = this.bank.get(getUser(passport));
        list.add(account);
    }

    /**.
     * Delete account from bank account user.
     * @param passport data for deleting
     * @param account for deleting
     */
    public void deleteAccountFromUser(int passport, Account account) {
        User user = getUser(passport);
        List<Account> resultList = this.bank.get(user).stream()
                .filter(e -> !e.equals(account))
                .collect(Collectors.toList());
        this.bank.put(user, resultList);
    }

    /**.
     * Getter for user account
     * @param passport data for getting account
     * @return list with all accounts
     */
    public List<Account> getUserAccounts(int passport) {
        return this.bank.get(getUser(passport));
    }

    /**.
     * Method for transfer money
     * @param srsPassort one client bank
     * @param srcAccount his account
     * @param dstPassport second user
     * @param dstAccount his account
     * @param amount of money
     * @return result
     */
    public boolean transferMoney(int srsPassort, Account srcAccount, int dstPassport, Account dstAccount, double amount) {
        boolean result = false;
        User srsUser = getUser(srsPassort);
        User dstUser = getUser(dstPassport);
        Account accSrc = bank.get(srsUser).stream().filter(x -> x.equals(srcAccount)).findFirst().get();
        Account accDsc = bank.get(dstUser).stream().filter(x -> x.equals(dstAccount)).findFirst().get();
        double valueOne = srcAccount.getValue();
        double valueTwo = dstAccount.getValue();
        if ((valueOne - amount) > 0) {
            accSrc.setValue(valueOne - amount);
            accDsc.setValue(valueTwo + amount);
        }
        return result;
     }

    /**.
     * Getter for bank storage
     * @return bank storage
     */
     public Map<User, List<Account>> getBankBase() {
        return this.bank;
     }
}
