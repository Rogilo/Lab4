package Music.control;

import Music.data.Disk;
import Music.data.Song;
import Music.util.UserInputParser;

public class FindByDurationCommand implements Command {
    private final Disk disk;
    int minDuration;
    int maxDuration;

    public FindByDurationCommand(Disk disk) {
        this.disk = disk;
    }
    private void findByDuration() {
        Song desiredTrack=null;
        Song currSong;
        System.out.println("Enter min duration");
        minDuration = UserInputParser.getDuration();
        System.out.println("Enter max duration");
        maxDuration = UserInputParser.getDuration();
        for (int i = 0; i < disk.getLength(); i++) {
            currSong = disk.get(i);
            if (currSong.getDuration() >= minDuration && currSong.getDuration() <= maxDuration) {
                desiredTrack = currSong;
                break;
            }
        }
        if (desiredTrack == null) {
            System.out.println("There is no track with specified duration");
        } else {
            System.out.println("The first track with duration in between "
                    + minDuration + " and " + maxDuration + " sec: "
                    + desiredTrack);
        }
    }
    @Override
    public void execute() {
      findByDuration();
    }
}
