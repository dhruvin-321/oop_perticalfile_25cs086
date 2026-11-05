import java.util.ArrayList;

class BankService {

    private ArrayList<Account> accounts = new ArrayList<>();

    // Add account
    public void addAccount(Account account) {
        if (account == null) {
            throw new IllegalArgumentException("Invalid account");
        }

        accounts.add(account);
    }

    // Return total account count
    public int getCount() {
        return accounts.size();
    }

    // Perform action
    public void performAction(int action) {

        if (action < 1 || action > 3) {
            throw new IllegalArgumentException("Invalid action");
        }

        if (action == 1) {
            System.out.println("Add Account selected");
        } else if (action == 2) {
            System.out.println("View Accounts selected");
        } else {
            System.out.println("Exit selected");
        }
    }

    // Display accounts
    public void displayAccounts() {
        for (Account a : accounts) {
            System.out.println(
                a.getId() + " " +
                a.getName() + " " +
                a.getBalance()
            );
        }
    }
}