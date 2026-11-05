import java.util.Scanner;

class Driver {

    public static void main(String[] args) {

        BankService service = new BankService();

        Scanner sc = new Scanner(System.in);

        int choice;

        do {
            System.out.println("\n--- MiniBank Menu ---");
            System.out.println("1. Add Account");
            System.out.println("2. View Accounts");
            System.out.println("3. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            try {
                service.performAction(choice);

                if (choice == 1) {
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Balance: ");
                    double balance = sc.nextDouble();

                    service.addAccount(
                        new Account(id, name, balance)
                    );

                    System.out.println("Account added!");
                }

                else if (choice == 2) {
                    service.displayAccounts();
                }

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        } while (choice != 3);

        sc.close();
    }
}
