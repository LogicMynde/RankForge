package dev.ericvega.rankforge.command;

import dev.ericvega.rankforge.command.manager.RankManager;
import org.mineacademy.fo.command.SimpleCommandGroup;
import org.mineacademy.fo.command.SimpleSubCommand;

public class DeleteSubCommand extends SimpleSubCommand {

    protected DeleteSubCommand(SimpleCommandGroup parent) {
        super(parent, "delete");

        setDescription("Deletes a rank");
        setUsage("<ID>"); // rank delete <Rank ID>
        setMinArguments(1);
    }

    @Override
    protected void onCommand() {
        checkConsole();

        RankManager manager = RankManager.getInstance();

        String rankID = args[0];
    }
}
