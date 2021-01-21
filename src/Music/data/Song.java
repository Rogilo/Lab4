package Music.data;

public class Song {
    private final String name;
    private final String performer;
    private final String genre;
    private final int duration;

    public Song(String name, String performer, String genre, int duration) {
        this.name = name;
        this.performer = performer;
        this.genre = genre;

        if (duration < 0) {
            throw new IllegalArgumentException(
                    "Parameter duration must be non-negative integer");
        }
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public int getDuration() { return duration; }

    @Override
    public String toString() {
        return "Song{" +
                "name='" + name + '\'' +
                ", performer='" + performer + '\'' +
                ", genre='" + genre + '\'' +
                ", duration=" + duration +
                '}';
    }
}
