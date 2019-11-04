package com.gmail.minecrafter11mrt;

import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.entity.message.MessageBuilder;

import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class Messages {
    static MessageBuilder help(){
        return new MessageBuilder().setEmbed(new EmbedBuilder()
                .setFooter("WHBot "+WHBot.ver+" | Made by "+WHBot.botowner.getDiscriminatedName(), WHBot.botowner.getAvatar())
                .setTimestampToNow()
                .setTitle("WHBot")
                .addField("-help", "Displays this message.")
                .addField("-exam", "Requests a train driving exam.\nFormat: `-exam <Timezone Code> <Attempts at exam> <Any other info>`\nExample: `-exam PST 0 I'm a bit of a slow learner`")
                .addField("-ping", "Makes the bot send a message back. Intended for debugging.")
                .setColor(Color.GREEN)
                .setThumbnail(WHBot.api.getYourself().getAvatar())
        );
    }
    static MessageBuilder ping(){
        return new MessageBuilder().append("Pong!");
    }
    static MessageBuilder error(Throwable e,Logger logger){
        logger.log(Level.SEVERE,"Error",e);
        return new MessageBuilder().setEmbed(new EmbedBuilder()
                .setFooter("WHBot "+WHBot.ver+" | Made by "+WHBot.botowner.getDiscriminatedName(), WHBot.botowner.getAvatar())
                .setTimestampToNow()
                .setColor(Color.RED)
                .setTitle("Something went wrong:")
                .setDescription(e.toString()))
                .append(WHBot.botowner.getMentionTag());
    }
    static MessageBuilder changelog(){
        return new MessageBuilder().setEmbed(new EmbedBuilder()
                .setFooter("WHBot "+WHBot.ver+" | Made by "+WHBot.botowner.getDiscriminatedName(), WHBot.botowner.getAvatar())
                .setTimestampToNow()
                .setColor(Color.GREEN)
                .setTitle("Changelog")
                .setDescription("Latest version: "+WHBot.ver)
                .addField("v0.1","Hello World!"));
    }
}
