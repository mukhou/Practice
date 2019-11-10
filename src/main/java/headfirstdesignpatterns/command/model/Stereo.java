package headfirstdesignpatterns.command.model;

public class Stereo {

    int volume;

    public void on(){
        System.out.println("Light on");
    }

    public void off(){
        System.out.println("Light off");
    }

    public void setCD(){

    }

    public void setVolume(int vol){
        this.volume = vol;
    }
}
