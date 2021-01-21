package Music.control;

import Music.data.Disk;

public class TrackListDurationCommand implements Command {
    private final Disk disk;

    public TrackListDurationCommand(Disk disk) {
        this.disk = disk;
    }

    @Override
    public void execute() {
        System.out.println("Total disk duration: " +   disk.getDuration()
                + " sec\n");
    }

}
