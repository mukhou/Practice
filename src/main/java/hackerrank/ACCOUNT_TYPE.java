package hackerrank;

/**
 * Created with IntelliJ IDEA.
 * User: Urmi
 * Date: 3/1/18
 * Time: 4:18 PM
 * To change this template use File | Settings | File Templates.
 */
enum ACCOUNT_TYPE {
    SAV("Savings Account"),
    BRK("Brokerage Account"),
    CHE("Checking Account");

    private final String identifier;
    private ACCOUNT_TYPE(String identifier){
        this.identifier = identifier;
    }
    public  String getName() {
        return this.identifier;
    }
}
