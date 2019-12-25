package headfirstdesignpatterns.observer;

/**
 * The Observer Pattern defines a one-to-many dependency between objects so that when one
 * object changes state, all of its dependents are notified and updated automatically.
 */
public interface Observer {
    void update(float temperature, float humidity, float pressure);
}