package com.example;

public class BankAccount {
  private double balance;
  private double minimumBalance;
  private boolean isActive = true;
  private String accountHolderName;

  public BankAccount(double bal, double minBal) {
    this.balance = bal;
    this.minimumBalance = minBal;
  }

  public double withdraw(double withdrawAmount) {
    if (this.balance - withdrawAmount > this.minimumBalance) {
      this.balance -= withdrawAmount;
      return withdrawAmount;
    } else {
      throw new RuntimeException("You have not enough balance");
    }
  }

  public double deposit(double depositAmount) {
    /*
     * try {
     * Thread.sleep(5);
     * } catch (InterruptedException e) {
     * e.printStackTrace();
     * }
     */
    return this.balance += depositAmount;
  }

  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public double getMinimumBalance() {
    return minimumBalance;
  }

  public void setMinimumBalance(double minimumBalance) {
    this.minimumBalance = minimumBalance;
  }

  public boolean isActive() {
    return isActive;
  }

  public void setActive(boolean isActive) {
    this.isActive = isActive;
  }

  public String getAccountHolderName() {
    return accountHolderName;
  }

  public void setAccountHolderName(String accountHolderName) {
    this.accountHolderName = accountHolderName;
  }

}