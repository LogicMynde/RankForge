package dev.ericvega.rankforge.command;

import java.util.List;

import dev.ericvega.rankforge.command.manager.Rank;
import dev.ericvega.rankforge.command.manager.RankManager;
import org.bukkit.entity.Player;
import org.mineacademy.fo.Common;
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

		RankManager manager = RankManager.getInstance();

		Player target = findPlayer(args[0], "Unable to locate &l{0}!");
		String subRankID = args[1];

		if (Rank.contains(Rank.getFromID(subRankID).getName())) {
			if (manager.getSubRanks(target).contains(Rank.getFromID(subRankID))) {
				tellError("{0} already has the sub-rank of {1}");
				return;
			}

			manager.addSubRank(target, Rank.getFromID(subRankID));

			tell("Successfully added the sub-rank of '{0}' to '{1}'");
			Common.tell(target, "Sub-rank of '{1}' has been added to your account!");
		} else {
			tell("'{1}' sub-rank does not exist!");
		}
	}

	/**
	 * @see org.mineacademy.fo.command.SimpleCommand#tabComplete()
	 */
	@Override
	protected List<String> tabComplete() {
		return super.tabComplete();
	}
}
