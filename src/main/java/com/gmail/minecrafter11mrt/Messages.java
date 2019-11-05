package com.gmail.minecrafter11mrt;

import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.user.User;

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
                .addField("-ping", "Makes the bot send a message back. Intended for debugging.")
                .addField("-citizenship","Submits a citizenship request.\nFormat: `-citizenship <IGN>|<Any past offenses from other servers`\ne.g. `-citizenship Underscore11|Got temp banned on Hypixel for fly hacks once`\nMake sure to attach your screenshot")
                .setColor(Color.GREEN)
                .setThumbnail(WHBot.api.getYourself().getAvatar()));
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
                .addField("v0.2", "-citizenship command added")
                .addField("v0.1","Hello World!"));
    }
    static MessageBuilder citRequest(String screenshot, String username, String pastOffenses, User requester){
        return new MessageBuilder().setEmbed(new EmbedBuilder()
                .setFooter("WHBot "+WHBot.ver+" | Made by "+WHBot.botowner.getDiscriminatedName(), WHBot.botowner.getAvatar())
                .setTimestampToNow()
                .setColor(Color.GREEN)
                .setTitle("New Citizenship Request")
                .addField("IGN:",username,true)
                .addField("Discord User", requester.getMentionTag(),true)
                .addField("Past Offenses", pastOffenses)
                .setImage(screenshot));
    }
    static MessageBuilder badFormat(String title, String description){
        return new MessageBuilder().setEmbed(new EmbedBuilder()
                .setFooter("WHBot "+WHBot.ver+" | Made by "+WHBot.botowner.getDiscriminatedName(), WHBot.botowner.getAvatar())
                .setTimestampToNow()
                .setColor(Color.RED)
                .setTitle(title)
                .setDescription(description));
    }
}
