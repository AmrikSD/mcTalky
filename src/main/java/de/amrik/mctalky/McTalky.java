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

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.util.*;
import java.io.InputStreamReader;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class McTalky extends JavaPlugin{
		
		String URL;

		@Override
		public void onEnable() {
				getLogger().info("Starting mcTalky!");

				getLogger().info("Saving default configuration");
				saveDefaultConfig();


				URL = getConfig().getString("webhook");
				if(URL==null){
						getLogger().warning("webhook appears to be empty, did you configure properly?");
						getLogger().severe("Plugin will exit without a proper webhook URL, see the documentation for help.");
				}else{
						getLogger().info("Loaded webhook "+URL);
						getLogger().info("Starting the chat listener.");
						getServer().getPluginManager().registerEvents(new ChatListener(URL), this);
				}
		}
		
		@Override
		public void onDisable() {
				getLogger().info("Bye!");
		}	
}
