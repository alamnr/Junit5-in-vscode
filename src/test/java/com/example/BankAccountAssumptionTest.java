package com.example;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BankAccountAssumptionTest {

  @Test
  @DisplayName("Test activation account after creation")
  public void testActive() {
    BankAccount bankAccount = new BankAccount(500, 0);
    // assumeTrue(bankAccount != null);
    // assumeFalse(bankAccount == null);
    // assertTrue(bankAccount.isActive());

    assumingThat(bankAccount == null, () -> bankAccount.isActive());
  }

}
