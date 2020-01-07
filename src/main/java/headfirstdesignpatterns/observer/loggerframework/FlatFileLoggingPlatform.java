/* 
User: Urmi
Date: 1/6/2020 
Time: 9:46 PM
*/

package headfirstdesignpatterns.observer.loggerframework;

public class FlatFileLoggingPlatform implements LoggingPlatform {

    @Override
    public void log(String content) {
        System.out.println(content);

    }
}
