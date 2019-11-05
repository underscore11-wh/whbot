package com.gmail.minecrafter11mrt;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.user.User;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

public class WHBot extends JavaPlugin {
    static String ver = "v0.2.11";
    static DiscordApi api;
    static User botowner;
    static Logger logger;
    static TextChannel borderForce;
    static Level loglevel;
    @Override
    public void onEnable() {
        logger=getLogger();
        this.saveDefaultConfig();
        loglevel=Level.FINEST;
        this.getLogger().setLevel(loglevel);
        String token=this.getConfig().getString("token");
        logger.log(Level.INFO,"Logging in with token "+token);
        api = new DiscordApiBuilder().setToken(token).login().join();
        logger.log(Level.INFO,"Logged in!");
        logger.log(Level.INFO,"Running WHBot "+ver);
        api.getOwner().thenAccept(owner ->{
            botowner=owner;
            logger.log(Level.INFO,"Botowner intialized",botowner);
        });
        api.getTextChannelById(this.getConfig().getLong("channels.border-force")).ifPresent(textChannel -> {
            borderForce=textChannel;
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
