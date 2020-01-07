/* 
User: Urmi
Date: 1/6/2020 
Time: 10:09 PM
*/

package headfirstdesignpatterns.observer.loggerframework;

import java.util.HashMap;

public class MyApplication {

    public static void main(String[] args){
        LoggerSubjectImpl loggerImpl = new LoggerSubjectImpl(new HashMap<>());
        loggerImpl.messageReceived(new Message("runtime exception", MessageType.ERROR));
    }
}
