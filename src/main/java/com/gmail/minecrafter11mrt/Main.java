package com.gmail.minecrafter11mrt;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.user.User;

import java.io.File;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.configuration.*;

public class Main {
    static String ver = "v0.3.1";
    static DiscordApi api = new DiscordApiBuilder().setToken("NjM4NDQwODEwMDgxMTU3MTIw.Xbe3LA.RJALW-FQVU3KoM01JmWUHjobmyM").login().join();
    static TextChannel logchannel;
    static User botowner;
    private static Logger logger = Logger.getLogger("Main");
    private static Level loglevel=Level.FINEST;
    FileConfiguration config;
    public static void main(String[] args) {
        Main.initLogger(logger);
        logger.log(Level.INFO,"Logged in!");
        logger.log(Level.INFO,"Running Exambot "+ver);
        api.getTextChannelById(638474520654512128L).ifPresent(textChannel ->{
            logchannel=textChannel;
            logger.log(Level.FINE,"Logchannel initialized",logchannel);
        });
        api.getOwner().thenAccept(owner ->{
            botowner=owner;
            logger.log(Level.FINE,"Botowner intialized",botowner);
        });
        api.addListener(new MessageListener());
        api.updateActivity("-help | "+ver);
    }
    static void initLogger(Logger otherLogger){
        otherLogger.setLevel(loglevel);
        ConsoleHandler handler = new ConsoleHandler();
        handler.setLevel(Main.loglevel);
        if(otherLogger.getHandlers().length==0) {
            otherLogger.addHandler(handler);
        }
        //System.out.println("Active handlers for "+otherLogger.getName()+": "+otherLogger.getHandlers().length);
    }
}
