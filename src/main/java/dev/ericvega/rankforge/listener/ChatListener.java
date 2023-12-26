package dev.ericvega.rankforge.listener;

import dev.ericvega.rankforge.RankForgePlugin;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.mineacademy.fo.annotation.AutoRegister;
import org.mineacademy.fo.event.SimpleListener;

import lombok.AccessLevel;
import lombok.Getter;

@AutoRegister
public final class ChatListener extends SimpleListener<AsyncPlayerChatEvent> {

	/**
	 * The instance of this class, hidden because the only call to this class is from
	 * the auto registration class.
	 */
	@Getter(value = AccessLevel.PRIVATE)
	private static final ChatListener instance = new ChatListener();

	/**
	 * Create a new chat listener, registered automatically
	 */
	private ChatListener() {
		// we could potentially parse event priority and ignoreCancelled flag from a config
		super(AsyncPlayerChatEvent.class, EventPriority.NORMAL, true);
	}

	@Override
	protected void execute(AsyncPlayerChatEvent event) {
		event.setFormat(RankForgePlugin.getInstance().getRankDisplayManager().formatChatMessage());
	}
}
