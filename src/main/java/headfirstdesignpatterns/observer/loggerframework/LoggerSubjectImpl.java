/* 
User: Urmi
Date: 1/6/2020 
Time: 10:00 PM
*/

package headfirstdesignpatterns.observer.loggerframework;

import java.util.Map;

public class LoggerSubjectImpl implements LoggerSubject {

    Map<MessageType, LoggingPlatform> platformMap;
    String content;
    MessageType messageType;

    public LoggerSubjectImpl(Map<MessageType, LoggingPlatform> platformMap) {
        this.platformMap = platformMap;
    }

    @Override
    public void registerLoggingPlatform(LoggingPlatform loggingPlatform, MessageType messageType) {
        this.platformMap.put(messageType, loggingPlatform);
    }

    @Override
    public void unRegisterLoggingPlatform(LoggingPlatform loggingPlatform, MessageType messageType) {
        this.platformMap.remove(messageType);

    }

    @Override
    public void notifyLoggingPlatform() {
        LoggingPlatform loggingPlatform = platformMap.get(messageType);
        if(loggingPlatform == null){
            System.out.println("logging platform not registere for message type: " + messageType);
            return;
        }
        loggingPlatform.log(content);
    }

    public void messageReceived(Message message) {
        this.content = message.getContent();
        this.messageType = message.getMessageType();
        notifyLoggingPlatform();
    }
}
