package com.example;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Bank Account Assertions Test")
public class BankAccountTest {

  @Test
  @DisplayName("Test activation of account after creation")
  public void testActive() {
    BankAccount bankAccount = new BankAccount(500, 0);
    assertTrue(bankAccount.isActive());
  }

  @Test
  @DisplayName("Test Bank Account Holder name is not null")
  public void testBankAccountHolderName() {
    BankAccount bankAccount = new BankAccount(500, 0);
    bankAccount.setAccountHolderName("Maaike ");
    assertNotNull(bankAccount.getAccountHolderName());
  }

  @Test
  @DisplayName("Test that we can't withdraw below minimum ")
  public void testNoWithdrawBelowMinimum() {
    BankAccount bankAccount = new BankAccount(500, 500);
    assertThrows(RuntimeException.class, () -> bankAccount.withdraw(1000));
  }

  @Test
  @DisplayName("Test no exception for withdraw and deposit")
  public void testWithdrawAndDepositWithoutException() {
    BankAccount bankAccount = new BankAccount(6000, 500);
    assertAll(() -> bankAccount.withdraw(5400), () -> bankAccount.deposit(500));
    assertEquals(1100, bankAccount.getBalance());

  }

  @Test
  @DisplayName("Test speed deposit")
  public void testDepositTimeout() {
    BankAccount bankAccount = new BankAccount(400, 0);
    assertTimeout(Duration.ofNanos(1), () -> bankAccount.deposit(200));
  }
}
