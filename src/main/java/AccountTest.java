import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    Customer c1 = new Customer("jon");
    Account account = new Account(c1);
    //int newBalance = account.depositAmount(125);




    @Test
    void getBalance() {

        assertEquals(125,account.getBalance());
    }

    @Test
    void withDrawAmount() {
        int expected = 105;
        int actual = account.withDrawAmount(20);
        assertEquals(expected,actual);

    }

    @Test
    void depositAmount() {
        int expected = 150;
        int actual = account.depositAmount(25);
        assertEquals(expected, actual);
    }

    @Test
    void getTransactions(){
        account.depositAmount(100);
        account.depositAmount(50);
        account.depositAmount(20);
        assertEquals(3,account.getTransactions().size());
        assertEquals(100,account.getTransactions().get(0).getAmount());
        assertEquals(50,account.getTransactions().get(1).getAmount());
        assertEquals(20,account.getTransactions().get(2).getAmount());


    }

}