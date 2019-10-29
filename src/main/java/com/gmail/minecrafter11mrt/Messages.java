package com.gmail.minecrafter11mrt;

import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.entity.message.MessageBuilder;

import java.awt.*;

public class Messages {
    public static MessageBuilder help(){
        return new MessageBuilder().setEmbed(
                new EmbedBuilder()
                        .setTitle("Exambot")
                        .setFooter("Exambot "+Main.ver+" | Made by _11#8218", "https://cdn.discordapp.com/avatars/404882575543238656/238ea9cb4c0835a5a794fa7d93357320.png")
                        .addField("-help", "Displays this message.")
                        .addField("-exam", "Requests a train driving exam.\nFormat: `-exam <Timezone Code> <Attempts at exam> <Any other info>`\nExample: `-exam PST 0 I'm a bit of a slow learner`")
                        .addField("-ping", "Makes the bot send a message back. Intended for debugging.")
                        .setColor(Color.GREEN)
                        .setThumbnail(Main.api.getYourself().getAvatar())
        );
    }
}
