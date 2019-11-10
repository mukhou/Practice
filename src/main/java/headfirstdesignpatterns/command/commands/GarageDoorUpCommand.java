package headfirstdesignpatterns.command.commands;

import headfirstdesignpatterns.command.model.GarageDoor;

public class GarageDoorUpCommand implements Command {

    GarageDoor garageDoor;

    public GarageDoorUpCommand(GarageDoor garageDoor){
        this.garageDoor = garageDoor;
    }
    @Override
    public void execute() {
        garageDoor.open();

    }

    @Override
    public void undo() {
        garageDoor.close();
    }
}
