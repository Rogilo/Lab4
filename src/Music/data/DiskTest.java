package Music.data;

import org.junit.Test;

import static org.junit.Assert.*;

public class DiskTest {

    @Test
    public void getDuration() {
        Disk tested = new Disk(3600);
        Song soundtrack = new Soundtrack("Runnin' Down a Dream","Tom Petty", "Rock",
                368,"GTA:San Andreas");
        tested.add(soundtrack);
        assertEquals(368,tested.getDuration());
    }
    @Test
    public void getLength() {
        Disk tested = new Disk(3600);
        Song soundtrack = new Soundtrack("Runnin' Down a Dream","Tom Petty", "Rock",
                368,"GTA:San Andreas");
        tested.add(soundtrack);
        assertEquals(1,tested.getLength());
    }

    @Test
    public void add() {
        Disk tested = new Disk(3600);
        Song soundtrack = new Soundtrack("Runnin' Down a Dream","Tom Petty", "Rock",
                368,"GTA:San Andreas");
        tested.add(soundtrack);
        assertEquals(soundtrack,tested.get(0));
    }
}