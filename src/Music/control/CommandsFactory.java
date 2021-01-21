package Music.control;

import Music.data.Disk;

import java.util.HashMap;


public class CommandsFactory {

    public Command getCommand(CommandsTypes type,Disk data) {
        HashMap<CommandsTypes, Command> commandsHashMap = new HashMap<>();
        commandsHashMap.put(CommandsTypes.FINDBYDURATIONCOMMAND, new FindByDurationCommand(data));
        commandsHashMap.put(CommandsTypes.SORTBYGENRECOMMAND,new SortByGenreCommand(data));
        commandsHashMap.put(CommandsTypes.TRACKLISTCOMMAND,new TrackListCommand(data));
        commandsHashMap.put(CommandsTypes.TRACKLISTDURATIONCOMMAND,new TrackListDurationCommand(data));
        switch (type) {
            case FINDBYDURATIONCOMMAND -> {
                if (commandsHashMap.containsKey(CommandsTypes.FINDBYDURATIONCOMMAND)) {
                    return commandsHashMap.get(CommandsTypes.FINDBYDURATIONCOMMAND);
                }
                else {
                    Command findBy = new FindByDurationCommand(data);
                    return commandsHashMap.put(CommandsTypes.FINDBYDURATIONCOMMAND,findBy);
                }
            }
            case SORTBYGENRECOMMAND -> {
                if (commandsHashMap.containsKey(CommandsTypes.SORTBYGENRECOMMAND)) {
                    return commandsHashMap.get(CommandsTypes.SORTBYGENRECOMMAND);
                } else {
                    Command sort = new SortByGenreCommand(data);
                    return commandsHashMap.put(CommandsTypes.SORTBYGENRECOMMAND,sort);
                }
            }
            case TRACKLISTCOMMAND -> {
                if (commandsHashMap.containsKey(CommandsTypes.TRACKLISTCOMMAND)) {
                    return commandsHashMap.get(CommandsTypes.TRACKLISTCOMMAND);
                } else {
                    Command trackList = new TrackListCommand(data);
                    return commandsHashMap.put(CommandsTypes.TRACKLISTCOMMAND,trackList);
                }
            }
            case TRACKLISTDURATIONCOMMAND -> {
                if (commandsHashMap.containsKey(CommandsTypes.TRACKLISTDURATIONCOMMAND)) {
                    return commandsHashMap.get(CommandsTypes.TRACKLISTDURATIONCOMMAND);
                } else {
                    Command trackDuration = new TrackListDurationCommand(data);
                    return commandsHashMap.put(CommandsTypes.TRACKLISTDURATIONCOMMAND,trackDuration);
                }
            }
            default -> throw new IllegalArgumentException("Wrong command type:" + type);
        }
    }
}
