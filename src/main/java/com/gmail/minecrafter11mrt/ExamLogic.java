package com.gmail.minecrafter11mrt;

import org.javacord.api.entity.message.Message;

public class ExamLogic {
    String attempts;
    String timezone;
    String other;
    Message message;
    public ExamLogic(Parser parser, Message mes){
        timezone=parser.content.substring(0,3);
        attempts=parser.content.substring(4,5);
        other=parser.content.substring(6);
        message=mes;
    }
    void sendMessage(){
        Messages.newrequest(message.getAuthor(),timezone,attempts,other)
                .append("Request Submitted!")
                .send(message.getChannel());
        Messages.newrequest(message.getAuthor(),timezone,attempts,other)
                .append("ROLE TAG")
                .send(Main.logchannel);
    }
}
