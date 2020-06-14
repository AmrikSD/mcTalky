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
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import club.minnced.discord.webhook.WebhookClient;
import club.minnced.discord.webhook.WebhookClientBuilder;


public class ChatListener implements Listener{
		
		final String URL = "https://discordapp.com/api/webhooks/721823380223033446/ZxNPA6z34uvllz2_I50agFGy5NG7WAuaTYEdhRChcTVW5dS1qHxXNNyG-tcfc35MNzUW";
	
		WebhookClientBuilder builder = new WebhookClientBuilder(URL); // or id, token
		WebhookClient client = builder.build();
		
		
		/*@EventHandler(priority = EventPriority.HIGH)
		public void asyncChatEvent(AsyncPlayerChatEvent e) {
				sendDiscordMessage(e);
		}*/	

		@EventHandler(priority = EventPriority.HIGH)
		public void chatEvent(PlayerChatEvent e){
				sendPlayerChatEventMessage(e);
		}

		@EventHandler(priority = EventPriority.HIGH)
		public void onPlayerJoin(PlayerJoinEvent e){
				String p = e.getPlayer().getDisplayName();
				client.send("**"+p +"** Has joined the minecraft server!");
		}

		@EventHandler(priority = EventPriority.HIGH)
		public void onPlayerQuit(PlayerQuitEvent e){
				String p = e.getPlayer().getDisplayName();
				client.send("**"+p+"** Has left the minecraft server!");
		}


		public void sendPlayerChatEventMessage(PlayerChatEvent e){
				String p = e.getPlayer().getDisplayName();
				String msg;
				
				msg = e.getMessage();
				client.send("**"+p+"**: "+msg);
		}
}
