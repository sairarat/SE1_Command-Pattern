package Light;

import Controller.Command;
import Controller.CentralHub;

abstract class LightCommand implements Controller.Command {
    protected Light light;

    public LightCommand(Light light){

        this.light = light;
    }
}
