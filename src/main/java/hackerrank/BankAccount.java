package hackerrank;

/**
 * Created with IntelliJ IDEA.
 * User: Urmi
 * Date: 3/1/18
 * Time: 4:05 PM
 * To change this template use File | Settings | File Templates.
 */
 abstract class BankAccount {
    public BankAccount(String currency, int units){
        this.currency = currency;
        this.units = units;
    }

    abstract public ACCOUNT_TYPE  getAccountType();

    String getCurrency() {
        return currency;
    }

    void setCurrency(String currency) {
        this.currency = currency;
    }

    int getUnits() {
        return units;
    }

    void setUnits(int units) {
        this.units = units;
    }

    protected String currency;
    protected int units;


}
