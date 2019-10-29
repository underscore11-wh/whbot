package com.gmail.minecrafter11mrt;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

public class Main {
    public static String ver = "v0.2";
    public static DiscordApi api = new DiscordApiBuilder().setToken("NjM4NDQwODEwMDgxMTU3MTIw.Xbe3LA.RJALW-FQVU3KoM01JmWUHjobmyM").login().join();
    public static void main(String[] args) {
        System.out.println("Logged in!");
        api.addListener(new MessageListener());
        api.updateActivity("-help");
    }
}
