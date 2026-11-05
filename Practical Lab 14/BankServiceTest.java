import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BankServiceTest {

    // Test 1: Check account addition
    @Test
    void testAddAccount() {

        BankService service = new BankService();

        Account a = new Account(1, "Rahul", 5000);

        service.addAccount(a);

        assertEquals(1, service.getCount());
    }

    // Test 2: Check count increases
    @Test
    void testCountIncrease() {

        BankService service = new BankService();

        service.addAccount(
            new Account(1, "Amit", 3000)
        );

        service.addAccount(
            new Account(2, "Priya", 5000)
        );

        assertEquals(2, service.getCount());
    }

    // Test 3: Check invalid action exception
    @Test
    void testInvalidAction() {

        BankService service = new BankService();

        assertThrows(
            IllegalArgumentException.class,
            () -> service.performAction(5)
        );
    }
}