package com.gmail.minecrafter11mrt;

import org.javacord.api.entity.message.MessageAuthor;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.entity.message.MessageBuilder;

import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class Messages {
    static MessageBuilder help(){
        return new MessageBuilder().setEmbed(new EmbedBuilder()
                .setFooter("Exambot "+Main.ver+" | Made by _11#8218", Main.botowner.getAvatar())
                .setTimestampToNow()
                .setTitle("Exambot")
                .addField("-help", "Displays this message.")
                .addField("-exam", "Requests a train driving exam.\nFormat: `-exam <Timezone Code> <Attempts at exam> <Any other info>`\nExample: `-exam PST 0 I'm a bit of a slow learner`")
                .addField("-ping", "Makes the bot send a message back. Intended for debugging.")
                .setColor(Color.GREEN)
                .setThumbnail(Main.api.getYourself().getAvatar())
        );
    }
    static MessageBuilder newrequest(MessageAuthor user, String tz, String attempts, String other){
        return new MessageBuilder().setEmbed(new EmbedBuilder()
                .setFooter("Exambot "+Main.ver+" | Made by _11#8218", Main.botowner.getAvatar())
                .setTimestampToNow()
                .setTitle("New Exam Request")
                .addField("Requester", "<@"+user.getIdAsString()+">")
                .setThumbnail(user.getAvatar())
                .addField("Timezone", tz)
                .addField("Previous Attempts", attempts)
                .addField("Other Information", other));
    }
    static MessageBuilder ping(){
        return new MessageBuilder().append("Pong!");
    }
    static MessageBuilder badformat(){
        return new MessageBuilder().setEmbed(new EmbedBuilder()
                .setFooter("Exambot "+Main.ver+" | Made by _11#8218", Main.botowner.getAvatar())
                .setTimestampToNow()
                .setTitle("Invalid Format")
                .setDescription("Format: `-exam <Timezone Code> <Attempts at exam> <Any other info>`\nExample: `-exam PST 0 I'm a bit of a slow learner`")
                .setColor(Color.RED)
                .addField("Dev Note","Expect changes to this format, it's not that great atm"));
    }
    static MessageBuilder error(Throwable e,Logger logger){
        logger.log(Level.SEVERE,"Error",e);
        return new MessageBuilder().setEmbed(new EmbedBuilder()
                .setFooter("Exambot "+Main.ver+" | Made by _11#8218", Main.botowner.getAvatar())
                .setTimestampToNow()
                .setColor(Color.RED)
                .setTitle("Something went wrong:")
                .setDescription(e.toString()))
                .append(Main.botowner.getMentionTag());
    }
    static private EmbedBuilder baseEmbed = new EmbedBuilder()
            .setFooter("Exambot "+Main.ver+" | Made by _11#8218", Main.botowner.getAvatar())
            .setTimestampToNow();
}
