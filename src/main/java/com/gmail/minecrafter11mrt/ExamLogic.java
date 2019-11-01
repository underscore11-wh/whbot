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
    }
}

