package hackerrank;

/**
 * Created with IntelliJ IDEA.
 * User: Urmi
 * Date: 3/1/18
 * Time: 4:05 PM
 * To change this template use File | Settings | File Templates.
 */
 class SavingsAccount  extends BankAccount{
    public SavingsAccount(String currency, int units) {
        super(currency, units);
    }
    public ACCOUNT_TYPE getAccountType(){
        return ACCOUNT_TYPE.SAV;
    }

    public String getName(){
        return ACCOUNT_TYPE.SAV.name();
    }
}
