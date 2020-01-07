/* 
User: Urmi
Date: 1/6/2020 
Time: 9:43 PM
*/

package headfirstdesignpatterns.observer.loggerframework;

public interface LoggerSubject {
    void registerLoggingPlatform(LoggingPlatform loggingPlatform, MessageType messageType);
    void unRegisterLoggingPlatform(LoggingPlatform loggingPlatform, MessageType messageType);
    void notifyLoggingPlatform();
}
