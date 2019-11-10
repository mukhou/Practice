package headfirstdesignpatterns.command.commands;

import headfirstdesignpatterns.command.model.Stereo;

public class StereoOffCommand implements Command {

    Stereo stereo;

    public StereoOffCommand(Stereo stereo){
        this.stereo = stereo;
    }
    @Override
    public void execute() {
        stereo.off();

    }

    @Override
    public void undo() {
        stereo.on();
    }
}
