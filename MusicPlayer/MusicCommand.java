package MusicPlayer;

import Controller.Command;

public abstract class MusicCommand implements Command {
    protected MusicPlayer musicPlayer;

    public MusicCommand(MusicPlayer musicPlayer) {
        this.musicPlayer = musicPlayer;
    }
}