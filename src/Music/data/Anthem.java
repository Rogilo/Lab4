package Music.data;

public class Anthem extends Song {
    private final String event;

    public Anthem(String name, String performer, String genre, int duration,
                  String event) {
        super(name, performer, genre, duration);
        this.event = event;
    }

    @Override
    public String toString() {
        String s = super.toString();
        return "Anthem" + s.substring(4, s.length() - 1) +
                ", event='" + event + '\'' +
                '}';
    }
}
