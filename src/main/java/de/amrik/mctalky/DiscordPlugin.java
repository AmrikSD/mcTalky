package de.amrik.mctalky;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.event.Event;

public class DiscordPlugin extends JavaPlugin{
		
		final String URL = "https://discordapp.com/api/webhooks/721823380223033446/ZxNPA6z34uvllz2_I50agFGy5NG7WAuaTYEdhRChcTVW5dS1qHxXNNyG-tcfc35MNzUW";

		@Override
		public void onEnable() {
				getLogger().info("onEnable is called!");
				getServer().getPluginManager().registerEvents(new ChatListener(), this);
		}
		
		@Override
		public void onDisable() {
				getLogger().info("onDisable is called!");
		}
		
		@EventHandler(priority = EventPriority.HIGH)
		public void asyncChatEvent(AsyncPlayerChatEvent e) {
				sendDiscordMessage(e);
		}
		
		@EventHandler(priority = EventPriority.HIGH)
		public void chatEvent(PlayerChatEvent e){
				sendDiscordMessage(e);
			getLogger().info("sfdgdgddggd");
		}

		public void sendDiscordMessage(PlayerEvent e){
				String p = e.getPlayer().getDisplayName();
				String msg;
				if(!e.isAsynchronous()){
						PlayerChatEvent pce = (PlayerChatEvent) e;
						msg = pce.getMessage();
				}else{
						AsyncPlayerChatEvent apce = (AsyncPlayerChatEvent) e;
						msg = apce.getMessage();
				}
				getLogger().info("Trying to send msg: "+p+ ": "+msg);		
		}
}
