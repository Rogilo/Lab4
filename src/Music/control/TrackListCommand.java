package Music.control;

import Music.data.Disk;

public class TrackListCommand implements Command {
    private final Disk disk;

    public TrackListCommand(Disk disk) {
        this.disk = disk;
    }
    @Override
    public void execute() {
        System.out.println(disk.toString()+"\n");
    }
}