package concurrency.challenges;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Thread_Challenge2 {

    public static void main(String[] args) {
        Thread_Challenge2 thread_challenge2 = new Thread_Challenge2();
        BankAccount account1 = thread_challenge2.new BankAccount("12345-678", 500.00);
        BankAccount account2 = thread_challenge2.new BankAccount("98765-432", 1000.00);

        new Thread(thread_challenge2.new Transfer(account1, account2, 10.00), "Transfer1").start();
        new Thread(thread_challenge2.new Transfer(account2, account1, 55.88), "Transfer2").start();
    }

    public class BankAccount {
        private double balance;
        private String accountNumber;
        private Lock lock = new ReentrantLock();

        BankAccount(String accountNumber, double balance) {
            this.accountNumber = accountNumber;
            this.balance = balance;
        }

        public boolean withdraw(double amount) {
            if (lock.tryLock()) {
                try {
                    // Simulate database access
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                }
                balance -= amount;
                System.out.printf("%s: Withdrew %f\n", Thread.currentThread().getName(), amount);
                lock.unlock();

                return true;
            }
            return false;
        }

        public boolean deposit(double amount) {
            if (lock.tryLock()) {
                try {
                    // Simulate database access
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                }
                balance += amount;
                System.out.printf("%s: Deposited %f\n", Thread.currentThread().getName(), amount);
                lock.unlock();

                return true;
            }
            return false;
        }

        public boolean transfer(BankAccount destinationAccount, double amount) {
            if (withdraw(amount)) {
                if (destinationAccount.deposit(amount)) {
                    return true;
                } else {
                    // The deposit failed. Refund the money back into the account.
                    System.out.printf("%s: Destination account busy. Refunding money\n",
                            Thread.currentThread().getName());
                    deposit(amount);
                }
            }

            return false;
        }
    }

    class Transfer implements Runnable {
        private BankAccount sourceAccount, destinationAccount;
        private double amount;

        Transfer(BankAccount sourceAccount, BankAccount destinationAccount, double amount) {
            this.sourceAccount = sourceAccount;
            this.destinationAccount = destinationAccount;
            this.amount = amount;
        }

        public void run() {
            while (!sourceAccount.transfer(destinationAccount, amount))
                continue;
            System.out.printf("%s completed\n", Thread.currentThread().getName());
        }
    }
}

/**ERROR
 * Live-lock because tryLock is not unlock and the transfer is doing a refund (trying again because the run in Transfer class)
 *
 * SOLUTION
 * 1. tryLock with if
 * 2. try finally in order to close */