package Music.data;

public class Soundtrack extends Song {
    private final String game;

    public Soundtrack(String name, String performer, String genre, int duration,
                      String game) {
        super(name, performer, genre, duration);
        this.game = game;
    }

    @Override
    public String toString() {
        String s = super.toString();
        return "Soundtrack" + s.substring(4, s.length() - 1) +
                ", game='" + game + '\'' +
                '}';
    }
}
