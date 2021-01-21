package Music.data;

import java.util.Arrays;
import java.util.Comparator;

public class Disk {
    private Song[] tracks;
    private int size;
    private int length = 0;
    private int freeSpace;
    private int duration = 0;
    public Disk(int freeSpace) {
        size = 10;
        tracks = new Song[size];
        this.freeSpace = freeSpace;
    }

    private int getFreeSpace() {
        return freeSpace;
    }

    public int getDuration() {
        return duration;
    }

    public int getLength() {
        return length;
    }

    public void add(Song song) {
        if (song.getDuration() > freeSpace) {
            throw new IllegalArgumentException(song.getName()
                    + " (" + song.getDuration() + " sec)"
                    + " cannot fit the free space (" + getFreeSpace() + " sec)");
        }
        if (length == size) {
            resize();
        }

        tracks[length++] = song;
        freeSpace -= song.getDuration();
        duration += song.getDuration();
    }

    public Song get(int i) {
        if (i >= length) {
            throw new IndexOutOfBoundsException();
        }
        return tracks[i];
    }

    public void sort(Comparator<Song> comparator) {
        Arrays.sort(tracks, 0, length, comparator);
    }

    private void resize() {
        int newSize = size * 2;
        Song[] newTracks = new Song[newSize];

        System.arraycopy(tracks, 0, newTracks, 0, size);
        tracks = newTracks;
        size = newSize;
    }


    @Override
    public String toString() {
        StringBuilder strBuilder = new StringBuilder("Disk{\n");
        for (int i = 0; i < length; i++) {
            strBuilder.append(tracks[i].toString());
            strBuilder.append("\n");
        }
        strBuilder.append("}");
        return strBuilder.toString();
    }
}