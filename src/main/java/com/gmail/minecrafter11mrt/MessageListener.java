package com.gmail.minecrafter11mrt;

import org.javacord.api.listener.message.*;
import org.javacord.api.entity.message.Message;
import org.javacord.api.event.message.MessageCreateEvent;

import java.util.logging.Level;

public class MessageListener implements MessageCreateListener {

    @Override
    public void onMessageCreate(MessageCreateEvent event){
        Message message=event.getMessage();
        Parser preparser=new Parser(event.getMessageContent());
        preparser.preParse();
        WHBot.logger.log(Level.FINE,message.getIdAsString()+" "+message.getContent()+" "+message.getAuthor().getDiscriminatedName()+" "+preparser.type);
        switch(preparser.type){
            case HELP:
                Messages.help().send(message.getChannel());
                break;
            case PING:
                Messages.ping().send(message.getChannel());
                break;
            case CHANGELOG:
                Messages.changelog().send(message.getChannel());
            case NONE:
                break;
            case MENTION:
                Messages.help().send(message.getChannel());
                break;
            default:
                break;
        }
    }
}
