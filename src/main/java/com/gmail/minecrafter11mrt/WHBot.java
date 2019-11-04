package com.gmail.minecrafter11mrt;

import org.bukkit.plugin.PluginLogger;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.user.User;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

public class WHBot extends JavaPlugin {
    static String ver = "v0.1.2";
    static DiscordApi api;
    static User botowner;
    static Logger logger;

    @Override
    public void onEnable() {
        logger=getLogger();
        this.saveDefaultConfig();
        String token=this.getConfig().getString("token");
        logger.log(Level.INFO,"Logging in with token "+token);
        api = new DiscordApiBuilder().setToken(token).login().join();
        logger.log(Level.INFO,"Logged in!");
        logger.log(Level.INFO,"Running WHBot "+ver);
        api.getOwner().thenAccept(owner ->{
            botowner=owner;
            logger.log(Level.FINE,"Botowner intialized",botowner);
        });
        api.addListener(new MessageListener());
        api.updateActivity("-help | "+ver);
    }
    @Override
    public void onDisable() {
        api.disconnect();
        logger.log(Level.INFO,"Disconnected from Discord");
    }
}
