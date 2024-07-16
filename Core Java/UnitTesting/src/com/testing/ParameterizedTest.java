package com.testing;

import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParameterizedTest
{
    private BankAccount account;
    private double amount;
    private boolean branch;
    private double expected;

//    public ParameterizedTest(double balance, boolean branch, double expected) {
//        this.amount = balance;
//        this.branch = branch;
//        this.expected = expected;
//    }

    @org.junit.jupiter.api.BeforeEach
    public void setup(){
        account = new BankAccount("Steve", "Rogers", 1000.00, BankAccount.CHECKING);
        System.out.println("Running a Test...");
    }

    static Stream<Arguments> testConditions(){
        return Stream.of(
                Arguments.arguments(100.00, true, 1100.00),
                Arguments.arguments(200.00, true, 1200.00),
                Arguments.arguments(325.14, true, 1325.14),
                Arguments.arguments(489.20, true, 1489.20),
                Arguments.arguments(1000.00, true, 2000.00)
        );
    }

    @org.junit.jupiter.params.ParameterizedTest
    @MethodSource("com.testing.ParameterizedTest#testConditions")
    void deposit(double amount, boolean branch, double expected) {
        account.deposit(amount, branch);
        assertEquals(expected, account.getBalance(), 0.01);
    }

    @org.junit.jupiter.params.ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7})
    void test(int val)
    {
        assertTrue(val % 2 == 0);
    }
}
