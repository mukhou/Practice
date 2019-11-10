package headfirstdesignpatterns.command.commands;

import headfirstdesignpatterns.command.model.GarageDoor;

public class GarageDoorDownCommand implements Command {
    GarageDoor garageDoor;

    public GarageDoorDownCommand(GarageDoor garageDoor){
        this.garageDoor = garageDoor;
    }
    @Override
    public void execute() {
        garageDoor.close();

    }

    @Override
    public void undo() {
        garageDoor.open();
    }
}
