package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.DayOfWeek;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountParameterizedTest {

  @ParameterizedTest
  @ValueSource(ints = { 100, 400, 800, 1000 })
  @DisplayName("")
  public void testDeposit(int amount, BankAccount bankAccount) {

    bankAccount.deposit(amount);
    assertEquals(amount, bankAccount.getBalance());
  }

  @ParameterizedTest
  @EnumSource(value = DayOfWeek.class, names = { "TUESDAY", "THURSDAY" })
  public void testDayOfWeek(DayOfWeek day) {
    assertTrue(day.toString().startsWith("T"));
  }

  @ParameterizedTest
  // @CsvSource({ "100,Mary", "500,Rashid", "1000,Maaek" })
  @CsvFileSource(resources = "/data.csv")
  public void depositAmountAndNameTest(double amount, String name, BankAccount bankAccount) {
    bankAccount.deposit(amount);
    bankAccount.setAccountHolderName(name);
    assertEquals(amount, bankAccount.getBalance());
    assertEquals(name, bankAccount.getAccountHolderName());
  }

}
