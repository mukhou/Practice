package headfirstdesignpatterns.command.commands;

import headfirstdesignpatterns.command.model.Hottub;

public class HottubOffCommand implements Command {

    Hottub hottub;

    public HottubOffCommand(Hottub hottub){
        this.hottub = hottub;
    }

    @Override
    public void execute() {
        hottub.off();

    }

    @Override
    public void undo() {
        hottub.on();

    }
}
