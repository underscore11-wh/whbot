package com.gmail.minecrafter11mrt;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

public class Exambot {
    public static String ver = "v0.2";
    public static DiscordApi api = new DiscordApiBuilder().setToken("NjM4NDQwODEwMDgxMTU3MTIw.XbcwXw.HSi8fJr8_Rv7u-KAgDOvq7luYeQ").login().join();
    public static void main(String[] args) {
        System.out.println("Logged in!");
        api.addListener(new MessageClass());
        api.updateActivity("-help");
    }
}
