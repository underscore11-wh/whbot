package com.gmail.minecrafter11mrt;

import org.javacord.api.entity.message.Message;

import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;

class ExamLogic {
    String attempts;
    String timezone;
    String other;
    private Message message;
    private static Logger logger = Logger.getLogger("ExamLogic");
    ExamLogic(Parser parser, Message mes){
        Main.initLogger(logger);
        timezone=parser.content.substring(0,3);
        attempts=parser.content.substring(4,5);
        other=parser.content.substring(6);
        message=mes;
        logger.log(Level.FINER,"New ExamLogic initialized",this);
    }
    void sendMessage() {
        Messages.newrequest(message.getAuthor(), timezone, attempts, other)
                .append("Request Submitted!\nIf you haven't already, please watch the Train-ing 101 video: [LINK]")
                .send(message.getChannel());
        Messages.newrequest(message.getAuthor(), timezone, attempts, other)
                .append("ROLE TAG")
                .send(Main.logchannel);
        long[] pair={0,0};
        logger.log(Level.FINER,"Entering Lambada");
        Messages.newrequest(message.getAuthor(), timezone, attempts, other).send(Main.queuechannel).thenAcceptAsync(queuemessage ->{
            logger.log(Level.FINER,"In Lambada");
            pair[0]=queuemessage.getId();
            logger.log(Level.FINER,"Message ID:"+pair[0]);
            pair[1]=message.getAuthor().getId();
            logger.log(Level.FINER,"Requester:"+pair[1]);
            logger.log(Level.FINER,"Done Lambada");
        }).exceptionally(throwable -> {
            Messages.error(throwable, logger).send(message.getChannel());
            return null;
        });
        Main.addQueuedMessage(pair[0],pair[1]);
    }
}

