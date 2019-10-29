package com.gmail.minecrafter11mrt;

import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.listener.message.MessageCreateListener;
import org.javacord.api.entity.message.Message;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.entity.message.MessageBuilder;
import java.awt.*;

public class MessageClass implements MessageCreateListener {

    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        Message message = event.getMessage();
        EmbedBuilder helpembed = new EmbedBuilder()
                .setTitle("Exambot")
                .setFooter("Exambot v0.1 | Made by _11#8218", "https://cdn.discordapp.com/avatars/404882575543238656/238ea9cb4c0835a5a794fa7d93357320.png")
                .addField("-help", "Displays this message.")
                .addField("-exam", "Requests a train driving exam.\nFormat: `-exam <Timezone Code> <Attempts at exam> <Any other info>`\nExample: `-exam PST 0 I'm a bit of a slow learner`")
                .addField("-ping", "Makes the bot send a message back. Intended for debugging.")
                .setColor(Color.GREEN)
                .setThumbnail(Exambot.api.getYourself().getAvatar());
        if (message.getContent().equalsIgnoreCase("-ping")) {
            event.getChannel().sendMessage("Pong!");
        }
        if (message.getContent().startsWith("-exam")){
            System.out.println(message.getAuthor().getDiscriminatedName()+" sent message "+message.getContent());
                MessageBuilder requestembed = new MessageBuilder()
                        .setEmbed(new EmbedBuilder()
                            .setTitle("New Exam Request")
                            .addField("Requester", "<@"+message.getAuthor().getIdAsString()+">")
                            .setThumbnail(message.getAuthor().getAvatar())
                            .addField("Timezone", message.getContent().substring(6, 9))
                            .addField("Previous Attempts", message.getContent().substring(10, 11))
                            .addField("Other Information", message.getContent().substring(12)));
                requestembed.send(message.getChannel());
                Exambot.api.getTextChannelById(638474520654512128L).ifPresent(textChannel -> requestembed.append("MENTION").send(textChannel));
        }
        if (message.getContent().startsWith("-help")){
            new MessageBuilder()
                    .setEmbed(helpembed)
                    .send(message.getChannel());
        }
    }
}
