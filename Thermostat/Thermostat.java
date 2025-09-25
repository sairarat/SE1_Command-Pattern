package Thermostat;

import Controller.Command;
import Controller.Device;
import java.util.Scanner;

public class Thermostat implements Device {
    private int temperature;
    private String roomName;

    public Thermostat(String roomName) {
        this.roomName = roomName;
        this.temperature = 20; // Default in Celsius
    }

    @Override
    public String getDeviceName() {
        return "Thermostat";
    }

    @Override
    public Command getCommandFromUser(Scanner scanner) {
        System.out.print("Enter room name: ");
        scanner.nextLine(); // Consume newline left-over
        String roomName = scanner.nextLine().trim(); // Read full line and trim whitespace
        System.out.println("Debug: Trimmed room name: '" + roomName + "'"); // Debug to confirm trimming
        Thermostat tempThermostat = new Thermostat(roomName); // Create new instance with trimmed room
        System.out.print("Select command: \n1. Increase Temperature\n2. Decrease Temperature: ");
        int choice = scanner.nextInt();
        System.out.print("Enter degrees (1-100): ");
        int degrees = scanner.nextInt();
        if (degrees <= 0 || degrees > 100) {
            System.out.println("Degrees must be between 1 and 100");
            return null;
        }
        return (choice == 1) ? new ThermostatIncreaseCommand(tempThermostat, degrees) : new ThermostatDecreaseCommand(tempThermostat, degrees);
    }

    public void increaseTemperature(int degrees) {
        this.temperature += degrees;
        System.out.println("Temperature in " + roomName + " increased to " + temperature + "°C");
    }

    public void decreaseTemperature(int degrees) {
        this.temperature -= degrees;
        System.out.println("Temperature in " + roomName + " decreased to " + temperature + "°C");
    }
}