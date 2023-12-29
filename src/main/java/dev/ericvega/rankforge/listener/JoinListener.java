package dev.ericvega.rankforge.listener;

import dev.ericvega.rankforge.RankForgePlugin;
import lombok.AccessLevel;
import lombok.Getter;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerJoinEvent;
import org.mineacademy.fo.annotation.AutoRegister;
import org.mineacademy.fo.event.SimpleListener;

@AutoRegister
public final class JoinListener extends SimpleListener<PlayerJoinEvent> {

    /**
     * The instance of this class, hidden because the only call to this class is from
     * the auto registration class.
     */
    @Getter(value = AccessLevel.PRIVATE)
    private static final JoinListener instance = new JoinListener();

    /**
     * Create a new chat listener, registered automatically
     */
    private JoinListener() {
        super(PlayerJoinEvent.class, EventPriority.LOWEST, true);
    }

    @Override
    protected void execute(PlayerJoinEvent event) {
        RankForgePlugin.getInstance().getRankDisplayManager().updatePlayerDisplay(event.getPlayer());
    }
}
