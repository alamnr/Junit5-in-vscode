package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountRepeatedTest {

  @RepeatedTest(5)
  @DisplayName("Deposit repeatedly")
  public void testDeposit(BankAccount bankAccount) {
    bankAccount.deposit(500);
    assertEquals(500, bankAccount.getBalance());
  }

  @RepeatedTest(5)
  @DisplayName("Test repeatedly by repetition info")
  public void testDepositRepititionInfo(BankAccount bankAccount, RepetitionInfo repetitionInfo) {
    bankAccount.deposit(500);
    assertEquals(500, bankAccount.getBalance());
    System.out.println("Nr: " + repetitionInfo.getCurrentRepetition());
  }
}
