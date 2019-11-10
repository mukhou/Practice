package headfirstdesignpatterns.command.invoker;

import headfirstdesignpatterns.command.commands.Command;
import headfirstdesignpatterns.command.commands.NoCommand;

public class RemoteControl {

    Command[] onCommands;
    Command[] offCommands;
    Command undoCommand;

    public RemoteControl(){
        onCommands = new Command[7];
        offCommands = new  Command[7];
        Command  noc = new NoCommand();
        for(int i = 0; i < 7; i++){
            onCommands[i] = noc;
            offCommands[i] = noc;
        }
        undoCommand = noc;
    }

    public void setCommand(int slot, Command onCommand, Command offCommand){
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonPush(int slot){
        onCommands[slot].execute();
        undoCommand = onCommands[slot];
    }

    public void offButtonPush(int slot){
        offCommands[slot].execute();
        undoCommand = offCommands[slot];
    }

    public void undoPush(){
        undoCommand.undo();
    }
}
