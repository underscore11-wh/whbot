package com.gmail.minecrafter11mrt;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.channel.TextChannel;

public class Main {
    static String ver = "v0.2";
    static DiscordApi api = new DiscordApiBuilder().setToken("NjM4NDQwODEwMDgxMTU3MTIw.Xbe3LA.RJALW-FQVU3KoM01JmWUHjobmyM").login().join();
    static TextChannel logchannel;
    public static void main(String[] args) {
        System.out.println("Logged in!");
        api.getTextChannelById(638474520654512128L).ifPresent(textChannel ->{
            logchannel=textChannel;
        });
        api.addListener(new MessageListener());
        api.updateActivity("-help");
    }
}
