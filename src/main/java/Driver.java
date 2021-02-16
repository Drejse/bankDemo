import java.util.Scanner;

public class Driver {

    public static void menu() {
        Utilities utilities = new Utilities();
        System.out.println("1) Login \n2) Empoyee login \n3) Create Account");
        Scanner input = new Scanner(System.in);

        int choice = input.nextInt();
        switch (choice) {
            case 1:
                //Customer Login
                break;
            case 2:
                //Employee Login
                break;
            case 3:
                utilities.createUser();
                break;
        }
    }
}
