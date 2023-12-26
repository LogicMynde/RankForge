package dev.ericvega.rankforge;

import dev.ericvega.rankforge.command.manager.RankDisplayManager;
import lombok.Getter;
import org.mineacademy.fo.plugin.SimplePlugin;

@Getter
public final class RankForgePlugin extends SimplePlugin {

	private RankDisplayManager rankDisplayManager;

	@Override
	protected void onPluginStart() {
		rankDisplayManager = new RankDisplayManager();
	}

	/**
	 * Automatically perform login when the plugin starts and each time it is reloaded.
	 */
	@Override
	protected void onReloadablesStart() {

		// You can check for necessary plugins and disable loading if they are missing
		//Valid.checkBoolean(HookManager.isVaultLoaded(), "You need to install Vault so that we can work with packets, offline player data, prefixes and groups.");

		// Uncomment to load variables
		// Variable.loadVariables();

		//
		// Add your own plugin parts to load automatically here
		// Please see @AutoRegister for parts you do not have to register manually
		//
	}

	@Override
	protected void onPluginPreReload() {

		// Close your database here if you use one
		//YourDatabase.getInstance().close();
	}

	/* ------------------------------------------------------------------------------- */
	/* Static */
	/* ------------------------------------------------------------------------------- */

	/**
	 * Return the instance of this plugin, which simply refers to a static
	 * field already created for you in SimplePlugin but casts it to your
	 * specific plugin instance for your convenience.
	 *
	 * @return
	 */
	public static RankForgePlugin getInstance() {
		return (RankForgePlugin) SimplePlugin.getInstance();
	}

}
