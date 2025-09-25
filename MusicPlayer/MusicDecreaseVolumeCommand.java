package MusicPlayer;

import Controller.Command;

public class MusicDecreaseVolumeCommand implements Command {
    private MusicPlayer musicPlayer;
    private int level;

    public MusicDecreaseVolumeCommand(MusicPlayer musicPlayer, int level) {
        this.musicPlayer = musicPlayer;
        this.level = level;
    }

    @Override
    public void execute() {
        musicPlayer.decreaseVolume(level);
    }

    @Override
    public void undo() {
        musicPlayer.increaseVolume(level);
    }
}