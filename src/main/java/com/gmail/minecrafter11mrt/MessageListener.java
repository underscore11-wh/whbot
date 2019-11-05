package com.gmail.minecrafter11mrt;

import org.javacord.api.listener.message.*;
import org.javacord.api.entity.message.Message;
import org.javacord.api.event.message.MessageCreateEvent;

import java.util.logging.Level;

public class MessageListener implements MessageCreateListener {

    @Override
    public void onMessageCreate(MessageCreateEvent event){
        Message message=event.getMessage();
        WHBot.logger.log(Level.INFO,"Message Received:"+message.getContent());
        Parser preparser=new Parser(message);
        WHBot.logger.log(Level.INFO,"Attempting to preparse message "+preparser.content);
        preparser.preParse();
        WHBot.logger.log(Level.INFO,message.getIdAsString()+" "+message.getContent()+" "+message.getAuthor().getDiscriminatedName()+" "+preparser.type);
        switch(preparser.type){
            case HELP:
                Messages.help().send(message.getChannel());
                break;
            case PING:
                Messages.ping().send(message.getChannel());
                break;
            case CITIZENSHIP:
                CitLogic logic = new CitLogic(message, preparser);
                break;
            case CHANGELOG:
                Messages.changelog().send(message.getChannel());
                break;
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
