package hackerrank;

/**
 * Created with IntelliJ IDEA.
 * User: Urmi
 * Date: 3/1/18
 * Time: 4:05 PM
 * To change this template use File | Settings | File Templates.
 */
class BrokerageAccount extends BankAccount{

    public BrokerageAccount(String currency, int units) {
        super(currency, units);
    }

    @Override
    public ACCOUNT_TYPE getAccountType(){
        return ACCOUNT_TYPE.BRK;
    }


    public static String getName(){
        return "BrokerageAccount";
    }
}
