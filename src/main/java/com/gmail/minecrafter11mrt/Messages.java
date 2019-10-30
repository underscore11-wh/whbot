package com.gmail.minecrafter11mrt;

import org.javacord.api.entity.message.MessageAuthor;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.entity.message.MessageBuilder;
import com.gmail.minecrafter11mrt.lib.*;

import java.awt.*;

public class Messages {
    static Logger logger = new Logger("Messages");
    static MessageBuilder help(){
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

     static MessageBuilder newrequest(MessageAuthor user, String tz, String attempts, String other){
        return new MessageBuilder()
                .setEmbed(new EmbedBuilder()
                    .setTitle("New Exam Request")
                    .addField("Requester", "<@"+user.getIdAsString()+">")
                    .setThumbnail(user.getAvatar())
                    .addField("Timezone", tz)
                    .addField("Previous Attempts", attempts)
                    .addField("Other Information", other)
                    .setFooter("Exambot "+Main.ver+" | Made by _11#8218", "https://cdn.discordapp.com/avatars/404882575543238656/238ea9cb4c0835a5a794fa7d93357320.png"));
    }
    static  MessageBuilder ping(){
        return new MessageBuilder().append("Pong!");
    }
    static  MessageBuilder badformat(){
        return new MessageBuilder().setEmbed(
                new EmbedBuilder()
                    .setTitle("Invalid Format")
                    .setDescription("Format: `-exam <Timezone Code> <Attempts at exam> <Any other info>`\nExample: `-exam PST 0 I'm a bit of a slow learner`")
                    .setColor(Color.RED)
                    .addField("Dev Note","Expect changes to this format, it's not that great atm")
                    .setFooter("Exambot "+Main.ver+" | Made by _11#8218", "https://cdn.discordapp.com/avatars/404882575543238656/238ea9cb4c0835a5a794fa7d93357320.png"));
    }
    static MessageBuilder error(Throwable e){
        logger.println(e.toString(),LogLevel.WARN);
        logger.println("Stacktrace below:",LogLevel.WARN);
        e.printStackTrace();
        return new MessageBuilder().setEmbed(new EmbedBuilder()
                .setColor(Color.RED)
                .setTitle("Something went wrong:")
                .setDescription(e.toString())
                .setFooter("Exambot "+Main.ver+" | Made by _11#8218", "https://cdn.discordapp.com/avatars/404882575543238656/238ea9cb4c0835a5a794fa7d93357320.png"))
                .append(Main.botowner.getMentionTag());
    }
}
