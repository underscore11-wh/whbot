package com.gmail.minecrafter11mrt;

import org.javacord.api.listener.message.*;
import org.javacord.api.entity.message.Message;
import org.javacord.api.event.message.MessageCreateEvent;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MessageListener implements MessageCreateListener {

    @Override
    public void onMessageCreate(MessageCreateEvent event){
        Message message=event.getMessage();
        Logger logger = Logger.getLogger("MessageListener");
        Main.initLogger(logger);
        Parser preparser=new Parser(event.getMessageContent());
        preparser.preParse();
        logger.log(Level.FINE,message.getIdAsString()+" "+message.getContent()+" "+message.getAuthor().getDiscriminatedName()+" "+preparser.type);
        switch(preparser.type){
            case EXAM:
                InputVal val=new InputVal(preparser.type,message);
                if(!val.lengthcheck()){
                    Messages.badformat().send(message.getChannel());
                    logger.log(Level.FINER,"Invalid Message Stynax");
                    break;
                }
                preparser.trim();
                ExamLogic logic=new ExamLogic(preparser,message);
                logger.log(Level.FINER,"Parsed results: timezone=`"+logic.timezone+"` attempts=`"+logic.attempts+"` other=`"+logic.other+"`");
                logic.sendMessage();
                break;
            case SHUTDOWN:
                if(message.getAuthor().getId()==Main.botowner.getId()){
                    Messages.shutdown().send(message.getChannel());
                    Main.shutdown();
                }else {
                    Messages.permissionError();
                    logger.log(Level.INFO,message.getAuthor().getDiscriminatedName()+" attempted to run -shutdown");
                }
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
