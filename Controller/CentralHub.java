package Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CentralHub {
    private List<Device> devices;
    private List<Command> commands;
    private Scanner scanner;

    public CentralHub() {
        this.devices = new ArrayList<>();
        this.commands = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        devices.add(new Light.Light());
        devices.add(new Thermostat.Thermostat("Living Room"));
        devices.add(new MusicPlayer.MusicPlayer("Default Playlist"));
    }

    public void run() {
        while (true) {
            System.out.println("\n1. Add Command\n2. Execute Last Command\n3. Undo Last Command\n4. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addCommand();
                    break;
                case 2:
                    executeLastCommand();
                    break;
                case 3:
                    undoLastCommand();
                    break;
                case 4:
                    System.out.println("Exit Program");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid command");
            }
        }
    }

    private void addCommand() {
        if (devices.isEmpty()) {
            System.out.println("No devices registered.");
            return;
        }

        System.out.println("Available devices:");
        for (int i = 0; i < devices.size(); i++) {
            System.out.println((i + 1) + ". " + devices.get(i).getDeviceName());
        }
        System.out.print("Select device (1-" + devices.size() + "): ");
        int deviceChoice = scanner.nextInt() - 1;
        if (deviceChoice < 0 || deviceChoice >= devices.size()) {
            System.out.println("Invalid device");
            return;
        }

        Device selectedDevice = devices.get(deviceChoice);
        Command command = selectedDevice.getCommandFromUser(scanner);
        if (command != null) {
            commands.add(command);
            System.out.println("Command Added Successfully");
        }
    }

    private void executeLastCommand() {
        if (!commands.isEmpty()) {
            System.out.println("Executing last command...");
            commands.get(commands.size() - 1).execute();
        } else {
            System.out.println("No command executed");
        }
    }

    private void undoLastCommand() {
        if (!commands.isEmpty()) {
            System.out.println("Undoing last command...");
            commands.get(commands.size() - 1).undo();
            commands.remove(commands.size() - 1);
        } else {
            System.out.println("No commands to undo");
        }
    }

    public static void main(String[] args) {
        CentralHub c = new CentralHub();
        c.run();
    }

    public void registerDevice(Device device) {
        devices.add(device);
        System.out.println("Registered new device: " + device.getDeviceName());
    }

}
