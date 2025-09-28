package MusicPlayer;

import Controller.Command;
import Controller.Device;
import java.util.Scanner;

public class MusicPlayer implements Device {
    private String playlistName;
    private int volumeLevel;

    public MusicPlayer(String playlistName) {
        this.playlistName = playlistName;
        this.volumeLevel = 50;
    }

    @Override
    public String getDeviceName() {
        return "Music Player";
    }

    @Override
    public Command getCommandFromUser(Scanner scanner) {
        System.out.print("Enter playlist name: ");
        scanner.nextLine(); 
        String playlistName = scanner.nextLine().trim(); 
        System.out.println("Debug: Trimmed playlist name: '" + playlistName + "'"); 
        MusicPlayer tempMusicPlayer = new MusicPlayer(playlistName); 
        System.out.print("Select command: \n1. Increase Volume\n2. Decrease Volume: ");
        int choice = scanner.nextInt();
        System.out.print("Enter volume change (1-100): ");
        int change = scanner.nextInt();
        if (change <= 0 || change > 100) {
            System.out.println("Volume change must be between 1 and 100");
            return null;
        }
        return (choice == 1) ? new MusicIncreaseVolumeCommand(tempMusicPlayer, change) : new MusicDecreaseVolumeCommand(tempMusicPlayer, change);
    }

    public void increaseVolume(int level) {
        this.volumeLevel += level;
        if (volumeLevel > 100) volumeLevel = 100;
        System.out.println("Volume increased to " + volumeLevel + "%");
        System.out.println("Currently playing: " + playlistName);
    }

    public void decreaseVolume(int level) {
        this.volumeLevel -= level;
        if (volumeLevel < 0) volumeLevel = 0;
        System.out.println("Volume decreased to " + volumeLevel + "% for currently playing: " + playlistName);
    }

}

