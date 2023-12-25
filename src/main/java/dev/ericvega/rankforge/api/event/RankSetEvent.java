package dev.ericvega.rankforge.api.event;

import org.bukkit.event.HandlerList;
import org.mineacademy.fo.event.SimpleCancellableEvent;
import org.mineacademy.fo.event.SimpleEvent;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * Called when a primary Rank is set for a player
 */
@Getter
@Setter
@RequiredArgsConstructor
public final class RankSetEvent extends SimpleEvent {

	private static final HandlerList handlers = new HandlerList();

	//
	// A sample field parsed to this event
	//
	// private final Player player;

	@Override
	public HandlerList getHandlers() {
		return handlers;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}
}