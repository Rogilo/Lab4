package Music;

import Music.control.*;
import java.io.IOException;

/*Звукозапис. Визначити ієрархію музичних композицій. Записати на диск збірку.
        Підрахувати тривалість. Здійснити перестановку композицій диску на основі
        належності до стилю. Знайти композицію, що відповідає заданому діапазону
        довжини треків.*/

public class MusicApp
{
    public static void main( String[] args ) throws IOException {
        Menu musicApp = new Menu();
        musicApp.start();
    }
}