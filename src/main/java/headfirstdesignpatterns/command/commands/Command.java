package headfirstdesignpatterns.command.commands;

/**
 * Wikipedia: The Command Pattern is a behavioral design pattern in which an object is used to encapsulate all information needed
 * to perform an action or trigger an event at a later time.
 * This information includes the method name, the object that owns the method and values for the method parameters.
 * HFDP Book: The command pattern encapsulates a request as an object, thereby letting us parameterize other objects
 * with different requests, queue or log requests, and support undoable operations.
 */
public interface Command {

    void execute();

    void undo();
}
