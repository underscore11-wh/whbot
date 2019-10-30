package com.gmail.minecrafter11mrt;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.user.User;
import com.gmail.minecrafter11mrt.lib.*;

import java.util.HashMap;

public class Main {
    static String ver = "v0.2";
    static DiscordApi api = new DiscordApiBuilder().setToken("NjM4NDQwODEwMDgxMTU3MTIw.Xbe3LA.RJALW-FQVU3KoM01JmWUHjobmyM").login().join();
    static TextChannel logchannel;
    static TextChannel queuechannel;
    static HashMap<Long,Long> queuemessages;
    static User botowner;
    static Logger logger = new Logger("Main");
    public static void main(String[] args) {
        logger.setLogLevel(LogLevel.DEBUG);
        logger.println("Logged in!",LogLevel.INFO);
        api.getTextChannelById(638474520654512128L).ifPresent(textChannel ->{
            logchannel=textChannel;
        });
        api.getTextChannelById(639126494232182784L).ifPresent(textChannel ->{
            queuechannel=textChannel;
        });
        api.getOwner().thenAccept(owner ->{
            botowner=owner;
        });
        api.addListener(new MessageListener());
        api.updateActivity("-help");
    }
}
