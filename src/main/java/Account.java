import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Account {

    private List<Transaction> transactions;
    private Customer customer;

    public Account(Customer customer) {
        this.transactions = new ArrayList<>();
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getBalance(){
        int sum = 0;
        for (Transaction transaction : transactions) {
            sum += transaction.getAmount();
            //System.out.println(transaction.getAmount());
        }
        return sum;
    }

    public int withDrawAmount(int amount){
            int sum = getBalance();
       if(amount > sum){
           System.out.println("not enough money brobeans");
       } else {
           transactions.add(new Transaction(-amount, new Date()));
       }
           return amount;
    }

    public int depositAmount(int amount){
        if(amount <= 0){
            System.out.println("cant deposit 0 brobeans");
        } else {
            transactions.add(new Transaction(amount, new Date()));
        }
        return amount;
    }

    public List<Transaction> getTransactions() {
        for(Transaction trans : transactions){
            System.out.println(trans.toString());
        }
        return transactions;
    }
}
