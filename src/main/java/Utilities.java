import sun.tools.jconsole.ConnectDialog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Utilities {
    public static Connection conn;



    private final static String JdbcUrl = "jdbc:mysql://localhost/BankDemo?" + "autoReconnect=true&useSSL=false";
    private final static String username = "root";
    private final static String password = "Cervelo2011";

    public static String getJdbcUrl() {
        return JdbcUrl;
    }

    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }



    public static void createConnection() {
        try {
            conn = DriverManager.getConnection(JdbcUrl, username, password);
            System.out.println("connected");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static String promptForAnwser(){
        Scanner input = new Scanner(System.in);
        String answer = input.nextLine();
        return answer;
    }
    public static void createUser() {

        System.out.println("Input email: ");
        String email = Utilities.promptForAnwser();
        System.out.println("Input Username: ");
        String username = Utilities.promptForAnwser();
        System.out.println("Input Password: ");
        String password = Utilities.promptForAnwser();


        String sql = "INSERT INTO Customer (Customer_email, Customer_username, Customer_password, Customer_balance) values ('" + email + "','" + username + "','" + password + "','" + 0 + "')";

        Statement st = null;
        try {
            st = conn.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void updateBalance(int depositAmount, String email){
        int currentBalance = Account.getBalance();
        int newBalance = currentBalance + depositAmount;
        String SQL_UPDATE_BALANCE_QUERY = "UPDATE Customer SET Customer_balance = " + newBalance + " WHERE Customer_email = '" + email + "';";
        try (Connection conn = DriverManager.getConnection(getJdbcUrl(),getUsername(),getPassword())){
            Statement st = conn.createStatement();
            st.executeUpdate(SQL_UPDATE_BALANCE_QUERY);
        }catch(Exception e){
            e.printStackTrace();
        }
    }


}
