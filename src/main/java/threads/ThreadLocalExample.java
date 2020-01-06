/* 
User: Urmi
Date: 1/6/2020 
Time: 9:42 AM
*/

package threads;

public class ThreadLocalExample {

    private static ThreadLocal<BankAccount> instance = ThreadLocal.withInitial(() -> new BankAccount(1, 0));



}
