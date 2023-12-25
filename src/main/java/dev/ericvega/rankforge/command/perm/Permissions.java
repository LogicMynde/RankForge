package dev.ericvega.rankforge.command.perm;

import org.mineacademy.fo.command.annotation.Permission;
import org.mineacademy.fo.command.annotation.PermissionGroup;

/**
 * Way of keeping all permissions in one place.
 */
public final class Permissions {

	@PermissionGroup("Execute main plugin command for /{label}.")
	public static final class Command {

		@Permission("Resets a player's ranks to default")
		public static final String CLEAR = "rankforge.command.clear";

		@Permission("Sets a player's primary rank")
		public static final String SET = "rankforge.command.set";

		@Permission("Adds a sub-rank to a player")
		public static final String ADD = "rankforge.command.add";

		@Permission("Removes a sub-rank from a player")
		public static final String REMOVE = "rankforge.command.remove";

		@Permission("Lists all existing ranks")
		public static final String LIST = "rankforge.command.list";

		@Permission("Displays a player's rank information")
		public static final String INFO = "rankforge.command.info";

		@Permission("Creates a rank")
		public static final String CREATE = "rankforge.command.create";

		@Permission("Deletes a rank")
		public static final String DELETE = "rankforge.command.delete";
	}
}
