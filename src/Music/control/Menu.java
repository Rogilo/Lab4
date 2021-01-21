package Music.control;

import Music.data.Disk;
import Music.util.SongsCSVReader;
import Music.logging.Log;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Menu {
    private Log log; {
        try {
            log = new Log("Logger.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void start () throws IOException {
        log.getLogger().info("Write down the address of the file");
        String filename = "C:\\Users\\Drmbm\\IdeaProjects\\Lab_4\\src\\Music\\resources\\parameters.cvs";
        int freeSpace = 3600;
        FileReader reader = new FileReader(filename);
        Disk disk = SongsCSVReader.writeDisk(reader, freeSpace);
        runCommand(disk);
    }
    public static void printMenuInfo() {
        System.out.println("""
                1) Display all tracks on the screen.
                2) Calculate the duration of the all tracks.
                3) Rearrange the disc tracks on the base belonging to the style.
                4) Find a song that matches the given range track lengths.
                5) Exit""");
    }

    public  void runCommand(Disk disk) {
        CommandsFactory factory = new CommandsFactory();
        Scanner enter = new Scanner(System.in);
        int choice;
        do {
            log.getLogger().info("run 'printMenuInfo' function");
            printMenuInfo();
            choice = enter.nextInt();
            switch (choice) {
                case 1 -> {
                    log.getLogger().info("run 'trackList' command");
                    factory.getCommand(CommandsTypes.TRACKLISTCOMMAND,disk).execute();
                }
                case 2 -> {
                    log.getLogger().info("run 'trackListDuration' command");
                    factory.getCommand(CommandsTypes.TRACKLISTDURATIONCOMMAND,disk).execute();
                }
                case 3 -> {
                    log.getLogger().info("run 'sortByGenre' command");
                    factory.getCommand(CommandsTypes.SORTBYGENRECOMMAND,disk).execute();
                }
                case 4 -> {
                    log.getLogger().info("run 'findByDuration' command");
                    factory.getCommand(CommandsTypes.FINDBYDURATIONCOMMAND,disk).execute();
                }
                case 5 ->{
                    log.getLogger().info("exit the program");
                    System.exit(0);
                }
                default -> {
                    log.getLogger().info("invalid request in menu choice");
                    System.out.println("Invalid request");
                    System.exit(1);
                }
            }
        }while(true);
    }
}
