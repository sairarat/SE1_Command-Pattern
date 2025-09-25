package Light;

import Controller.Command;
import Controller.Device;
import java.util.Scanner;

public class Light implements Device {
    private boolean isOn;
    private int brightnessLevel;

    public Light() {
        this.isOn = false;
        this.brightnessLevel = 50;
    }

    @Override
    public String getDeviceName() {
        return "Light";
    }

    @Override
    public Command getCommandFromUser(Scanner scanner) {
        System.out.print("Select command: \n1. Turn On\n2. Turn Off\n3. Set Brightness\n4. Adjust Brightness: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                return new LightOnCommand(this);
            case 2:
                return new LightOffCommand(this);
            case 3:
                System.out.print("Enter brightness level (0-100): ");
                int level = scanner.nextInt();
                return (level >= 0 && level <= 100) ? new BrightnessCommand(this, level) : null;
            case 4:
                System.out.print("Enter brightness adjustment (-100 to 100): ");
                int delta = scanner.nextInt();
                return (delta >= -100 && delta <= 100) ? new BrightnessCommand(this, Math.min(100, Math.max(0, brightnessLevel + delta))) : null;
            default:
                System.out.println("Invalid command");
                return null;
        }
    }

    public void turnOn() {
        isOn = true;
        System.out.println("Light turned on");
    }

    public void turnOff() {
        isOn = false;
        System.out.println("Light turned off");
    }

    public void setBrightnessLevel(int level) {
        if (level >= 0 && level <= 100) {
            this.brightnessLevel = level;
            System.out.println("Brightness set to " + level + "%");
        } else {
            System.out.println("Brightness level must be between 0 and 100");
        }
    }
}