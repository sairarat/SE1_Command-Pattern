package Light;

import Controller.Command;
import Controller.CentralHub;

public class LightControl {
    public static void main(String[] args){

        Light light = new Light();
        Command lightOn = new LightOnCommand(light);
        Command brighteness = new BrightnessCommand(light, 75);
        Command lightOff = new LightOffCommand(light);

        lightOn.execute();
        brighteness.execute();
        lightOff.execute();

    }
}
