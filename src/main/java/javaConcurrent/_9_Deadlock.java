package javaConcurrent;


import java.util.concurrent.TimeUnit;

/**
 * A thread is waiting a resource is being used by another thread that is waiting for the first thread.
 */

public class _9_Deadlock {

    public static void main(String[] args) {
        BankAccount bankAccount1 = new BankAccount(1, "bankAccount1", 100d);
        BankAccount bankAccount2 = new BankAccount(2, "bankAccount2", 100d);

        Thread transferFrom1To2 = new Thread(new TransferTask(bankAccount1, bankAccount2), "TransferFrom-BankAccount1_To-BankAccount2");
        transferFrom1To2.start();

        Thread transferFrom2To1 = new Thread(new TransferTask(bankAccount2, bankAccount1), "TransferFrom-BankAccount2_To-BankAccount1");
        transferFrom2To1.start();
    }

    private static final class TransferTask implements Runnable {
        private BankAccount from;
        private BankAccount to;

        public TransferTask(BankAccount from, BankAccount to) {
            this.from = from;
            this.to = to;
        }

        public void run() {
            System.out.println("Executing transfer from: " + from.name + " to: " + to.name);
            BankAccount.transfer(from, to, 10d);
        }
    }

    private static final class BankAccount {
        private int id;
        private String name;
        private double balance;

        public BankAccount(int id, String name, double balance) {
            this.id = id;
            this.name = name;
            this.balance = balance;
        }

        public void withdraw(double amount) {
            // IO stuff simulation
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balance -= amount;
        }

        public void deposit(double amount) {
            // IO stuff simulation
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balance += amount;
        }

        @Override
        public String toString() {
            return "BankAccount [id=" + id + ", balance=" + balance + "]";
        }

        /**
         * the transaction from 1 to 2 enters and block 1.
         * the transaction from 2 to 1 enters and block 2.
         * 1 wait 2 while 2 is waiting 1.
        * */
        public static void transfer(BankAccount from, BankAccount to, double amount) {
            synchronized (from) {
                //in those lines the other transfer is getting the lock
                System.out.println("Lock acquired: " + from.name + " by: " + Thread.currentThread().getName());
                from.withdraw(amount);
                synchronized (to) {
                    System.out.println("Lock acquired: " + to.name + " by: " + Thread.currentThread().getName());
                    to.deposit(amount);
                }
            }
        }

        /**
         * SOLUTION
         * */
        public static void transferWithoutDeadLock(BankAccount from, BankAccount to, double amount) {
            synchronized (from) {
                synchronized (to) {
                    //get both locks
                    System.out.println("Lock acquired: " + from.name + " by: " + Thread.currentThread().getName());
                    System.out.println("Lock acquired: " + to.name + " by: " + Thread.currentThread().getName());

                    //with the 2 locks, execute the operations
                    from.withdraw(amount);
                    to.deposit(amount);
                }
            }
        }
    }
}