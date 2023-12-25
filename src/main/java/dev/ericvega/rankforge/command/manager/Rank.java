package dev.ericvega.rankforge.command.manager;

import lombok.Getter;
import lombok.Setter;

/**
 * Represents each rank
 */
@Setter
@Getter
public class Rank {

    private String id;
    private String displayName;

    public Rank(String id, String displayName) {
        this.id = id;
        this.displayName = displayName;
    }
}
