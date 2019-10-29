package com.gmail.minecrafter11mrt;

import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.embed.EmbedBuilder;

import java.awt.*;

public class PrefabMessages {

    public static MessageBuilder helpmessage(){
        return new MessageBuilder().setEmbed(new EmbedBuilder()
                .setTitle("Exambot")
                .setFooter("Exambot v0.1 | Made by _11#8218", "https://cdn.discordapp.com/avatars/404882575543238656/238ea9cb4c0835a5a794fa7d93357320.png")
                .addField("-help", "Displays this message.")
                .addField("-exam", "Requests a train driving exam.\nFormat: `-exam <Timezone Code> <Attempts at exam> <Any other info>`\nExample: `-exam PST 0 I'm a bit of a slow learner`")
                .addField("-ping", "Makes the bot send a message back. Intended for debugging.")
                .setColor(Color.GREEN)
                .setThumbnail(Main.api.getYourself().getAvatar()));
    }
}
