package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;

// All test in class level
//@Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountTimeOutTest {

  @Test
  public void testDepositTimeoutAssertion(BankAccount bankAccount) {
    assertTimeout(Duration.ofMillis(500), () -> {
      Thread.sleep(300);
      bankAccount.deposit(555);
    });
  }

  @Test
  @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
  public void testDepositTimeOutAnnotation(BankAccount bankAccount) {
    try {
      Thread.sleep(200);
    } catch (InterruptedException e) {

      e.printStackTrace();
    }
    bankAccount.deposit(500);
    assertEquals(500, bankAccount.getBalance());
  }

}
