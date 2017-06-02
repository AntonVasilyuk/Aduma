package ru.job4j;

import java.util.*;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Testing Task 3.4.2
 * Create collection Map for bank
 *
 * @author Anton Vasilyuk
 * @version 1.0
 * @since 0.1
 */

public class BankReceptionTest {

    /**.
     * Test adding user to bank datebase
     */
    @Test
    public void whenNeedCheckAddUserToDateBaseBankThenCheckIt() {
        BankReception bank = new BankReception();
        User userOne = new User("Egor Safilow", 876145963);
        bank.addUser(userOne);
        Map<User, List<Account>> checkSize = bank.getBankBase();
        boolean fact = false;
        boolean expect = true;
        if (checkSize.size() != 0) {fact = true;}
        assertThat(fact, is(expect));
    }

    /**.
     * Test adding user to bank datebase
     */
    @Test
    public void whenNeedCheckDelUserToDateBaseBankThenCheckIt() {
        BankReception bank = new BankReception();
        User userOne = new User("Egor Safilow", 876145963);
        bank.addUser(userOne);
        Map<User, List<Account>> checkSizeOne = bank.getBankBase();
        int oneSize = checkSizeOne.size();
        bank.deleteUser(userOne);
        int twoSize = checkSizeOne.size();
        boolean fact = false;
        boolean expect = true;
        if (oneSize != 0 && twoSize == 0) {fact = true;}
        assertThat(fact, is(expect));
    }

    /**.
     * Test adding account for user to bank datebase
     */
    @Test
    public void whenNeedAddAccountForUserToDateBaseBankThenCheckIt() {
        BankReception bank = new BankReception();
        User userOne = new User("Egor Safilow", 876145963);
        bank.addUser(userOne);
        int oneSize = bank.getUserAccounts(userOne).size();
        Account account = new Account(100.0, 100200);
        bank.addAccountToUser(userOne, account);
        int twoSize = bank.getUserAccounts(userOne).size();
        boolean fact = false;
        boolean expect = true;
        if (oneSize != twoSize) {fact = true;}
        assertThat(fact, is(expect));
    }

    /**.
     * Test adding account for user to bank datebase
     */
    @Test
    public void whenNeedDelAccountForUserToDateBaseBankThenCheckIt() {
        BankReception bank = new BankReception();
        User userOne = new User("Egor Safilow", 876145963);
        bank.addUser(userOne);
        int oneSize = bank.getUserAccounts(userOne).size();
        Account account = new Account(100.0, 100200);
        bank.addAccountToUser(userOne, account);
        int twoSize = bank.getUserAccounts(userOne).size();
        bank.deleteAccountFromUser(userOne, account);
        int thirdSize = bank.getUserAccounts(userOne).size();
        boolean fact = false;
        boolean expect = true;
        if (oneSize != twoSize && oneSize == thirdSize) {fact = true;}
        assertThat(fact, is(expect));
    }

    /**.
     * Test adding account for user to bank datebase
     */
    @Test
    public void whenNeedTransferValueThenCheckIt() {
        BankReception bank = new BankReception();

        User userOne = new User("Egor Safilow", 876145963);
        User userTwo = new User("Igor Volochko", 876145961);

        bank.addUser(userOne);
        bank.addUser(userTwo);

        Account accountOne = new Account(100.0, 100200);
        Account accountTwo = new Account(200.0, 100201);

        bank.addAccountToUser(userOne, accountOne);
        bank.addAccountToUser(userTwo, accountTwo);

        bank.transferMoney(userOne, accountOne, userTwo, accountTwo, 50.0);

        int indexAccountOne = bank.getBankBase().get(userOne).indexOf(accountOne);
        int indexAccountTwo = bank.getBankBase().get(userTwo).indexOf(accountTwo);
        double resultUserOne = bank.getBankBase().get(userOne).get(indexAccountOne).getValue();
        double resultUserTwo = bank.getBankBase().get(userTwo).get(indexAccountTwo).getValue();

        boolean fact = false;
        boolean expect = true;
        if (resultUserOne == 50.0 && resultUserTwo == 250.0) {fact = true;}
        assertThat(fact, is(expect));
    }


}
