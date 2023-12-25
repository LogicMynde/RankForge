package dev.ericvega.rankforge.command;

import java.util.List;

import org.mineacademy.fo.command.SimpleSubCommand;

final class AddSubCommand extends SimpleSubCommand {

	AddSubCommand(RankCommandGroup parent) {
		super(parent, "add");

		setDescription("Adds a sub-rank to a player");
		setUsage("<Player> <Rank>"); // rank add <Player> <Rank>
		setMinArguments(2);
	}

	/**
	 * Perform the main command logic.
	 */
	@Override
	protected void onCommand() {
		checkConsole();
	}

	/**
	 * @see org.mineacademy.fo.command.SimpleCommand#tabComplete()
	 */
	@Override
	protected List<String> tabComplete() {
		return NO_COMPLETE;
	}
}
