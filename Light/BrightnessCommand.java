package Light;

import Controller.Command;

public class BrightnessCommand implements Command {
    private Light light;
    private int level;

    public BrightnessCommand(Light light, int level) {
        this.light = light;
        this.level = level;
    }

    @Override
    public void execute() {
        light.setBrightnessLevel(level);
    }

    @Override
    public void undo() {
        light.setBrightnessLevel(50); // Reset to default
    }
}