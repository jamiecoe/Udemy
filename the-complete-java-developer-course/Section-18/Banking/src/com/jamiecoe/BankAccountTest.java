package com.jamiecoe;

import org.junit.*;

import static org.junit.Assert.*;

public class BankAccountTest {

    private BankAccount bankAccount;
    private static int count;

    // This will run once, before any of the class test methods
    // The name of the method doesn't matter, as long as you have the annotation
    @BeforeClass
    public static void beforeClass() {
        System.out.println("This executes before any test cases");
        System.out.println("Count = " + count++);
    }

    // This will run before each test
    @Before
    public void setup() {
        bankAccount = new BankAccount("Jamie", "Coe", 100.00, BankAccount.CHECKING);
    }

    @Test
    public void deposit() {
        double balance = bankAccount.deposit(200.00, true);
        assertEquals(300.00, balance, 0);
    }

    @Test
    public void withdraw() {
        double balance = bankAccount.withdraw(600.00, true);
        assertEquals(-500.00, balance, 0);
    }

    // We add 'expected' to annotation to say we're expecting test to throw an IllegalArgumentException
    @Test(expected = IllegalArgumentException.class)
    public void withdraw_notBranch() throws Exception {
        bankAccount.withdraw(600.00, false);
    }

    @Test
    public void getBalance_deposit() {
        bankAccount.deposit(200.00, true);
        assertEquals(300.00, bankAccount.getBalance(), 0);
    }

    @Test
    public void getBalance_withdraw() {
        bankAccount.withdraw(50.00, true);
        assertEquals(50.00, bankAccount.getBalance(), 0);
    }

    @Test
    public void isChecking_true() {
        assertTrue(bankAccount.isChecking());
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("Count = " + count++);
        System.out.println("This exectutes after all test cases");
    }

    @After
    public void tearDown() {
        System.out.println("Count = " + count++);
    }
}
