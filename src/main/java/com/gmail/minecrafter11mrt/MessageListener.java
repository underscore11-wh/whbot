package com.gmail.minecrafter11mrt;

import org.javacord.api.listener.message.MessageCreateListener;
import org.javacord.api.entity.message.Message;
import org.javacord.api.event.message.MessageCreateEvent;

public class MessageListener implements MessageCreateListener {

    @Override
    public void onMessageCreate(MessageCreateEvent event){
        Message message=event.getMessage();
        Parser preparser=new Parser(event.getMessageContent());
        Type command=preparser.preParse();
        switch(preparser.type){
            case EXAM:

                break;
            case HELP:
                Messages.help().send(message.getChannel());
                break;
            case PING:
                Messages.ping().send(message.getChannel());
                break;
            case NONE:
                break;
            default:
                break;
        }
    }
}
