package Music.control;

import Music.util.SongGenreComparator;
import Music.data.Disk;

public class SortByGenreCommand implements Command{
    private final Disk disk;

    public SortByGenreCommand(Disk disk) {
        this.disk = disk;
    }
    @Override
    public void execute() {
        disk.sort(new SongGenreComparator());
        System.out.println("Tracks sorted by genre: "+disk.toString()+"\n");
    }

}
