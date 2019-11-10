package headfirstdesignpatterns.command.client;

import headfirstdesignpatterns.command.commands.*;
import headfirstdesignpatterns.command.invoker.RemoteControl;
import headfirstdesignpatterns.command.model.GarageDoor;
import headfirstdesignpatterns.command.model.Light;
import headfirstdesignpatterns.command.model.Stereo;

public class RemoteLoader {

    public static void main(String[] args){
        //create invoker
        RemoteControl remoteControl = new RemoteControl();

        //create receivers
        Light livingroomLight = new Light();
        Light kitchenLight = new Light();
        GarageDoor garageDoor = new GarageDoor();
        Stereo stereo = new Stereo();

        //create commands and assign receivers to them
        LightOnCommand livingroomLightOn = new LightOnCommand(livingroomLight);
        LightOffCommand livingroomLightOff = new LightOffCommand(livingroomLight);
        LightOnCommand kitchenLightOn = new LightOnCommand(kitchenLight);
        LightOffCommand kitchenLightOff = new LightOffCommand(kitchenLight);
        StereoOnCommand stereoOn = new StereoOnCommand(stereo);
        StereoOffCommand stereoOff = new StereoOffCommand(stereo);
        GarageDoorUpCommand garageDoorUp = new GarageDoorUpCommand(garageDoor);
        GarageDoorDownCommand garageDoorDown = new GarageDoorDownCommand(garageDoor);

        remoteControl.setCommand(0, livingroomLightOn, livingroomLightOff);
        remoteControl.setCommand(1, kitchenLightOn, kitchenLightOff);
        remoteControl.setCommand(2, stereoOn, stereoOff);
        remoteControl.setCommand(3, garageDoorUp, garageDoorDown);

        //make requests
        remoteControl.onButtonPush(0);
        remoteControl.offButtonPush(0);
        remoteControl.undoPush();
        remoteControl.offButtonPush(0);
        remoteControl.onButtonPush(0);
        remoteControl.undoPush();
        remoteControl.offButtonPush(3);

    }




}
