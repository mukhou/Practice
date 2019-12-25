package threads;

public class BankAccount {
    double balance;
    int id;

    BankAccount(int id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    void withdraw(double amount) {
        // Wait to simulate io like database access ...
        try {Thread.sleep(10l);} catch (InterruptedException e) {}
        balance -= amount;
    }

    void deposit(double amount) {
        // Wait to simulate io like database access ...
        try {Thread.sleep(10l);} catch (InterruptedException e) {}
        balance += amount;
    }

    static void transfer(BankAccount from, BankAccount to, double amount){
        System.out.println("executing: " + Thread.currentThread().getName());
        synchronized (from){
            from.withdraw(amount);
        }
        System.out.println("executing: " + Thread.currentThread().getName());
        synchronized (to){
            to.deposit(amount);
        }
    }

}
