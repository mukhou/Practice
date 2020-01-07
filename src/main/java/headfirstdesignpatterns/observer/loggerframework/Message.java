/* 
User: Urmi
Date: 1/6/2020 
Time: 9:55 PM
*/

package headfirstdesignpatterns.observer.loggerframework;

public class Message {

    String content;
    MessageType messageType;

    public Message(String content, MessageType messageType) {
        this.content = content;
        this.messageType = messageType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }
}
