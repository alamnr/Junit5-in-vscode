package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@Execution(ExecutionMode.CONCURRENT)
@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountParallelExecutionTest {

  @Test
  @DisplayName("Deposit 500")
  public void testDeposit1(BankAccount bankAccount) {
    bankAccount.deposit(500);
    assertEquals(500, bankAccount.getBalance());
  }

  @Test
  @DisplayName("Deposit 500")
  public void testDeposit2(BankAccount bankAccount) {
    bankAccount.deposit(500);
    assertEquals(500, bankAccount.getBalance());
  }

  @Test
  @DisplayName("Deposit 500")
  public void testDeposit3(BankAccount bankAccount) {
    bankAccount.deposit(500);
    assertEquals(500, bankAccount.getBalance());
  }
}
