package headfirstdesignpatterns.state;

/**
 * The State Pattern allows an object to alter its behavior when its internal state changes.
 * The state pattern is set to solve two main problems: *
 * 1. An object should change its behavior when its internal state changes.
 * 2. State-specific behavior should be defined independently. That is, adding new states should not affect the behavior of existing states.
 */
public interface State {

    void insertQuarter();
    void ejectQuarter();
    void turnCrank();
    void dispense();


}
