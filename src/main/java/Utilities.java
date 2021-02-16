import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Utilities {
    private static Connection conn;
    final static String JdbcUrl = "jdbc:mysql://localhost/BankDemo?" + "autoReconnect=true&useSSL=false";
    final static String username = "root";
    final static String password = "Cervelo2011";

    public static void createConnection() {
        try {
            conn = DriverManager.getConnection(JdbcUrl, username, password);
            System.out.println("connected");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static String promtForAwnser(){
        Scanner input = new Scanner(System.in);
        String answer = input.nextLine();
        return answer;
    }
    public void createUser() {

        System.out.println("Input email: ");
        String email = Utilities.promtForAwnser();
        System.out.println("Input Username: ");
        String username = Utilities.promtForAwnser();
        System.out.println("Input Password: ");
        String password = Utilities.promtForAwnser();

        String sql = "INSERT INTO Customer (Customer_email, Customer_username, Customer_password) values ('" + email + "','" + username + "','" + password + "')";
        Statement st = null;
        try {
            st = conn.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
