package hackerrank;

/**
 * Created with IntelliJ IDEA.
 * User: Urmi
 * Date: 3/1/18
 * Time: 4:18 PM
 * To change this template use File | Settings | File Templates.
 */
enum ACCOUNT_TYPE {
    SAV("Savings"),
    BRK("Brokerage"),
    CHE("Checking");

    private final String identifier;
    private ACCOUNT_TYPE(String identifier){
        this.identifier = identifier;
    }
    public  String getName() {
        return this.identifier;
    }
}
