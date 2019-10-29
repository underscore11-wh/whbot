package com.gmail.minecrafter11mrt;

import org.javacord.api.listener.message.*;
import org.javacord.api.entity.message.Message;
import org.javacord.api.event.message.MessageCreateEvent;

public class MessageListener implements MessageCreateListener {

    @Override
    public void onMessageCreate(MessageCreateEvent event){
        Message message=event.getMessage();
        Parser preparser=new Parser(event.getMessageContent());
        preparser.preParse();
        System.out.println("New Message from"+message.getAuthor().getDiscriminatedName()+", type "+preparser.type);
        switch(preparser.type){
            case EXAM:
                preparser.trim();
                System.out.println("Trimmed message to "+preparser.content);
                ExamParser parser=new ExamParser(preparser);
                System.out.println("Parsed results: timezone=`"+parser.timezone+"` attempts=`"+parser.attempts+"` other=`"+parser.other+"`");
                Messages.newrequest(message.getAuthor(),parser.timezone,parser.attempts,parser.other)
                        .append("Request Submitted!")
                        .send(message.getChannel());
                Messages.newrequest(message.getAuthor(),parser.timezone,parser.attempts,parser.other)
                        .append("ROLE TAG")
                        .send(Main.logchannel);
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
