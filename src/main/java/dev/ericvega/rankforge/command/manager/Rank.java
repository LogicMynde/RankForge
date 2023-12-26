package dev.ericvega.rankforge.command.manager;

import lombok.Getter;
import org.bukkit.ChatColor;
import org.mineacademy.fo.Common;

@Getter
public enum Rank {

    OWNER("owner", ChatColor.DARK_RED, true, false, 7, "owner"),
    ADMIN("admin", ChatColor.RED, true, false, 6, "admin"),
    DEVELOPER("dev", ChatColor.RED, true, false, 5, "dev"),
    BUILDER("builder", ChatColor.BLUE, true, false, 4, "builder"),
    MODERATOR("mod", ChatColor.DARK_GREEN, true, false, 3, "mod"),
    HELPER("helper", ChatColor.GOLD, true, false, 2, "helper"),
    DEFAULT("", null, false, false, 1, "default");

    private final String name;
    private final ChatColor color;
    private final boolean bold;
    private final boolean italic;
    private final int level;
    private final String id;

    Rank(String name, ChatColor color, boolean bold, boolean italic, int level, String id) {
        this.name = name;
        this.color = color;
        this.bold = bold;
        this.italic = italic;
        this.level = level;
        this.id = id;
    }

    public static boolean contains(String rank) {
        for (Rank ranks : Rank.values()) {
            if (ranks.name.equals(rank)) {
                return true;
            }
        }
        return false;
    }

    public boolean isHigher(Rank compare) {
        return this.level > compare.level;
    }

    public boolean isLower(Rank compare) {
        return this.level < compare.level;
    }

    public boolean isLowerOrEqualTo(Rank compare) {
        return this.level <= compare.level;
    }

    public String getPrefix() {
        String name = this.name.toUpperCase();

        if (bold && italic) return Common.colorize(this.color + "&o&l" + name + ChatColor.RESET);
        if (bold) return Common.colorize(this.color + "&l" + name + ChatColor.RESET);
        if (italic) return Common.colorize(this.color + "&o" + name + ChatColor.RESET);

        return Common.colorize(this.color + name + ChatColor.RESET);
    }

    public static Rank getFromID(String id) {
        for (Rank rank : Rank.values()) {
            if (rank.getId().equals(id)) {
                return rank;
            }
        }
        return Rank.DEFAULT;
    }
}
