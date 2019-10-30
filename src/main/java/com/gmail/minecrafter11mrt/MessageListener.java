package com.gmail.minecrafter11mrt;

import com.gmail.minecrafter11mrt.lib.Logger;
import org.javacord.api.listener.message.*;
import org.javacord.api.entity.message.Message;
import org.javacord.api.event.message.MessageCreateEvent;

public class MessageListener implements MessageCreateListener {

    @Override
    public void onMessageCreate(MessageCreateEvent event){
        Message message=event.getMessage();
        Logger logger = new Logger("MessageListener");
        Parser preparser=new Parser(event.getMessageContent());
        preparser.preParse();
        System.out.print(message);
        System.out.print(message.getAuthor());
        System.out.println(preparser.type);
        switch(preparser.type){
            case EXAM:
                InputVal val=new InputVal(preparser.type,message);
                if(!val.lengthcheck()){
                    Messages.badformat().send(message.getChannel());
                    break;
                }
                preparser.trim();
                System.out.println("Trimmed message to "+preparser.content);
                ExamLogic logic=new ExamLogic(preparser,message);
                System.out.println("Parsed results: timezone=`"+logic.timezone+"` attempts=`"+logic.attempts+"` other=`"+logic.other+"`");
                logic.sendMessage();
                break;
            case HELP:
                Messages.help().send(message.getChannel());
                break;
            case PING:
                Messages.ping().send(message.getChannel());
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
