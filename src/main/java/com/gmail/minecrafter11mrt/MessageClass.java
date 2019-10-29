package com.gmail.minecrafter11mrt;

import org.javacord.api.listener.message.MessageCreateListener;
import org.javacord.api.entity.message.Message;
import org.javacord.api.event.message.MessageCreateEvent;

public class MessageClass implements MessageCreateListener {

    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        Message message = event.getMessage();
        String content = message.getContent();
        if (message.getContent().equalsIgnoreCase("-ping")) {
            event.getChannel().sendMessage("Pong!");
        }
        if (message.getContent().startsWith("-exam")){
            System.out.println(message.getAuthor().getDiscriminatedName()+" sent message "+message.getContent());
                Messages.newrequest(message.getAuthor(), content.substring(6,9), content.substring(10,11), content.substring(12)).send(message.getChannel());
                Main.api.getTextChannelById(638474520654512128L).ifPresent(textChannel -> Messages.newrequest(message.getAuthor(), content.substring(6,9), content.substring(10,11), content.substring(12))
                        .append("MENTION").send(textChannel));
        }
        if (message.getContent().startsWith("-help")){
            Messages.help().send(message.getChannel());
        }
    }
}
