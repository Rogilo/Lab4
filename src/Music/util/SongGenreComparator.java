package Music.util;

import Music.data.Song;

import java.util.Comparator;

public class SongGenreComparator implements Comparator<Song> {
    public int compare(Song s1, Song s2) {
        return s1.getGenre().compareTo(s2.getGenre());
    }
}
