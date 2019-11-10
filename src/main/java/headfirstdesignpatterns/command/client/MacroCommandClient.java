package headfirstdesignpatterns.command.client;

import headfirstdesignpatterns.command.commands.*;
import headfirstdesignpatterns.command.invoker.RemoteControl;
import headfirstdesignpatterns.command.model.Hottub;
import headfirstdesignpatterns.command.model.Light;
import headfirstdesignpatterns.command.model.Stereo;
import headfirstdesignpatterns.command.model.TV;

public class MacroCommandClient {

    public static void main(String[] args){

        RemoteControl remoteControl = new RemoteControl();

        Light livingroomLight = new Light();
        Stereo stereo = new Stereo();
        Hottub hottub = new Hottub();
        TV tv = new TV();

        LightOnCommand lightOnCommand = new LightOnCommand(livingroomLight);
        StereoOnCommand stereoOnCommand = new StereoOnCommand(stereo);
        HottubOnCommand hottubOnCommand = new HottubOnCommand(hottub);
        TVOnCommand tvOnCommand = new TVOnCommand(tv);

        LightOffCommand lightOffCommand = new LightOffCommand(livingroomLight);
        StereoOffCommand stereoOffCommand = new StereoOffCommand(stereo);
        HottubOffCommand hottubOffCommand = new HottubOffCommand(hottub);
        TVOffCommand tvOffCommand = new TVOffCommand(tv);

        //create two sets of commands, for on and off
        Command[] partyOnCommands = {lightOnCommand, stereoOnCommand, hottubOnCommand, tvOnCommand};
        Command[] partyOffCommands = {lightOffCommand, stereoOffCommand, hottubOffCommand, tvOffCommand};

        //create two macro commands, on and off
        MacroCommand partyOnMacro = new MacroCommand(partyOnCommands);
        MacroCommand partyOffMacro = new MacroCommand(partyOffCommands);

        //set macro
        remoteControl.setCommand(0, partyOnMacro, partyOffMacro);

        //push
        remoteControl.onButtonPush(0);
        remoteControl.offButtonPush(0);



    }
}
