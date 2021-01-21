package Music.util;

import Music.data.Anthem;
import Music.data.Disk;
import Music.data.Song;
import Music.data.Soundtrack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class SongsCSVReader {

    public static Disk writeDisk(Reader reader, int freeSpace)
            throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(reader)) {
            Disk disk = new Disk(freeSpace);
            String line;
            String delimiter = ",";
            String[] lineData;

            while ((line = bufferedReader.readLine()) != null) {
                lineData = line.split(delimiter);

                if (lineData.length < 5) {
                    continue;  // not enough arguments, skip the line
                }

                String className = lineData[0];


                if (!(classNameCheck(className))) {
                    continue;  // illegal classname, skip the line
                }

                String name = lineData[1];
                String performer = lineData[2];
                String genre = lineData[3];

                int duration = -1;
                try {
                    duration = Integer.parseInt(lineData[4]);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid duration: " + lineData[4]
                            + ". Must be a non-negative integer");
                }
                if (duration < 0) {
                    continue;
                }
                switch (className) {
                    case "Song":
                        Song song = new Song(name, performer, genre, duration);
                        disk.add(song);
                        break;
                    case "Anthem":
                        try {
                            String event = lineData[5];

                            Anthem anthem = new Anthem(name, performer,
                                    genre, duration, event);

                            disk.add(anthem);
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println(
                                    "Cannot create anthem, not enough data");
                        }
                        break;
                    case "Soundtrack":
                        try {
                            String game = lineData[5];
                            disk.add(new Soundtrack(name, performer, genre,
                                    duration, game));
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println(
                                    "Cannot create anthem, not enough data");
                        }
                        break;
                }
            }
            return disk;
        }
    }
    static boolean classNameCheck(String className) {
        for (int i = 0; i < 3; i++) {
            if(className.equals(SongTypes.Song.name()) || className.equals(SongTypes.Anthem.name()) ||
                    className.equals(SongTypes.Soundtrack.name())) {
                return true;
            }
        }
        return false;
    }
}