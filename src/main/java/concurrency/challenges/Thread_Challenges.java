package concurrency.challenges;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class BankAccount {
    private double balance;
    private String accountNumber;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public synchronized void deposit(double amount) {
        balance += amount;
    }

    public synchronized void withdraw(double amount) {
        balance -= amount;
    }

    public double getBalance() {
        return this.balance;
    }
}

class BankAccount_ReentrantLock_TryLock {
    private double balance;

    private ReentrantLock lock;

    public BankAccount_ReentrantLock_TryLock(double initialBalance, ReentrantLock lock) {
        this.balance = initialBalance;
        this.lock = lock;
    }

    public void deposit(double amount) {
        boolean status = false;
        try {
            if (lock.tryLock(1, TimeUnit.MILLISECONDS)) {
                try {
                    balance += amount;
                    status = true;
                } finally {
                    lock.unlock();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("no he podido conseguir el lock");
        }
        System.out.println("trans status: " + status);
    }

    public void withdraw(double amount) {
        boolean status = false;
        lock.lock();
        try {
            balance -= amount;
            status = true;
        } finally {
            lock.unlock();
        }
        System.out.println("trans status: " + status);

    }

    public double getBalance() {
        return this.balance;
    }
}

public class Thread_Challenges {
    public static void main(String[] args) {
        final BankAccount commonBankAccount = new BankAccount("123", 1000.00);
        challenge1_2_3(commonBankAccount);
        System.out.println("Final balance: " + commonBankAccount.getBalance());

        ReentrantLock lock = new ReentrantLock();
        final BankAccount_ReentrantLock_TryLock reentrantLockBankAccount = new BankAccount_ReentrantLock_TryLock(1000.00, lock);
        challenge4(reentrantLockBankAccount);
        System.out.println("Final balance reentrantLock: " + reentrantLockBankAccount.getBalance());


    }

    /**
     * LAMBDA'S WAY (instead of Thread thread2 = new Thread(new Runnable()){@Override public void run(){}}
     */
    public static void challenge1_2_3(BankAccount bankAccount) {
        Thread thread1 = new Thread(() -> {
            System.out.println("First client depositing 300.00");
            bankAccount.deposit(300.00);
            System.out.println("First client withdrawing 50.00");
            bankAccount.withdraw(50.00);
        });

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                System.out.println("Second client depositing 203.75");
                bankAccount.deposit(203.75);
                System.out.println("Second client withdrawing 100.00");
                bankAccount.withdraw(100.00);
            }
        };

        thread1.start();
        thread2.start();

    }

    public static void challenge4(BankAccount_ReentrantLock_TryLock bankAccount) {
        System.out.println("REENTRANT_LOCK__First client depositing 300.00");
        bankAccount.deposit(300.00);
        System.out.println("REENTRANT_LOCK__First client withdrawing 50.00");
        bankAccount.withdraw(50.00);
    }
}

