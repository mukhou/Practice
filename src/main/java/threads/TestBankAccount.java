package threads;

public class TestBankAccount implements Runnable {

    BankAccount fooAccount;
    BankAccount barAccount;

    public TestBankAccount(BankAccount fooAccount, BankAccount barAccount) {
        this.fooAccount = fooAccount;
        this.barAccount = barAccount;
    }

    @Override
    public void run() {
        BankAccount.transfer(fooAccount, barAccount, 10d);
    }

    public static void main(String[] args) {

        BankAccount fooAccount = new BankAccount(1, 100d);
        BankAccount barAccount = new BankAccount(2, 100d);


        Thread t1 = new Thread(new TestBankAccount(fooAccount, barAccount));
        Thread t2 = new Thread(new TestBankAccount(barAccount, fooAccount));

        t1.setName("A");
        t2.setName("B");
        t1.start();
        t2.start();


    }
}
