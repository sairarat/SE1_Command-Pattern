package Thermostat;

import Controller.Command;
import Controller.Device;
import java.util.Scanner;

public class Thermostat implements Device {
    private int temperature;
    private String roomName;

    public Thermostat(String roomName) {
        this.roomName = roomName;
        this.temperature = 20; 
    }

    @Override
    public String getDeviceName() {
        return "Thermostat";
    }

    @Override
    public Command getCommandFromUser(Scanner scanner) {
        System.out.print("Enter room name: ");
        scanner.nextLine(); 
        String roomName = scanner.nextLine().trim(); 
        System.out.println("Debug: Trimmed room name: '" + roomName + "'"); 
        Thermostat tempThermostat = new Thermostat(roomName); 
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
