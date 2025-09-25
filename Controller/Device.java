package Controller;

import java.util.Scanner;

public interface Device {
    String getDeviceName();
    Command getCommandFromUser(Scanner scanner);
}