package MusicPlayer;

import Controller.Command;

public class MusicIncreaseVolumeCommand implements Command {
    private MusicPlayer musicPlayer;
    private int level;

    public MusicIncreaseVolumeCommand(MusicPlayer musicPlayer, int level) {
        this.musicPlayer = musicPlayer;
        this.level = level;
    }

    @Override
    public void execute() {
        musicPlayer.increaseVolume(level);
    }

    @Override
    public void undo() {
        musicPlayer.decreaseVolume(level);
    }
}