package com.gmail.minecrafter11mrt;

import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.embed.Embed;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.listener.message.MessageCreateListener;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.channel.Channel;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.DiscordApi;
import java.awt.*;
import java.io.*;
import org.javacord.*;
import java.util.Set;

public class MessageClass implements MessageCreateListener {

    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        Message message = event.getMessage();
        if (message.getContent().equalsIgnoreCase("-ping")) {
            event.getChannel().sendMessage("Pong!");
        }
        if (message.getContent().startsWith("-exam")){
            System.out.println(message.getAuthor().getDiscriminatedName()+" sent message "+message.getContent());
                MessageBuilder requestembed = new MessageBuilder()
                        .setEmbed(new EmbedBuilder()
                            .setTitle("New Exam Request")
                            .addField("Requestor", "<@"+message.getAuthor().getIdAsString()+">")
                            .setThumbnail(message.getAuthor().getAvatar())
                            .addField("Timezone", message.getContent().substring(6, 9))
                            .addField("Previous Attempts", message.getContent().substring(10, 11))
                            .addField("Other Information", message.getContent().substring(12)));
                requestembed.send(message.getChannel());
                Main.api.getTextChannelById(638474520654512128L).ifPresent(textChannel -> requestembed.append("MENTION").send(textChannel));
        }
        if (message.getContent().startsWith("-help")){
            PrefabMessages.helpmessage().send(message.getChannel());
        }
    }
}
