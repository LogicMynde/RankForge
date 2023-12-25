package dev.ericvega.rankforge.command;

import org.mineacademy.fo.annotation.AutoRegister;
import org.mineacademy.fo.command.SimpleCommandGroup;
import org.mineacademy.fo.model.SimpleComponent;

import java.util.Arrays;
import java.util.List;

@AutoRegister
public final class RankCommandGroup extends SimpleCommandGroup {

	public RankCommandGroup() {
		super("rank|r");
	}

	@Override
	protected List<SimpleComponent> getNoParamsHeader() {
		return Arrays.asList(
				SimpleComponent.of("Type /rank for more info"),
				SimpleComponent.of("Plugin made by ").append("@ericvegax").onClickOpenUrl("https://github.com/ericvegax"));
	}

	@Override
	protected String[] getHelpHeader() {
		return super.getHelpHeader();
	}

	@Override
	protected String getCredits() {
		return "&aVisit the plugin page on spigot for more information.";
	}

	@Override
	protected void registerSubcommands() {
		registerSubcommand(new SetSubCommand(this));
		registerSubcommand(new AddSubCommand(this));
		registerSubcommand(new RemoveSubCommand(this));
		registerSubcommand(new ClearSubCommand(this));
		registerSubcommand(new InfoSubCommand(this));
		registerSubcommand(new ListSubCommand(this));
		registerSubcommand(new CreateSubCommand(this));
		registerSubcommand(new DeleteSubCommand(this));
	}
}
